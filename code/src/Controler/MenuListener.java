package Controler;

import View.*;
import Game.*;
import Utilitaire.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;


/**
 * this class is used to do all the interactions with all the button of the interface and also allow to move beetoween the screnns
 */
public class MenuListener implements ActionListener {
    private VueTotal vue;
    private CardLayout l;
    private JPanel c;
    private Game g;
    private boolean state;
    private Musique m;
    private int remember;
    private ArrayList<String> send;

    public MenuListener(VueTotal vue){
        this.vue = vue;
        l = vue.getLayout();
        c = vue.getCards();
        state = false;
        m =new Musique("../data/ms.wav");
        send=new ArrayList<String>();
        g = new Game(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vue.getMenu().getQuitter()){
            vue.setVisible(false);
        }
        //menu
        if(e.getSource()==vue.getMenu().getJouer()){
            l.show(c, "2");
        }

        //Nouvelle Partie
        if(e.getSource()==vue.getTypeP().getNouvelle()){
            l.show(c, "3");
        }
        if(e.getSource()==vue.getTypeP().getRetour()){
            l.show(c, "1");
        }

        //nb de joueurs
        if(e.getSource()==vue.getLancement().getDJoueur()){
            vue.createInitP(2);
            l = vue.getLayout();
            c = vue.getCards();
            l.show(c, "4");
            g.setNumberPlayer(2);
            state = true;
            JFrame laFrame = new JFrame();
            JOptionPane d = new JOptionPane();
                            d.showMessageDialog( laFrame, "Tape ordinateur comme nom \n si tu souhaites jouer face a un ordinateur", 
                            "Information", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==vue.getLancement().getTJoueur()){
            vue.createInitP(3);
            l = vue.getLayout();
            c = vue.getCards();
            l.show(c, "4");
            g.setNumberPlayer(3);
            state = true;
            JFrame laFrame = new JFrame();
            JOptionPane d = new JOptionPane();
                            d.showMessageDialog( laFrame, "Tape ordinateur comme nom \n si tu souhaites jouer face a un ordinateur", 
                            "Information", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==vue.getLancement().getQJoueur()){
            vue.createInitP(4);
            l = vue.getLayout();
            c = vue.getCards();
            l.show(c, "4");
            g.setNumberPlayer(4);
            state = true;
            JFrame laFrame = new JFrame();
            JOptionPane d = new JOptionPane();
                            d.showMessageDialog( laFrame, "Tape ordinateur comme nom \n si tu souhaites jouer face a un ordinateur", 
                            "Information", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==vue.getLancement().getRetour()){
            l.show(c, "2");
        }

        if(state == true){
            //lancer partie
            if(e.getSource()==vue.getInitP().getConfirmer()){
                if(!vue.getInitP().getJoueurs().get(0).getText().trim().equalsIgnoreCase("ordinateur")){
                    if(vue.getInitP().complet()){
                        int i=1;
                        for(JTextField elem : vue.getInitP().getJoueurs()){
                            g.addPlayer(elem.getText(),i);
                            i++;
                        }
                        vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
                        vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
                        vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
                        vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                        vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
                        vue.getBoard().setPV(g.getPlayers().get(g.getCurent()-1).getPoints());
                        vue.getBoard().setTour(g.getPlayers().get(g.getCurent()-1).getName());
                        l.show(c, "board");
                        explication();
                        state=true;
                    } else {
                        Frame laFrame = new JFrame();
                        JOptionPane d = new JOptionPane();
                        d.showMessageDialog( laFrame, "Les champs doivent être completes", 
                        "Erreur", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    Frame laFrame = new JFrame();
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog( laFrame, "Le joueur 1 ne peut pas être un ordinateur", 
                    "Erreur", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if(e.getSource()==vue.getInitP().getRetour()){
                l.show(c, "3");
                vue.getInitP().getWarn().setText("");
            }
        }

        if(e.getSource() == vue.getMenu().getOptions()){
            l.show(c, "options");
        }

        if(e.getSource() == vue.getOptions().getRetour()){
            l.show(c, "1");
        }

        if(e.getSource() == vue.getOptions().getMusique()){
            if(vue.getOptions().getMusique().isSelected()){
                m.start();
            } else {
                m.pause();
            }
        }

        if(e.getSource() == vue.getMenu().getRegles()){
            printPDF();
        }


        if(e.getSource() == vue.getLoad().getRetour()){
            l.show(c, "1");
        }

        for(JButton elem: vue.getLoad().getSaves()){
            if(e.getSource()==elem){
                this.load(elem.getText());
                vue.CreateBoard(g.getNumberPlayer());

                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
                vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
                vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
                vue.getBoard().setPV(g.getPlayers().get(g.getCurent()-1).getPoints());
                vue.getBoard().setTour(g.getPlayers().get(g.getCurent()-1).getName());

                vue.initListenerBoard();

                l.show(c, "board");
            }
        }

        if(e.getSource()==vue.getTypeP().getCharger()){
            l.show(c, "load");
        }


        if(state == true){
            if(e.getSource()==vue.getEndGame().getRetour()){
                l.show(c, "1");
            }
            this.listenerBoard(e);
        }

    }

    /**
     * this class is used to do all the interactions of the board
     * @param e
     */
    public void listenerBoard(ActionEvent e){

        if(e.getSource()==vue.getBoard().getAide()){
            explication();
        }

        if(e.getSource()== vue.getBoard().getUe()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).takeEcus(1);
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas assez d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()== vue.getBoard().getTe()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=2){
                g.getPlayers().get(g.getCurent()-1).takeEcus(3);
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas assez d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()== vue.getBoard().getSe()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=3){
                g.getPlayers().get(g.getCurent()-1).takeEcus(6);
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas assez d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()== vue.getBoard().getActionS()){
            if(g.getPlayers().get(g.getCurent()-1).getEcus()>=5){
                g.getPlayers().get(g.getCurent()-1).buyAction();
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas assez d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte1()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addWorker(g.getDeckWorkers().getCards().get(0));
                g.getDeckWorkers().deleteCard(0);
                vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte2()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addWorker(g.getDeckWorkers().getCards().get(1));
                g.getDeckWorkers().deleteCard(1);
                vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte3()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addWorker(g.getDeckWorkers().getCards().get(2));
                g.getDeckWorkers().deleteCard(2);
                vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte4()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addWorker(g.getDeckWorkers().getCards().get(3));
                g.getDeckWorkers().deleteCard(3);
                vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte5()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addWorker(g.getDeckWorkers().getCards().get(4));
                g.getDeckWorkers().deleteCard(4);
                vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte6()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addChantier(g.getDeckBuldings().getCards().get(0));
                g.getDeckBuldings().deleteCard(0);
                vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte7()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addChantier(g.getDeckBuldings().getCards().get(1));
                g.getDeckBuldings().deleteCard(1);
                vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte8()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addChantier(g.getDeckBuldings().getCards().get(2));
                g.getDeckBuldings().deleteCard(2);
                vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte9()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addChantier(g.getDeckBuldings().getCards().get(3));
                g.getDeckBuldings().deleteCard(3);
                vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(e.getSource()==vue.getBoard().getCarte10()){
            if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                g.getPlayers().get(g.getCurent()-1).addChantier(g.getDeckBuldings().getCards().get(4));
                g.getDeckBuldings().deleteCard(4);
                vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            } else {
                JFrame laFrame = new JFrame();
                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }

        for(JButton elem : vue.getBoard().getMesOuvriers()){
            if(e.getSource()==elem){
                remember = vue.getBoard().getMesOuvriers().indexOf(elem);
            }
        }

        boolean already = false;
        boolean change = false;
        for(JButton elem : vue.getBoard().getMesChantiers()){
            if(e.getSource()==elem){

                if(remember!=-1){
                    if(g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()>=1){
                        int cost=1;

                        for(String Test:send){
                            if(Integer.parseInt(Test) == vue.getBoard().getMesChantiers().indexOf(elem)){
                                cost++;
                            }
                        }
                        if(cost<=g.getPlayers().get(g.getCurent()-1).getNumberActionLeft()){
                            boolean ok = g.getPlayers().get(g.getCurent()-1).sendWorking(remember, vue.getBoard().getMesChantiers().indexOf(elem), cost);
                            if(ok = true){
                                send.add(Integer.toString(vue.getBoard().getMesChantiers().indexOf(elem)));
                                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                            }else{
                                if(already==false){
                                    JFrame laFrame = new JFrame();
                                    JOptionPane d = new JOptionPane();
                                                    d.showMessageDialog( laFrame, "Tu ne possede pas assez d'ecus pour envoyer travailler cet ouvrier\n Ce message peut être bugger,\n merci de le fermer plusieus fois s'il ne veut pas se fermer", 
                                                    "Erreur", JOptionPane.PLAIN_MESSAGE);
                                    already=true;
                                }
                                break;
                            }
                            change = true;
                            remember = -1;
                            break;
                        } else {
                            if(already==false){
                                JFrame laFrame = new JFrame();
                                JOptionPane d = new JOptionPane();
                                d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes\n Ce message peut être bugger,\n merci de le fermer plusieus fois s'il ne veut pas se fermer", 
                                "Erreur", JOptionPane.PLAIN_MESSAGE);
                                already=true;
                            }
                            break;
                            
                        }
                    }else{
                        if(already==false){
                            JFrame laFrame = new JFrame();
                            JOptionPane d = new JOptionPane();
                            d.showMessageDialog( laFrame, "Tu ne possede pas d'actions restantes\n Ce message peut être bugger,\n merci de le fermer plusieus fois s'il ne veut pas se fermer", 
                            "Erreur", JOptionPane.PLAIN_MESSAGE);
                            already=true;
                        }
                        break;
                    }
                }else {
                    if(g.getPlayers().get(g.getCurent()-1).getMyChantiers().get(vue.getBoard().getMesChantiers().indexOf(elem)).enoughRessources()){
                        g.getPlayers().get(g.getCurent()-1).finishAction(vue.getBoard().getMesChantiers().indexOf(elem));
                        vue.getBoard().setPV(g.getPlayers().get(g.getCurent()-1).getPoints());
                        vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                        change = true;
                        break;
                    } else {
                        JFrame laFrame = new JFrame();
                        JOptionPane d = new JOptionPane();
                                        d.showMessageDialog( laFrame, "Les ressources necessaire a la creation du chantier ne sont pas reunis\n Ce message peut être bugger,\n merci de le fermer plusieus fois s'il ne veut pas se fermer", 
                                        "Erreur", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
            }
        }

        if(change == true){
            vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
            vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
            vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
        }

        if(e.getSource() == vue.getBoard().getFinir()){
            this.fin();
            g.changeCurrentPlayer();
            g.getPlayers().get(g.getCurent()-1).setNumberActionLeft(3);
            vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
            vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
            vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
            vue.getBoard().setPV(g.getPlayers().get(g.getCurent()-1).getPoints());
            vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
            vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
            vue.getBoard().setTour(g.getPlayers().get(g.getCurent()-1).getName());
            send = new ArrayList<String>();
            
            while(g.getPlayers().get(g.getCurent()-1) instanceof EasyPlayer){
                this.jouer();
                Boolean stop = this.fin();
                if(stop==true){
                    break;
                }
                g.changeCurrentPlayer();
                g.getPlayers().get(g.getCurent()-1).setNumberActionLeft(3);
                g.getPlayers().get(g.getCurent()-1).setNumberActionLeft(3);
                vue.getBoard().changePioche(g.getDeckBuldings().getCards(), g.getDeckWorkers().getCards());
                vue.getBoard().changeMesChantiers(g.getPlayers().get(g.getCurent()-1).getMyChantiers());
                vue.getBoard().changeMesOuvriers(g.getPlayers().get(g.getCurent()-1).getMyWorkers());
                vue.getBoard().setPV(g.getPlayers().get(g.getCurent()-1).getPoints());
                vue.getBoard().setActions(g.getPlayers().get(g.getCurent()-1).getNumAction());
                vue.getBoard().setEcus(g.getPlayers().get(g.getCurent()-1).getEcus());
                vue.getBoard().setTour(g.getPlayers().get(g.getCurent()-1).getName());
            }
        }

        for(JButton elem : vue.getBoard().getMesOuvriers()){
            elem.addActionListener(this);
        }
        for(JButton elem : vue.getBoard().getMesChantiers()){
            elem.addActionListener(this);
        }

        if(e.getSource()==vue.getBoard().getSave()){
            JFrame laFrame = new JFrame();
            String name = JOptionPane.showInputDialog(laFrame,
                        "Nom de la sauvegarde:", null);
            if(name!=null){
                g.save("../saves/"+name+".txt");
                JOptionPane d = new JOptionPane();
                d.showMessageDialog( laFrame, "Partie sauvegarde avec succes", 
                "Sauvegarde", JOptionPane.PLAIN_MESSAGE);
                vue.setVisible(false);
            }
        }
    }


    /**
     * this methods put the end of the game when a player have win
     */
    public boolean fin(){
        boolean ret = false;
        if( g.getCurent() == g.getPlayers().size()){
            Player p = g.aGagnerG();
            if(p!=null){
                l.show(c,"fin");
                vue.setSize(1150,700);
                vue.getEndGame().setextVictoire(g.aGagnerG().getName());
                vue.getEndGame().setNomJoueurs(g.classementG());
                ret =  true;
            } else {
                ret =  false;
            }
        }
        return ret;
    }

    /**
     * this methods allows easyPlayers to play
     */
    public void jouer(){
        EasyPlayer e = (EasyPlayer) g.getPlayers().get(g.getCurent()-1);
        send = new ArrayList<String>();
        e.playG(g, send);
        send = new ArrayList<String>();
        e.playG(g, send);
        send = new ArrayList<String>();
        e.playG(g, send);

        JFrame laFrame = new JFrame();
        JOptionPane d = new JOptionPane();
        d.showMessageDialog( laFrame, g.getPlayers().get(g.getCurent()-1).getName()+" a "+g.getPlayers().get(g.getCurent()-1).getPoints()+ " points", 
                "Info", JOptionPane.PLAIN_MESSAGE);
    }

    public void load(String save){
        g = g.loadG(save);
    }

    /**
     * this methods is used to print the pdf with all the rules
     */
    public void printPDF(){
        File fichier = new File("../data/rules.pdf");
        // On verifie que la classe Desktop soit bien supportee : 
        if (Desktop.isDesktopSupported()) { 
            // On recupere l'instance du desktop : 
            Desktop desktop = Desktop.getDesktop(); 
            // On verifie que la fonction open est bien supportee : 
            if (desktop.isSupported(Desktop.Action.OPEN)) { 
                // Et on lance l'application associe au fichier pour l'ouvrir : 
                try { 
                desktop.open(fichier); 
                }catch(IOException ex) {
                    // Gestion de l'erreur.
                    ex.getMessage();
                } 
            }
        }
    }

    /**
     * this methods open a frame to explain the interactions of the board to the user
     */
    public void explication(){
        JFrame laFrame = new JFrame();
        JOptionPane d = new JOptionPane();
                        d.showMessageDialog( laFrame, "- Ouvrir un chantier: Clique sur le batiment de la pioche que tu souhaites construire\n - Recruter un ouvrier: Clique sur l'ouvrier de la pioche \n - Envoyer un ouvrier sur un chantier: Clique sur l'ouvrier de ta main puis sur le chantier où tu souhaite l'envoyer \n - Finir un chantier: cliquer sur le chantier a finir", 
                        "Aide aux interactions", JOptionPane.PLAIN_MESSAGE);
    }
}

