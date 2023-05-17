package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	public Window() {
		
		this.setContentPane(new StartMenu(this));
		this.setSize(600, 500);
		this.setTitle("Interfaces Programación");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}

}
