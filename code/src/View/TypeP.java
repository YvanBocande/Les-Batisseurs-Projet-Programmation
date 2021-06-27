package View;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TypeP extends JPanel{
    private JButton nouvelle;
	private JButton charger;
    private JButton retour;
	private JLabel titre;
	private JLabel blank1;
	private JLabel blank2;
    private JLabel blank3;
    private JLabel blank4;


	public TypeP() {
		this.setSize(1000,650);
        this.initComponents();

		BorderLayout border = new BorderLayout();
		this.setLayout(border);

		JPanel haut = new JPanel();
		haut.setBackground(new Color(0,0,0,0));
		haut.add(titre);
		this.add(haut,BorderLayout.NORTH);

		JPanel centre = new JPanel();
		GridLayout gridCentre = new GridLayout(7,1);
		centre.setLayout(gridCentre);
		centre.setBackground(new Color(0,0,0,0));
        centre.add(blank3);
		centre.add(nouvelle);
		centre.add(blank1);
		centre.add(charger);
		centre.add(blank2);
        centre.add(retour);
        centre.add(blank4);
		nouvelle.setAlignmentX(Component.CENTER_ALIGNMENT);
		charger.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(centre,BorderLayout.CENTER);
	}

	public void initComponents(){
		nouvelle = new JButton(new ImageIcon("../images/BNouvelle.png"));
		nouvelle.setBackground(new Color(255,192,0));
		nouvelle.setBorderPainted(false);

		charger =  new JButton(new ImageIcon("../images/BCharger.png"));
		charger.setBackground(new Color(255,192,0));
		charger.setBorderPainted(false);

		titre = new JLabel(new ImageIcon("../images/Titre.png"));

        retour =  new JButton(new ImageIcon("../images/BRetour.png"));
		retour.setBackground(new Color(255,192,0));
		retour.setBorderPainted(false);

		blank1 = new JLabel();
		blank2 = new JLabel();
        blank3 = new JLabel();
        blank4 = new JLabel();
	}

    public JButton getNouvelle() {
        return nouvelle;
    }

    public JButton getCharger() {
        return charger;
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
