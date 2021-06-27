package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * this class is the panel wich show the end of the game and the classement of players
 */

public class EndGame extends JPanel {

    private JLabel titre;
    private ArrayList<JLabel> joueurs;
    private JButton retour;
	private JLabel victoire;



	public EndGame(int nb) {

		joueurs = new ArrayList<JLabel>();
		this.setSize(1000,650);
        this.initComponents();

        GridLayout total = new GridLayout(3,1);
        this.setLayout(total);

        JPanel haut = new JPanel();
        haut.setBackground(new Color(0,0,0,0));
        haut.add(titre);
        this.add(haut);

        JPanel centre = new JPanel();
		GridLayout gridCentre = new GridLayout(nb*2+2,3);
		centre.setLayout(gridCentre);
		centre.setBackground(new Color(112,62,32,255));
		centre.add(new JLabel(""));
		victoire = new JLabel("Le batisseur du royaume est: ");
		victoire.setForeground(new Color(254,193,0,255));
        victoire.setBackground(new Color(107,46,23));
		victoire.setHorizontalAlignment(SwingConstants.CENTER);
		victoire.setFont(new Font("Serif", Font.BOLD, 35));
		centre.add(victoire);
		centre.add(new JLabel(""));
		centre.add(new JLabel(""));
		centre.add(new JLabel(""));
		centre.add(new JLabel(""));
        for(int i=1;i<=nb;i++){
            JLabel a = new JLabel(i+":");
            a.setHorizontalAlignment(SwingConstants.TRAILING);
            a.setForeground(new Color(254,193,0,255));
            a.setHorizontalAlignment(SwingConstants.RIGHT);
            a.setFont(new Font("Serif", Font.BOLD, 35));
            a.setBackground(new Color(107,46,23));
            centre.add(a);
            joueurs.add(new JLabel("Nom du joueur"));
			joueurs.get(i-1).setForeground(new Color(254,193,0,255));
			joueurs.get(i-1).setHorizontalAlignment(SwingConstants.CENTER);
            joueurs.get(i-1).setFont(new Font("Serif", Font.BOLD, 25));
            joueurs.get(i-1).setBackground(new Color(107,46,23));
            centre.add(joueurs.get(i-1));
            centre.add(new JLabel());
            centre.add(new JLabel());
            centre.add(new JLabel());
            centre.add(new JLabel());
        }
        this.add(centre);


        JPanel bas = new JPanel();
        bas.setBackground(new Color(0,0,0,0));
        GridLayout gridBas = new GridLayout(3,5);
		bas.setLayout(gridBas);
        for(int i = 0;i<5;i++){
            bas.add(new JLabel());
        }
        bas.add(new JLabel());
		bas.add(new JLabel());
        bas.add(retour);
        bas.add(new JLabel());
		bas.add(new JLabel());
        for(int i = 0;i<5;i++){
            bas.add(new JLabel());
        }

        this.add(bas);

        this.setBackground(new Color(0,0,0,0));

	}

     /**
	 * initialize the components with picture and set the colors
	 * @param nb THE NUMBER OF PLAYERS
	 */
    public void initComponents(){
		titre = new JLabel(new ImageIcon("../images/Titre.png"));
        retour = new JButton(new ImageIcon("../images/BRetour.png"));
        retour.setBackground(new Color(255,192,0));
		retour.setBorderPainted(false);
        joueurs = new ArrayList<JLabel>();
	}

    public ArrayList<JLabel> getJoueurs() {
        return joueurs;
    }

	public void setextVictoire(String victoire) {
		this.victoire.setText("Le batisseur du royaume est: " + victoire);
	}

	public void setNomJoueurs(ArrayList<String> liste){
		int i=0;
		for(JLabel elem : joueurs){
			elem.setText(liste.get(i));
			i++;
		}
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

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new EndGame(3));
        f.setVisible(true);
    }
}
