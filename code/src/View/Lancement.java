package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * this panel represent the page where the user can choose the number of players wich are going to play
 */
public class Lancement extends JPanel{

	private JButton QJoueur;
	private JButton DJoueur;
	private JButton TJoueur;
	private JButton retour;
	private JLabel titre;
	private JLabel blank1;
	private JLabel blank2;
	private JLabel blank3;
	private JLabel blank4;

	public Lancement() {
		this.setSize(1000,650);
        this.initComponents();

		BorderLayout border = new BorderLayout();
		this.setLayout(border);

		JPanel haut = new JPanel();
		haut.setBackground(new Color(0,0,0,0));
		haut.add(titre);
		this.add(haut,BorderLayout.NORTH);

		JPanel centre = new JPanel();
		GridLayout gridCentre = new GridLayout(8,1);
		centre.setLayout(gridCentre);
		centre.setBackground(new Color(0,0,0,0));

		centre.add(DJoueur);
		centre.add(blank2);
		centre.add(TJoueur);
		centre.add(blank3);
		centre.add(QJoueur);
		centre.add(blank1);
		centre.add(retour);
		centre.add(blank4);
		QJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
		DJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
		TJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(centre,BorderLayout.CENTER);


	}

	 /**
	 * initialize the components with picture and set the colors
	 */
	public void initComponents(){
		QJoueur = new JButton(new ImageIcon("../images/QJoueur.png"));
		QJoueur.setBackground(new Color(255,192,0));
		QJoueur.setBorderPainted(false);

		DJoueur =  new JButton(new ImageIcon("../images/BDJoueur.png"));
		DJoueur.setBackground(new Color(255,192,0));
		DJoueur.setBorderPainted(false);

		TJoueur = new JButton(new ImageIcon("../images/BTJoueur.png"));
		TJoueur.setBackground(new Color(255,192,0));
		TJoueur.setBorderPainted(false);

		titre = new JLabel(new ImageIcon("../images/Titre.png"));

		retour =  new JButton(new ImageIcon("../images/BRetour.png"));
		retour.setBackground(new Color(255,192,0));
		retour.setBorderPainted(false);

		blank1 = new JLabel();
		blank3 = new JLabel();
		blank2 = new JLabel();
		blank4 = new JLabel();
	}

	public JButton getQJoueur() {
		return QJoueur;
	}

	public JButton getDJoueur() {
		return DJoueur;
	}

	public JButton getTJoueur() {
		return TJoueur;
	}

	public JButton getRetour() {
		return retour;
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