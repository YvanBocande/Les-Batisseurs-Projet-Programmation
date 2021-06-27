package View;

import java.awt.*;

import javax.swing.*;

public class Rules extends JFrame{

	private JScrollPane rules;
	private JButton retour;

	public Rules() {
		this.setSize(1000,650);
		this.setBackground(new Color(118,146,125));

		BorderLayout border = new BorderLayout();
		this.setLayout(border);

		JPanel bas = new JPanel();
		bas.setBackground(new Color(118,146,125));
		GridLayout gridBas = new GridLayout(1,5);
		bas.setLayout(gridBas);
		bas.add(new JLabel());
		bas.add(new JLabel());
		bas.add(retour);
		bas.add(new JLabel());
		bas.add(new JLabel());

		this.add(bas,BorderLayout.SOUTH);
		this.add(rules,BorderLayout.CENTER);

	}

	public void initComponents(){



		retour =  new JButton(new ImageIcon("../images/BRetour.png"));
		retour.setBackground(new Color(118,146,125));
		JLabel label = new JLabel("<html><h1 style=\"text-align: center;\">R&egrave;gles du jeu</h1> <p>&nbsp;</p> <p>ferfefe</p> <p>efeffeffe</p><html>");
		label.setBackground(new Color(118,146,125));
		label.setForeground(new Color(254,193,0,255));
		rules = new JScrollPane(label);
	}


	public JButton getRetour() {
		return this.retour;
	}

	public static void main(String[] args) {
		new Rules().setVisible(true);
	}

}