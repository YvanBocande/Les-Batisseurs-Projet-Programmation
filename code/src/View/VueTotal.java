package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Controler.MenuListener;

/**
 * this class is the interface of the application. You can navigate beetween the pages of the interface with the controler
 */
public class VueTotal extends JFrame{
    private Menu menu;
    private Lancement lancement;
    private InitP initP;
    private TypeP type;
    private Options options;
    private JPanel cards;
    private CardLayout layout;
    private MenuListener l;
    private Board board;
    private EndGame endGame;
    private Load load;

   
    /**
     * the constructor sets up the Cards layout then adds the Panel in it and sets up the listener
     */
    public VueTotal(){
        setTitle("Les Batisseurs");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setSize(1350,800);
        this.initComponents();
        centreWindow(this);

        Image icon = Toolkit.getDefaultToolkit().getImage("../images/logo.png");  
        this.setIconImage(icon);  


        layout = new CardLayout();
        cards = new JPanel(layout); 
        cards.add("1",menu);
        cards.add("2",type);
        cards.add("3",lancement);
        cards.add("options",options);
        cards.add("load",load);

        this.add(cards);

        l = new MenuListener(this);

        menu.getJouer().addActionListener(l);
        menu.getRegles().addActionListener(l);
        menu.getQuitter().addActionListener(l);
        menu.getOptions().addActionListener(l);

        lancement.getDJoueur().addActionListener(l);
        lancement.getTJoueur().addActionListener(l);
        lancement.getQJoueur().addActionListener(l);
        lancement.getRetour().addActionListener(l);

        type.getNouvelle().addActionListener(l);
        type.getCharger().addActionListener(l);
        type.getRetour().addActionListener(l);

        options.getRetour().addActionListener(l);
        options.getMusique().addActionListener(l);


        load.getRetour().addActionListener(l);
        for(JButton elem : load.getSaves()){
            elem.addActionListener(l);
        }
    }

    /**
     * initilialize the panels of the application
     */
    public void initComponents(){
        menu = new Menu();
        lancement = new Lancement();
        type = new TypeP();
        options = new Options();
        load = new Load();

    }

    /**
    * initializes the initP and board page according to the number of players
    * @param nb the number of players
    */
    public void createInitP(int nb){
        initP = new InitP(nb);
        initP.getConfirmer().addActionListener(l);
        initP.getRetour().addActionListener(l);

        board = new Board(nb);
        initListenerBoard();

        endGame = new EndGame(nb);
        endGame.getRetour().addActionListener(l);

        this.remove(cards);
        layout = new CardLayout();
        cards = new JPanel(layout); 

        cards.add("1",menu);
        cards.add("2",type);
        cards.add("3",lancement);
        cards.add("4",initP);
        cards.add("options",options);
        cards.add("fin",endGame);
        cards.add("load",load);
        cards.add("board",board);

        this.add(cards);
    }

    /**
     * create the board according to the number of players
     * @param nb the number of players
     */
    public void CreateBoard(int nb){

        board = new Board(nb);
        board.getCarte1().addActionListener(l);
        board.getCarte2().addActionListener(l);
        board.getCarte3().addActionListener(l);
        board.getCarte4().addActionListener(l);
        board.getCarte5().addActionListener(l);
        board.getCarte6().addActionListener(l);
        board.getCarte7().addActionListener(l);
        board.getCarte8().addActionListener(l);
        board.getCarte9().addActionListener(l);
        board.getCarte10().addActionListener(l);

        board.getUe().addActionListener(l);
        board.getTe().addActionListener(l);
        board.getSe().addActionListener(l);

        board.getActionS().addActionListener(l);

        board.getFinir().addActionListener(l);
        board.getSave().addActionListener(l);
        board.getAide().addActionListener(l);

        cards.add("board",board);

        this.add(cards);
    }

    /**
     * initialize all the listener of the class board
     */
    public void initListenerBoard(){
        board.getCarte1().addActionListener(l);
        board.getCarte2().addActionListener(l);
        board.getCarte3().addActionListener(l);
        board.getCarte4().addActionListener(l);
        board.getCarte5().addActionListener(l);
        board.getCarte6().addActionListener(l);
        board.getCarte7().addActionListener(l);
        board.getCarte8().addActionListener(l);
        board.getCarte9().addActionListener(l);
        board.getCarte10().addActionListener(l);

        board.getUe().addActionListener(l);
        board.getTe().addActionListener(l);
        board.getSe().addActionListener(l);

        board.getActionS().addActionListener(l);

        board.getFinir().addActionListener(l);
        board.getSave().addActionListener(l);
        board.getAide().addActionListener(l);

        for(JButton elem : board.getJoueurs()){
            elem.addActionListener(l);
        }
    }

   

    /**
     * sert a centrer la fenetre 
     * @param frame le JFrame
     */
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public JPanel getCards() {
        return cards;
    }

    public CardLayout getLayout() {
        return layout;
    }

    public Menu getMenu() {
        return menu;
    }

    public Lancement getLancement() {
        return lancement;
    }

    public TypeP getTypeP(){
        return type;
    }

    public InitP getInitP() {
        return initP;
    }

    public Options getOptions() {
        return options;
    }

    public Board getBoard() {
        return board;
    }

    public EndGame getEndGame() {
        return endGame;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad() {
        load = new Load();
        load.getRetour().addActionListener(l);
        for(JButton elem : load.getSaves()){
            elem.addActionListener(l);
        }
    }

    

    public static void main(String[] args) {
        new VueTotal().setVisible(true);
    }
}
