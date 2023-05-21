package interfaces;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import entities.Player;

public class LevelMenu extends JPanel {
	public LevelMenu(Player player, Window w) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAttack.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack.gridx = 1;
		gbc_btnAttack.gridy = 1;
		add(btnAttack, gbc_btnAttack);
		
		JButton btnDefend = new JButton("Defend");
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
	}

} // class
