package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * this panel represent the page of the menu in the application
 */
public class Menu extends JPanel{

	private JButton jouer;
	private JButton regles;
	private JButton quitter;
	private JButton options;
	private JLabel titre;
	private JLabel blank5;
	private JLabel blank3;
	private JLabel blank4;
	private JLabel blank6;

	public Menu() {
		this.setSize(1000,650);
        this.initComponents();

		BorderLayout border = new BorderLayout();
		this.setLayout(border);

		JPanel haut = new JPanel();
		haut.add(titre);
		haut.setBackground(new Color(0,0,0,0));
		this.add(haut,BorderLayout.NORTH);

		JPanel centre = new JPanel();
		GridLayout gridCentre = new GridLayout(8,1);
		centre.setLayout(gridCentre);
		centre.setBackground(new Color(0,0,0,0));
		centre.add(jouer);
		centre.add(blank3);
		centre.add(regles);
		centre.add(blank4);
		centre.add(options);
		centre.add(blank5);
		centre.add(quitter);
		centre.add(blank6);
		jouer.setAlignmentX(Component.CENTER_ALIGNMENT);
		regles.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitter.setAlignmentX(Component.CENTER_ALIGNMENT);
		options.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(centre,BorderLayout.CENTER);

	}

	/**
	 * initialize the components with picture and set the colors
	 */
	public void initComponents(){
		jouer = new JButton();
		jouer.setIcon(new ImageIcon("../images/BJouer.png"));
		jouer.setBackground(new Color(255,192,0));
		jouer.setBorderPainted(false);

		regles =  new JButton(new ImageIcon("../images/BRegles.png"));
		regles.setBackground(new Color(255,192,0));
		regles.setBorderPainted(false);

		quitter = new JButton(new ImageIcon("../images/BQuitter.png"));
		quitter.setBackground(new Color(255,192,0));
		quitter.setBorderPainted(false);

		options = new JButton(new ImageIcon("../images/BOptions.png"));
		options.setBackground(new Color(255,192,0));
		options.setBorderPainted(false);

		titre = new JLabel(new ImageIcon("../images/Titre.png"));
		titre.setOpaque(false);

		blank3 = new JLabel();
		blank4 = new JLabel();
		blank5 = new JLabel();
		blank6 = new JLabel();
	}

	public JButton getJouer() {
		return this.jouer;
	}

	public JButton getRegles() {
		return this.regles;
	}

	public JButton getQuitter() {
		return this.quitter;
	}

	public JButton getOptions() {
		return options;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			java.awt.image.BufferedImage bufimage = ImageIO.read(new File("../images/fond.jpg")); // path a changer
			g.drawImage(bufimage, 0,0,1500,900,null); // dimensions a adapter si besoin
		} catch (IOException e) {
			System.out.println("Error : Pages : paintComponent() : " + e.getMessage());
		}
	}
}