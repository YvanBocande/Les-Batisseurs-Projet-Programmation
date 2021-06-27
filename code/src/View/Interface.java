package View;

import java.awt.*;
import javax.swing.*;

public class Interface extends JFrame{

	private Menu menu;
	private Lancement lancement;
    private JPanel cards;
    private CardLayout layout;

	public Interface() {
		setTitle("Les Batisseurs");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setSize(1150,700);
        this.initComponents();		

        layout = new CardLayout();
        cards = new JPanel(layout); 
        cards.add("1",menu);
        cards.add("2",lancement);
        this.add(cards);
	}

	public void initComponents(){
		menu = new Menu();
		lancement = new Lancement();
	}

	public static void main(String[] args) {
		new Interface().setVisible(true);
	}
}