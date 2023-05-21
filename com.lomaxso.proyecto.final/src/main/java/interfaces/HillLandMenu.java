package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HillLandMenu extends JPanel {
	
	public HillLandMenu(Window w) {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnLevel1 = new JButton("Level 1");
		btnLevel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				w.changeScreen(LevelMenu.class);
			} // mouse
		});
		GridBagConstraints gbc_btnLevel1 = new GridBagConstraints();
		gbc_btnLevel1.insets = new Insets(0, 0, 5, 5);
		gbc_btnLevel1.gridx = 1;
		gbc_btnLevel1.gridy = 1;
		add(btnLevel1, gbc_btnLevel1);
	}

} // class
