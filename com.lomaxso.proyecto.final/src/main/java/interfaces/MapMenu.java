package interfaces;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import entities.Player;

public class MapMenu extends JPanel {
	public MapMenu(Player player, Window w) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnLavaWorld = new JButton("Lava World");
		btnLavaWorld.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnLavaWorld = new GridBagConstraints();
		gbc_btnLavaWorld.fill = GridBagConstraints.BOTH;
		gbc_btnLavaWorld.insets = new Insets(0, 0, 5, 5);
		gbc_btnLavaWorld.gridx = 1;
		gbc_btnLavaWorld.gridy = 1;
		add(btnLavaWorld, gbc_btnLavaWorld);
		
		JButton btnMountain = new JButton("Mountains");
		btnMountain.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnMountain = new GridBagConstraints();
		gbc_btnMountain.fill = GridBagConstraints.BOTH;
		gbc_btnMountain.insets = new Insets(0, 0, 5, 5);
		gbc_btnMountain.gridx = 2;
		gbc_btnMountain.gridy = 1;
		add(btnMountain, gbc_btnMountain);
		
		JButton btnIcepeaks = new JButton("Ice Peaks");
		btnIcepeaks.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_btnIcepeaks = new GridBagConstraints();
		gbc_btnIcepeaks.fill = GridBagConstraints.BOTH;
		gbc_btnIcepeaks.insets = new Insets(0, 0, 5, 5);
		gbc_btnIcepeaks.gridx = 1;
		gbc_btnIcepeaks.gridy = 2;
		add(btnIcepeaks, gbc_btnIcepeaks);
		
		JButton btnHillLand = new JButton("Hill Lands");
		btnHillLand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				w.changeScreen(player, HillLandMenu.class);
			} // mouse
		});
		btnHillLand.setForeground(new Color(0, 255, 0));
		GridBagConstraints gbc_btnHillLand = new GridBagConstraints();
		gbc_btnHillLand.fill = GridBagConstraints.BOTH;
		gbc_btnHillLand.insets = new Insets(0, 0, 5, 5);
		gbc_btnHillLand.gridx = 2;
		gbc_btnHillLand.gridy = 2;
		add(btnHillLand, gbc_btnHillLand);
		this.setVisible(true);
	}

} // class
