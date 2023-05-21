package interfaces;

import javax.swing.JFrame;

import maps.MapLevel;

public class Window extends JFrame {

	public Window() {

		this.setContentPane(new StartMenu(this));
		this.setSize(600, 500);
		this.setTitle("Interfaces Programación");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	} // wind

	public void changeScreen(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(StartMenu.class)) {
			this.setContentPane(new StartMenu(this));
		} // if
		if (clase.equals(MapMenu.class)) {
			this.setContentPane(new MapMenu(this));
		} // if
		if (clase.equals(HillLandMenu.class)) {
			this.setContentPane(new HillLandMenu(this));
		} // if
		if (clase.equals(LevelMenu.class)) {
			this.setContentPane(new LevelMenu(this));
		} // if

		this.getContentPane().setVisible(true);

	} // changeScreen
	
	public void selectLevel(MapLevel ml) {
		this.getContentPane().setVisible(false);
		
	} // selectLevel
	
} // class
