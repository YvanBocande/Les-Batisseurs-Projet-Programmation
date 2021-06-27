package View;

import java.awt.*;

import javax.swing.*;

/**
 * this panel represent the option, this part of the application is used the put the music
 */
public class Options extends JPanel {

	private JCheckBox musique;
	private JButton retour;
	private JLabel titre;

	public Options() {

		this.setSize(1000,650);
        this.initComponents();

		BorderLayout border = new BorderLayout();
		this.setLayout(border);

		JPanel haut = new JPanel();
		haut.setBackground(new Color(227,227,227));
		haut.add(titre);
		this.add(haut,BorderLayout.NORTH);

		JPanel centre = new JPanel();
		GridLayout gridCentre = new GridLayout(2,1);
		centre.setLayout(gridCentre);
		centre.setBackground(new Color(227,227,227));
		centre.add(musique);
		centre.add(retour);
		musique.setAlignmentX(Component.CENTER_ALIGNMENT);

		

		this.add(centre,BorderLayout.CENTER);

	}

	/**
	 * initialize the components with picture and set the colors
	 */
	public void initComponents(){
		titre = new JLabel(new ImageIcon("../images/Titre.png"));
		titre.setBackground(new Color(227,227,227));

		musique = new JCheckBox("Musique");
		musique.setFont(new Font("Serif", Font.BOLD, 30));
		musique.setForeground(new Color(254,193,0,255));
        musique.setHorizontalAlignment(SwingConstants.CENTER);
		musique.setBackground(new Color(227,227,227));

		retour =  new JButton(new ImageIcon("../images/BRetour.png"));
		retour.setBackground(new Color(227,227,227));

	}

	public JButton getRetour() {
		return retour;
	}

	public JCheckBox getMusique() {
		return musique;
	}

}