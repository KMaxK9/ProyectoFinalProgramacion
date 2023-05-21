package interfaces;

import javax.swing.JFrame;

import entities.Player;
import maps.MapLevel;

public class Window extends JFrame {

	public Window(Player player) {

		this.setContentPane(new StartMenu(player, this));
		this.setSize(600, 500);
		this.setTitle("Interfaces Programación");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	} // wind

	public void changeScreen(Player player, Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(StartMenu.class)) {
			this.setContentPane(new StartMenu(player, this));
		} // if
		if (clase.equals(MapMenu.class)) {
			this.setContentPane(new MapMenu(player, this));
		} // if
		if (clase.equals(HillLandMenu.class)) {
			this.setContentPane(new HillLandMenu(player, this));
		} // if
		if (clase.equals(LevelMenu.class)) {
			this.setContentPane(new LevelMenu(player, this));
		} // if

		this.getContentPane().setVisible(true);

	} // changeScreen
	
	public void selectLevel(MapLevel ml) {
		this.getContentPane().setVisible(false);
		
	} // selectLevel
	
} // class
