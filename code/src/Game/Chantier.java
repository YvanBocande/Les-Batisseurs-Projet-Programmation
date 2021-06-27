package Game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * this class represent the construction of a bulding with the workers
 */
public class Chantier implements Serializable {
    private Card build;
    private ArrayList<Card> workers;

    /**
     * initialize the chantier with the bulding to construvt
     * @param build the bulding to build
     */
    public Chantier(Card build){
        if(build != null){
            this.build = build;
            workers = new ArrayList<Card>();
        }
    }

    /**
     * add a worker on the arrayList of workers
     * @param c the worker to add
     */
    public void addWorker(Card c){
        if(c instanceof Worker || c instanceof Machine){
            workers.add(c);
        }
    }

    /**
     * get the number of wood of the workers
     * @return int wich is the number of wood
     */
    public int numberWood(){
        int ret = 0;
        for(Card elem : workers){
            if(elem instanceof Worker){
                ret = ret + elem.getwood();
            }
            if(elem instanceof Machine){
                Machine m = (Machine) elem;
                ret = ret + m.getWoodP();
            }
        }
        return ret;
    }

    /**
     * get the number of stone of the workers
     * @return int wich is the number of stone
     */
    public int numberStone(){
        int ret = 0;
        for(Card elem : workers){
            if(elem instanceof Worker){
                ret = ret + elem.getStone();
            }
            if(elem instanceof Machine){
                Machine m = (Machine) elem;
                ret = ret + m.getStoneP();
            }
        }
        return ret;
    }

    /**
     * get the number of tuile of the workers
     * @return int wich is the number of tuile
     */
    public int numberTuile(){
        int ret = 0;
        for(Card elem : workers){
            if(elem instanceof Worker){
                ret = ret + elem.getTuile();
            }
            if(elem instanceof Machine){
                Machine m = (Machine) elem;
                ret = ret + m.getTuileP();
            }
        }
        return ret;
    }

    /**
     * get the number of knowledge of the workers
     * @return int wich is the number of knowledge
     */
    public int numberKnowledge(){
        int ret = 0;
        for(Card elem : workers){
            if(elem instanceof Worker){
                ret = ret + elem.getKnowledge();
            }
            if(elem instanceof Machine){
                Machine m = (Machine) elem;
                ret = ret + m.getKnowledgeP();
            }
        }
        return ret;
    }

    /**
     * count the ressource 
     * @return a bollean wich is true if the ressources are superior than the bulding need
     */
    public boolean enoughRessources(){
        if(this.numberKnowledge()>=build.getKnowledge() && this.numberStone()>=build.getStone() && this.numberTuile()>=build.getTuile() && this.numberWood()>=build.getwood()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * return the build
     * @return the card wich is the build
     */
    public Card getBuild() {
        return build;
    }

    /**
     * return the workers of the class
     * @return an Arraylist of workers
     */
    public ArrayList<Card> getWorkers() {
        return workers;
    }
}
