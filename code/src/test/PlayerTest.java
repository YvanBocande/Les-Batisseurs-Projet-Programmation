package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Game.HumanPlayer;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
* La classe machine
* @author Yvan
* @version 1.0
*/
public class PlayerTest{


    @Test
    public final void PlayerTest(){
        HumanPlayer player = new HumanPlayer("Test",1, null);
        assertNotNull("Instance non creee", player); 

        EasyPlayer auto = new EasyPlayer("Test",1);
        assertNotNull("Instance non creee", auto); 

        DifficultPlayer auto2 = new DifficultPlayer("Test",1);
        assertNotNull("Instance non creee", auto);
    }

    @Test
    public final void getNameTest(){
        HumanPlayer player = new HumanPlayer("Test",1);
        assertEquals("Test", player.getName()); 

        AutoPlayer auto = new EasyPlayer("Test",1);
        assertEquals("Test", auto.getName()); 
    }

    @Test
    public final void actionsTest(){
        HumanPlayer player = new HumanPlayer("Test",1);
        player.openBulding(1);
        assertEquals(1, player.getMyBuldings().size()); 

        player.recrutWorker(2);
        assertEquals(1, player.getMyWorkers().size()); 

        player.sendWorking(1);
        assertEquals(0, player.getMyWorkers().size()); 

        player.takeEcus();
        assertEquals(5, player.getMoney()); 

        player.setAction(6);
        assertEquals(6, player.getNumAction()); 

        player.setPoints(3);
        assertEquals(3, player.getNumAction()); 
    
    }
}
