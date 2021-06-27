package View;

import Game.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import Controler.MenuListener;
/**
 * this class represent the board of the graphical version of the game with the card and the hand of the players
 * @author Yvan Bocande
 */
public class Board extends JPanel{

	private JToolBar barH;
	private JToolBar barD;
	private JLabel ecus;
	private JLabel pv;
	private JLabel tour;
	private JLabel actions;
	private JButton Ue;
	private JButton Te;
	private JButton Se;
	private JButton actionS;
	private JButton options;
	private ArrayList<JButton> joueurs;
	private ArrayList<JButton> mesOuvriers;
	private ArrayList<JButton> mesChantiers;
	private JButton carte1;
	private JButton carte2;
	private JButton carte3;
	private JButton carte4;
	private JButton carte5;
	private JButton carte6;
	private JButton carte7;
	private JButton carte8;
	private JButton carte9;
	private JButton carte10;
	private JPanel lesOuvriers;
	private JPanel lesChantiers;
	private JScrollPane gauche;
	private JScrollPane droite;
	private JPanel basDroit;
	private JButton finir;
	private JButton save;
	private JButton aide;


	/**
	 * this constructor instancie a JPanel wich is the graphical board 
	 */
	public Board(int nb) {
		joueurs = new ArrayList<JButton>();
		mesOuvriers = new ArrayList<JButton>();
		mesChantiers = new ArrayList<JButton>();

		initComponents(nb);
        this.setSize(600,400);
		this.setBackground(new Color(227,227,227));

		this.setLayout(new BorderLayout());

        
        // Construction et injection de la barHre d'outils
        this.add( barH, BorderLayout.NORTH );
		this.add( barD, BorderLayout.SOUTH );

		JPanel central = new JPanel();
		central.setBackground(new Color(227,227,227));
		GridLayout gridCentral = new GridLayout(2,2);
		central.setLayout(gridCentral);



		JPanel hautGauche = new JPanel();
		hautGauche.setBackground(new Color(227,227,227));
		hautGauche.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		GridLayout gridHautGauche = new GridLayout(1,6);
		hautGauche.setLayout(gridHautGauche);

		JPanel hautDroite = new JPanel();
		hautDroite.setBackground(new Color(227,227,227));
		GridLayout gridHautDroite = new GridLayout(1,6);
		hautDroite.setLayout(gridHautDroite);
		hautDroite.add(carte1);
		hautDroite.add(carte2);
		hautDroite.add(carte3);
		hautDroite.add(carte4);
		hautDroite.add(carte5);
		
		JPanel hautDroiteG = new JPanel(new BorderLayout());

		JToolBar barHD = new JToolBar();
		barHD.setBackground(new Color(227,227,227));
		barHD.setLayout(new FlowLayout(FlowLayout.CENTER));
		barHD.setFloatable(false);
		JLabel piocheO = new JLabel("<html><body><u>Pioche des ouvriers:</u></body></html>");
		piocheO.setBackground(new Color(227,227,227));
		piocheO.setForeground(new Color(0,0,0));
		piocheO.setFont(new Font("HoloLens MDL2 Assets", Font.BOLD, 20));
		barHD.add(piocheO);

		hautDroiteG.add(hautDroite,BorderLayout.CENTER);
		hautDroiteG.add(barHD,BorderLayout.NORTH);


		hautGauche.add(carte6);
		hautGauche.add(carte7);
		hautGauche.add(carte8);
		hautGauche.add(carte9);
		hautGauche.add(carte10);

		JPanel hautGaucheG = new JPanel(new BorderLayout());

		JToolBar barHG = new JToolBar();
		barHG.setBackground(new Color(227,227,227));
		barHG.setLayout(new FlowLayout(FlowLayout.CENTER));
		barHG.setFloatable(false);
		JLabel piocheC = new JLabel("<html><body><u>Pioche des chantiers:</u></body></html>");
		piocheC.setBackground(new Color(227,227,227));
		piocheC.setForeground(new Color(0,0,0));
		piocheC.setFont(new Font("HoloLens MDL2 Assets", Font.BOLD, 20));
		barHG.add(piocheC);

		hautGaucheG.add(hautGauche,BorderLayout.CENTER);
		hautGaucheG.add(barHG,BorderLayout.NORTH);

		central.add(hautGaucheG);
		central.add(hautDroiteG);

		//bas Gauche
		JPanel basGauche = new JPanel(new BorderLayout());

		JToolBar barM = new JToolBar();
		barM.setBackground(new Color(227,227,227));
		barM.setLayout(new FlowLayout(FlowLayout.CENTER));
		barM.setFloatable(false);
		JLabel mesOuvriers = new JLabel("<html><body><u>Mes ouvriers:</u></body></html>");
		mesOuvriers.setBackground(new Color(227,227,227));
		mesOuvriers.setForeground(new Color(0,0,0));
		mesOuvriers.setFont(new Font("HoloLens MDL2 Assets", Font.BOLD, 20));
		barM.add(mesOuvriers);

		lesOuvriers = new JPanel();
		BoxLayout boxGauche = new BoxLayout(lesOuvriers,  BoxLayout.Y_AXIS);
		lesOuvriers.setLayout(boxGauche);
		lesOuvriers.setBackground(new Color(227,227,227));
		for(int i=0;i<5;i++){
			JPanel p = new JPanel();
			p.setBackground(new Color(227,227,227));
			p.setLayout(new GridLayout(1,3));
			p.add(new JLabel(new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/Apprenti1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH))))));
			p.add(new JLabel(new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/Apprenti1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH))))));
			p.add(new JLabel(new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/Apprenti1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH))))));
			lesOuvriers.add(p);
		}


		gauche = new JScrollPane(lesOuvriers);
		gauche.setBackground(new Color(227,227,227));

		
		basGauche.add(barM,BorderLayout.NORTH);
		basGauche.add(gauche,BorderLayout.CENTER);

		central.add(basGauche);
		
		//bas droite

		basDroit = new JPanel(new BorderLayout());

		JToolBar barMC = new JToolBar();
		barMC.setBackground(new Color(227,227,227));
		barMC.setLayout(new FlowLayout(FlowLayout.CENTER));
		barMC.setFloatable(false);
		JLabel mesChantiers= new JLabel("<html><body><u>Mes chantiers:</u></body></html>");
		mesChantiers.setBackground(new Color(227,227,227));
		mesChantiers.setForeground(new Color(0,0,0));
		mesChantiers.setFont(new Font("HoloLens MDL2 Assets", Font.BOLD, 20));
		barMC.add(mesChantiers);

		lesChantiers = new JPanel();
		BoxLayout boxGaucheD = new BoxLayout(lesChantiers,  BoxLayout.Y_AXIS);
		lesChantiers.setLayout(boxGaucheD);
		lesChantiers.setBackground(new Color(227,227,227));
		for(int i=0;i<5;i++){
			JPanel p = new JPanel();
			p.setBackground(new Color(227,227,227));
			p.setLayout(new GridLayout(1,2));
			p.add(new JLabel(new ImageIcon(((new ImageIcon("../images/cartes/batiments/chantiers/Batiment1.png").getImage().getScaledInstance(140, 170,java.awt.Image.SCALE_SMOOTH))))));
			lesChantiers.add(p);
		}


		droite = new JScrollPane(lesChantiers);
		droite.setBackground(new Color(227,227,227));

		
		basDroit.add(barMC,BorderLayout.NORTH);
		basDroit.add(droite,BorderLayout.CENTER);

		central.add(basDroit);



		this.add(central, BorderLayout.CENTER);

		
		
	}

	/**
	 * initialize the components with picture and set the colors
	 * @param nb
	 */
	public void initComponents(int nb){
		//bar du haut
		barH = new JToolBar();
		barH.setBackground(new Color(193,41,46));
		barH.setLayout(new FlowLayout(FlowLayout.CENTER));
		barH.setFloatable(false);

		actions = new JLabel("Actions restantes:3" + "    ");
		actions.setForeground(new Color(255,255,255));
		actions.setFont(new Font("Serif", Font.BOLD, 20));

		barH.add(actions);
		barH.addSeparator();

		Ue = new JButton(" Prendre 1 Ecu ");
		Ue.setBackground(new Color(193,41,46));
		Ue.setForeground(new Color(255,255,255));
		Ue.setFont(new Font("Serif", Font.BOLD, 20));

		Te = new JButton(" Prendre 3 Ecus ");
		Te.setBackground(new Color(193,41,46));
		Te.setForeground(new Color(255,255,255));
		Te.setFont(new Font("Serif", Font.BOLD, 20));

		Se = new JButton(" Prendre 6 Ecus ");
		Se.setBackground(new Color(193,41,46));
		Se.setForeground(new Color(255,255,255));
		Se.setFont(new Font("Serif", Font.BOLD, 20));

		actionS = new JButton(" Acheter une action supplementaire ");
		actionS.setBackground(new Color(193,41,46));
		actionS.setForeground(new Color(255,255,255));
		actionS.setFont(new Font("Serif", Font.BOLD, 20));

		aide = new JButton("Aide");
		aide.setBackground(new Color(193,41,46));
		aide.setForeground(new Color(255,255,255));
		aide.setFont(new Font("Serif", Font.BOLD, 20));

		barH.add(Ue);
		barH.add(Te);
		barH.add(Se);
		barH.add(actionS);
		barH.add(aide);

		//bar de droite
		barD = new JToolBar();
		barD.setBackground(new Color(193,41,46));
		barD.setLayout(new FlowLayout(FlowLayout.CENTER));
		barD.setFloatable(false);

		tour = new JLabel("Tour de ");
		tour.setForeground(new Color(255,255,255));
		tour.setFont(new Font("Serif", Font.BOLD, 20));
		tour.setAlignmentX(Component.LEFT_ALIGNMENT);

		ecus = new JLabel("Mes Ecus: 8      " + "    ");
		ecus.setForeground(new Color(255,255,255));
		ecus.setFont(new Font("Serif", Font.BOLD, 20));
		ecus.setAlignmentX(Component.LEFT_ALIGNMENT);

		pv= new JLabel("Mes points de victoire: 8      "+"                      ");
		pv.setForeground(new Color(255,255,255));
		pv.setFont(new Font("Serif", Font.BOLD, 20));
		pv.setAlignmentX(Component.LEFT_ALIGNMENT);

		barD.add(tour);
		barD.add(ecus);
		barD.add(actions);
		barD.add(pv);

		finir = new JButton("Finir mon tour");
		finir.setBackground(new Color(193,41,46));
		finir.setForeground(new Color(255,255,255));
		finir.setFont(new Font("Serif", Font.BOLD, 20));

		save = new JButton("Save");
		save.setBackground(new Color(193,41,46));
		save.setForeground(new Color(255,255,255));
		save.setFont(new Font("Serif", Font.BOLD, 20));

		barD.add(finir);
		barD.add(save);

		carte1 = new JButton();
		carte1.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/Apprenti1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte1.setBackground(new Color(227,227,227));
		carte1.setOpaque(false);
		carte1.setBorderPainted(false);

		carte2 = new JButton();
		carte2.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/Apprenti1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte2.setOpaque(false);
		carte2.setBorderPainted(false);
		carte2.setBackground(new Color(227,227,227));

		carte3 = new JButton();
		carte3.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/Apprenti1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte3.setBackground(new Color(227,227,227));
		carte3.setOpaque(false);
		carte3.setBorderPainted(false);
		carte1.setBackground(new Color(227,227,227));

		carte4 = new JButton();
		carte4.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/Apprenti1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte4.setBackground(new Color(227,227,227));
		carte4.setOpaque(false);
		carte4.setBorderPainted(false);

		carte5 = new JButton();
		carte5.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/Apprenti1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte5.setBackground(new Color(227,227,227));
		carte5.setOpaque(false);
		carte5.setBorderPainted(false);


		carte6 = new JButton();
		carte6.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/batiments/chantiers/Batiment1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte6.setBackground(new Color(227,227,227));
		carte6.setOpaque(false);
		carte6.setBorderPainted(false);

		carte7 = new JButton();
		carte7.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/batiments/chantiers/Batiment1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte7.setBackground(new Color(227,227,227));
		carte7.setOpaque(false);
		carte7.setBorderPainted(false);

		carte8 = new JButton();
		carte8.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/batiments/chantiers/Batiment1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte8.setBackground(new Color(227,227,227));
		carte8.setOpaque(false);
		carte8.setBorderPainted(false);

		carte9 = new JButton();
		carte9.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/batiments/chantiers/Batiment1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte9.setBackground(new Color(227,227,227));
		carte9.setOpaque(false);
		carte9.setBorderPainted(false);

		carte10 = new JButton();
		carte10.setIcon(new ImageIcon(((new ImageIcon("../images/cartes/batiments/chantiers/Batiment1.png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte10.setBackground(new Color(227,227,227));
		carte10.setOpaque(false);
		carte10.setBorderPainted(false);
		
	}

	public void changePioche(ArrayList<Card> cardsB, ArrayList<Card> cardsO){
		String path = "../images/cartes/ouvriers/";

		carte1.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsO.get(0).getName(),"v")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte2.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsO.get(1).getName(),"v")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte3.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsO.get(2).getName(),"v")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte4.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsO.get(3).getName(),"v")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte5.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsO.get(4).getName(),"v")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));

		path = "../images/cartes/batiments/chantiers/";
		carte6.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsB.get(0).getName(),"r")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte7.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsB.get(1).getName(),"r")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte8.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsB.get(2).getName(),"r")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte9.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsB.get(3).getName(),"r")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
		carte10.setIcon(new ImageIcon(((new ImageIcon(path+changeName(cardsB.get(4).getName(),"r")+".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))));
	}

	public void changeMesChantiers(ArrayList<Chantier> cards){
		mesChantiers.clear();
		if(cards.size()>0){
			BoxLayout boxDroite = new BoxLayout(lesChantiers,  BoxLayout.Y_AXIS);
			lesChantiers.setLayout(boxDroite);
			lesChantiers.setBackground(new Color(227,227,227));

			JPanel p = new JPanel(new GridLayout(1,3));
			p.setBackground(new Color(227,227,227));
			for(Chantier elem: cards){
				JLabel blank = new JLabel();
				blank.setBackground(new Color(227,227,227));
				p.add(blank);
				JButton l = new JButton();
				String path = "../images/cartes/batiments/chantiers/";
				mesChantiers.add(l);
				l.setIcon(new ImageIcon(((new ImageIcon(path+changeName(elem.getBuild().getName(),"r")+".png").getImage().getScaledInstance(140, 140,java.awt.Image.SCALE_SMOOTH)))));
				formatButton(l);
				l.setAlignmentX(Component.CENTER_ALIGNMENT);
				p.add(l);
				JPanel caracetristiques = new JPanel(new GridLayout(10,1));
				caracetristiques.setBackground(new Color(227,227,227));
				
				
				for(int i=0;i<3;i++){
					JLabel j = new JLabel();
					j.setBackground(new Color(227,227,227));
					caracetristiques.add(j);
				}

				JLabel lP = new JLabel("Pierre: " + elem.numberStone()+"/"+elem.getBuild().getStone());
				formatTexte(lP);
				caracetristiques.add(lP);

				JLabel lB = new JLabel("Bois: " + elem.numberWood()+"/"+elem.getBuild().getwood());
				formatTexte(lB);
				caracetristiques.add(lB);

				JLabel lS = new JLabel("Savoir: " + elem.numberKnowledge()+"/"+elem.getBuild().getKnowledge());
				formatTexte(lS);
				caracetristiques.add(lS);

				JLabel lT = new JLabel("Tuile: " + elem.numberTuile()+"/"+elem.getBuild().getTuile());
				formatTexte(lT);
				caracetristiques.add(lT);

				for(int i=0;i<3;i++){
					JLabel j = new JLabel();
					j.setBackground(new Color(227,227,227));
					caracetristiques.add(j);
				}

				p.add(caracetristiques);
				lesChantiers.add(p);
			}
			droite.setViewportView(p);

			
		} else {
			
			JPanel p = new JPanel();
			p.setBackground(new Color(227,227,227));
			JLabel b = new JLabel();
			b.setBackground(new Color(227,227,227));
			p.add(b);

			droite.setViewportView(p);
			
		}
	}

	public void changeMesOuvriers(ArrayList<Card> cards){
		mesOuvriers.clear();
		if(cards.size()>0){
			JPanel lesOuvriers = new JPanel();
			BoxLayout boxGauche = new BoxLayout(lesOuvriers,  BoxLayout.Y_AXIS);
			lesOuvriers.setLayout(boxGauche);
			lesOuvriers.setBackground(new Color(227,227,227));
			int k = 0;

			lesChantiers = new JPanel();
			BoxLayout boxGaucheD = new BoxLayout(lesChantiers,  BoxLayout.Y_AXIS);
			lesChantiers.setLayout(boxGaucheD);
			lesChantiers.setBackground(new Color(227,227,227));


			for(int i = 1;i+2 < cards.size();i=i+4){
				JPanel p = new JPanel();
				p.setBackground(new Color(227,227,227));
				p.setLayout(new GridLayout(1,3));

				mesOuvriers.add(new JButton((new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/" + changeName(cards.get(i-1).getName(),"r")+  ".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))))));
				mesOuvriers.add(new JButton((new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/" + changeName(cards.get(i).getName(),"r")+  ".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))))));
				mesOuvriers.add(new JButton((new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/" + changeName(cards.get(i+1).getName(),"r")+  ".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))))));
				mesOuvriers.add(new JButton((new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/" + changeName(cards.get(i+2).getName(),"r")+  ".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))))));
				
				formatButton(mesOuvriers.get(i-1));
				formatButton(mesOuvriers.get(i));
				formatButton(mesOuvriers.get(i+1));
				formatButton(mesOuvriers.get(i+2));

				p.add(mesOuvriers.get(i-1));
				p.add(mesOuvriers.get(i));
				p.add(mesOuvriers.get(i+1));
				p.add(mesOuvriers.get(i+2));
				
				lesOuvriers.add(p);
				k=i;
			}
			if(k==0){
				k=-3;
			}
			if(cards.size()%4 !=0){
				JPanel p = new JPanel();
				p.setBackground(new Color(227,227,227));
				p.setLayout(new GridLayout(1,3));
				for(int i=k+3;i<cards.size();i++){
					mesOuvriers.add(new JButton((new ImageIcon(((new ImageIcon("../images/cartes/ouvriers/" + changeName(cards.get(i).getName(),"r")+  ".png").getImage().getScaledInstance(110, 140,java.awt.Image.SCALE_SMOOTH)))))));
					formatButton(mesOuvriers.get(i));
					p.add(mesOuvriers.get(i));
				}
				lesOuvriers.add(p);
			}

			gauche.setViewportView(lesOuvriers);
		} else {
			JPanel p = new JPanel();
			p.setBackground(new Color(227,227,227));
			JLabel b = new JLabel();
			b.setBackground(new Color(227,227,227));
			p.add(b);
			
			gauche.setViewportView(p);
		}
	}

	public void changeButtonP(ArrayList<Player> p,int current){
		int i=0;
		for(JButton elem: joueurs ){
			if(i!=current-1){
				elem.setText("Voir les cartes de " + p.get(i).getName());
			} else {
				i++;
				elem.setText("Voir les cartes de " + p.get(i).getName());
			}
			i++;
		}
	}

	public String changeName(String s,String add){
		String ret = "";
		boolean trouve=false;
		for(int i=1;i<9 && trouve == false;i++){
			if((s.subSequence(0, s.length()-1)).equals("Machine")){
				ret = s+add;
				trouve = true;
			}
		}
		if(trouve==false){
			ret = s;
		}
		return ret;
	}

	public void formatTexte(JLabel l){
		l.setBackground(new Color(255,217,102));
		l.setForeground(new Color(128,0,0));
		l.setFont(new Font("Serif", Font.BOLD, 20));
	}

	public void formatButton(JButton b){
		b.setBackground(new Color(227,227,227));
		b.setOpaque(false);
		b.setBorderPainted(false);
	}

	public void setEcus(int nb){
		ecus.setText("Mes ecus: " + nb+"      ");
    }

	public void setActions(int nb){
		actions.setText("Actions restantes: " + nb+ "      ");
    }

	public void setPV(int nb){
		pv.setText("Mes points de victoire:" + nb+"  |                      ");
	}

	public void setTour(String name){
		tour.setText("Tour de " + name +"                    |  ");
	}

	public JButton getCarte1() {
		return carte1;
	}

	public JButton getCarte2() {
		return carte2;
	}

	public JButton getCarte3() {
		return carte3;
	}

	public JButton getCarte4() {
		return carte4;
	}

	public JButton getCarte5() {
		return carte5;
	}

	public JButton getCarte6() {
		return carte6;
	}

	public JButton getCarte7() {
		return carte7;
	}

	public JButton getCarte8() {
		return carte8;
	}

	public JButton getCarte9() {
		return carte9;
	}

	public JButton getCarte10() {
		return carte10;
	}

	public JButton getUe() {
		return Ue;
	}

	public JButton getTe() {
		return Te;
	}

	public JButton getSe() {
		return Se;
	}

	public JButton getOptions() {
		return options;
	}

	public JButton getActionS() {
		return actionS;
	}

	public ArrayList<JButton> getJoueurs() {
		return joueurs;
	}

	public ArrayList<JButton> getMesOuvriers() {
		return mesOuvriers;
	}

	public ArrayList<JButton> getMesChantiers() {
		return mesChantiers;
	}

	public JButton getFinir() {
		return finir;
	}

	public JButton getSave() {
		return save;
	}

	public JButton getAide() {
		return aide;
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new Board(3));
		f.setVisible(true);
	}
}