package test;



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
public class HumanPlayerTest{


    @Test
    public final void TestHumanPlayer(){
        HumanPlayer player = new HumanPlayer("Test",1, null);
        assertNotNull("Instance non creee", player); 
    }
}
