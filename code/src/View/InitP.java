package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * this class represent the page where the user type the name of the players
 */
public class InitP extends JPanel {

    private int nb;
    private JLabel titre;
    private ArrayList<JTextField> joueurs;
    private JButton confirmer;
    private JButton retour;
    private JLabel warn;


	public InitP(int nb) {
		this.setSize(1000,650);
        this.initComponents();

        this.nb = nb;

        GridLayout total = new GridLayout(3,1);
        this.setLayout(total);

        JPanel haut = new JPanel();
        haut.setBackground(new Color(0,0,0,0));
        haut.add(titre);
        this.add(haut);

        JPanel centre = new JPanel();
		GridLayout gridCentre = new GridLayout(nb*2,3);
		centre.setLayout(gridCentre);
		centre.setBackground(new Color(0,0,0,0));

        for(int i=1;i<=nb;i++){
            JLabel a = new JLabel("Nom du joueur " + i+":");
            a.setForeground(new Color(254,193,0,255));
            a.setHorizontalAlignment(SwingConstants.CENTER);
            a.setFont(new Font("Serif", Font.BOLD, 20));
            centre.add(a);
            joueurs.add(new JTextField("Entrer le nom ici"));
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

        for(int i = 0;i<5;i++){
            bas.add(new JLabel());
        }


		bas.setLayout(gridBas);
        bas.add(new JLabel());
        bas.add(retour);
        warn = new JLabel();
        warn.setForeground(new Color(255,192,0));

        bas.add(warn);
        bas.add(confirmer);
        bas.add(new JLabel());

        for(int i = 0;i<5;i++){
            bas.add(new JLabel());
        }

        this.add(bas);

        this.setBackground(new Color(0,0,0,0));

	}

     /**
	 * initialize the components with picture and set the colors
	 */
    public void initComponents(){
		titre = new JLabel(new ImageIcon("../images/Titre.png"));

        confirmer = new JButton(new ImageIcon("../images/BConfirmer.png"));
        confirmer.setBackground(new Color(255,192,0));
		confirmer.setBorderPainted(false);

        retour =  new JButton((new ImageIcon(((new ImageIcon("../images/BRetour.png").getImage().getScaledInstance(180, 60,java.awt.Image.SCALE_SMOOTH))))));
        retour.setBackground(new Color(255,192,0));
		retour.setBorderPainted(false);

        joueurs = new ArrayList<JTextField>();
	}

    public JButton getConfirmer() {
        return confirmer;
    }

    public JButton getRetour() {
        return retour;
    }

    public ArrayList<JTextField> getJoueurs() {
        return joueurs;
    }

    public JLabel getWarn() {
        return warn;
    }

    /**
     * is used to see if all the textField are right completed
     * @return
     */
    public boolean complet(){
        for(JTextField elem:joueurs){
            if(elem.getText().equals("Entrer le nom ici") || elem.getText().trim().equals("")){
                return false;
            }
        }
        return true;
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
