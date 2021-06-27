package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * this panel represent the page where the user can select the save that he want to choose
 */
public class Load extends JPanel {

    private int nb;
    private JLabel titre;
    private ArrayList<JButton> saves;
    private JButton retour;


	public Load() {
		this.setSize(1000,650);
        this.initComponents();

        GridLayout total = new GridLayout(3,1);
        this.setLayout(total);

        JPanel haut = new JPanel();
        haut.setBackground(new Color(0,0,0,0));
        haut.add(titre);
        this.add(haut);

        String[] pathnames;
		File f = new File("../saves");
		pathnames = f.list();

        JPanel centre = new JPanel();
		GridLayout gridCentre = new GridLayout(pathnames.length*2+2,1);
		centre.setLayout(gridCentre);
		centre.setBackground(new Color(0,0,0,0));

        JLabel ins = new JLabel("Cliquez sur la sauvegarde que vous souhaitez charger ");
		ins.setForeground(new Color(0,0,0));
		ins.setHorizontalAlignment(SwingConstants.CENTER);
		ins.setFont(new Font("Serif", Font.BOLD, 35));
		centre.add(ins);
        centre.add(new JLabel());

		for (String pathname : pathnames) {
            JButton b = new JButton(pathname);
            b.setForeground(new Color(0,0,0));
            b.setBackground(new Color(255,192,0));
            b.setBorderPainted(false);
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setFont(new Font("Serif", Font.BOLD, 25));
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            saves.add(b);
            centre.add(b);
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
		bas.add(new JLabel());
		retour.setBackground(new Color(255,192,0));
		retour.setBorderPainted(false);
        bas.add(retour);
        bas.add(new JLabel());
		bas.add(new JLabel());
        for(int i = 0;i<5;i++){
            bas.add(new JLabel());
        }

        this.add(bas);

	}

    /**
	 * initialize the components with picture and set the colors
	 */
    public void initComponents(){
		titre = new JLabel(new ImageIcon("../images/Titre.png"));
        retour =  new JButton(new ImageIcon("../images/BRetour.png"));
		retour.setBackground(new Color(255,192,0));
        saves = new ArrayList<JButton>();
	}

    public JButton getRetour() {
        return retour;
    }

    public ArrayList<JButton> getSaves() {
        return saves;
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