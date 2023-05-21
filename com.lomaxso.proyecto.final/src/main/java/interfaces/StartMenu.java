package interfaces;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import entities.Player;

public class StartMenu extends JPanel{

	public StartMenu(Player player, Window w) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				w.changeScreen(player, MapMenu.class);
				// load txt
			} // mouse
		});
		btnContinue.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnContinue.insets = new Insets(0, 0, 5, 5);
		gbc_btnContinue.gridx = 1;
		gbc_btnContinue.gridy = 1;
		add(btnContinue, gbc_btnContinue);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				w.changeScreen(player, MapMenu.class);
				// create txt
			} // mouse
		});
		btnNewGame.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewGame.gridx = 1;
		gbc_btnNewGame.gridy = 2;
		add(btnNewGame, gbc_btnNewGame);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
		GridBagConstraints gbc_btnOptions = new GridBagConstraints();
		gbc_btnOptions.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOptions.insets = new Insets(0, 0, 5, 5);
		gbc_btnOptions.gridx = 1;
		gbc_btnOptions.gridy = 3;
		add(btnOptions, gbc_btnOptions);
		this.setVisible(true);
	}
}
