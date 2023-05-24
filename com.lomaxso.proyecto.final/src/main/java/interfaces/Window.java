package interfaces;

import java.util.ArrayList;

import javax.swing.JFrame;

import entities.Enemy;
import entities.Player;
import enums.MapZoneType;

public class Window extends JFrame {
	public Player player;

	// Getters and Setters.
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	// Constructor.
	public Window(Player player) {
		this.player = player;

		this.setContentPane(new StartMenu(this));
		this.setSize(600, 500);
		this.setTitle("Interfaces Programación");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	} // window

	public void changeScreen(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(StartMenu.class)) {
			this.setContentPane(new StartMenu(this));
		} // if
		if (clase.equals(MapMenu.class)) {
			this.setContentPane(new MapMenu(this));
		} // if
		if (clase.equals(SelectLevelMenu.class)) {
			this.setContentPane(new SelectLevelMenu(this));
		} // if
		this.getContentPane().setVisible(true);
	} // changeScreen

	public void selectLevel(MapZoneType type, ArrayList<Enemy> enemies, Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(LevelMenu.class)) {
			this.setContentPane(new LevelMenu(type, enemies, this));
		} // if
		this.getContentPane().setVisible(true);
	} // selectLevel

} // class
