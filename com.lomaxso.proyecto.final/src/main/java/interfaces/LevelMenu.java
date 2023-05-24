package interfaces;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.Enemy;
import enums.MapZoneType;
import exceptions.EntityNotExistsExpection;

public class LevelMenu extends JPanel {

	private Enemy currentEnemy;
	private Window window;
	private Short entitiesLastDefense;
	private ArrayList<Enemy> enemies;
	private MapZoneType mapZone;

	// Getters and Setters.

	// Cuando matas al enemigo, recargas esta pantalla LevelMenu, para que te luche
	// con el siguente del array
	// A no ser que detectes que w.levelEnemies.isEmpty(), entonces vete a dobde
	// creas conveniente.
	public LevelMenu(MapZoneType mapType, ArrayList<Enemy> enemies, Window w) {
		window = w; // sets the local Window to the given Window.
		this.enemies = new ArrayList<Enemy>(enemies); // copies the given ArrayList.
		if (circulateEnemies()) {
			try { // sets Entity's life to it's original via the DataBase.
				currentEnemy.enemysLife();
			} catch (SQLException | EntityNotExistsExpection e) {
				e.printStackTrace();
			} // try / catch

			System.out.println("Enemigo: " + currentEnemy.getName() + " tiene " + currentEnemy.getLife()
					+ " pts vida y " + currentEnemy.getDefense() + " DFN " + currentEnemy.getDamage() + " ATK.");
			System.out.println("Jugador: " + w.getPlayer().getName() + " tiene " + w.getPlayer().getLife()
					+ " pts vida y " + w.getPlayer().getDefense() + " DFN " + w.getPlayer().getDamage() + " ATK.");
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnAttack = new JButton("Attack");
		btnAttack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn(true);
			} // mouse
		});
		btnAttack.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAttack.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack.gridx = 1;
		gbc_btnAttack.gridy = 1;
		add(btnAttack, gbc_btnAttack);

		JButton btnDefend = new JButton("Defend");
		btnDefend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn(false);
			} // mouse
		});
		btnDefend.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
		GridBagConstraints gbc_btnDefend = new GridBagConstraints();
		gbc_btnDefend.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDefend.insets = new Insets(0, 0, 5, 5);
		gbc_btnDefend.gridx = 2;
		gbc_btnDefend.gridy = 1;
		add(btnDefend, gbc_btnDefend);

		JButton btnCure = new JButton("Cure");
		btnCure.setToolTipText("Cure yourself with potions.");
		btnCure.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
		GridBagConstraints gbc_btnCure = new GridBagConstraints();
		gbc_btnCure.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCure.insets = new Insets(0, 0, 0, 5);
		gbc_btnCure.gridx = 1;
		gbc_btnCure.gridy = 2;
		add(btnCure, gbc_btnCure);

		JButton btnDamage = new JButton("Damage");
		btnDamage.setToolTipText("Cure yourself with potions.");
		btnDamage.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
		GridBagConstraints gbc_btnDamage = new GridBagConstraints();
		gbc_btnDamage.insets = new Insets(0, 0, 0, 5);
		gbc_btnDamage.gridx = 2;
		gbc_btnDamage.gridy = 2;
		add(btnDamage, gbc_btnDamage);
		} // if
	} // levelMenu

	private void turn(boolean b) {
		entitiesLastDefense = window.getPlayer().playerAction(b, currentEnemy, entitiesLastDefense);
		if (checkAlive()) { // Player still alive
			entitiesLastDefense = currentEnemy.enemyAction(window.getPlayer(), entitiesLastDefense);
			checkAlive();
		} // if
	} // turn

	private boolean checkAlive() {
		if (window.getPlayer().getLife() <= 0) {
			JOptionPane.showMessageDialog(window, "You have been Killed.", "Death!", JOptionPane.ERROR_MESSAGE);
			window.changeScreen(SelectLevelMenu.class);
			return false;
		} // if
		if (currentEnemy.getLife() <= 0) {
			if (!enemies.isEmpty()) {
				JOptionPane.showMessageDialog(window, "Has Matado a un enemigo.", "You killed an Enemy!",
						JOptionPane.INFORMATION_MESSAGE);
				window.selectLevel(mapZone, enemies, LevelMenu.class);
				return false;
			} else {
				JOptionPane.showMessageDialog(window, "Has Matado a todos los enemigos.", "Level Complete!",
						JOptionPane.ERROR_MESSAGE);
				window.changeScreen(SelectLevelMenu.class);
				return false;
			} // if / else
		} // if
		return true;
	} // checkAlive

	private boolean circulateEnemies() {
		if (enemies.isEmpty()) {
			window.changeScreen(SelectLevelMenu.class);
			return false;
		} else {
			currentEnemy = enemies.get(0); // gets the first Enemy in the given ArrayList.
			enemies.remove(0); // removes the first Enemy in the given ArrayList.
			entitiesLastDefense = currentEnemy.getDefense();
			return true;
		} // if
	} // circulateEnemies

} // class
