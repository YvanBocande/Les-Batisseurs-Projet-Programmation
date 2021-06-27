package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import Game.*;

/**
* La classe bulding
* @author Yvan
* @version 1.0
*/
public class BuldingTest{


    @Test
    public final void TestBulding(){
        Bulding bulding = new Bulding(1,1,1,1,"Test",1, 0);
        assertNotNull("Instance non creee", bulding); 
    }

    @Test
    public final void TestGetTuile(){
        Bulding bulding = new Bulding(1,2,3,4,"Test",5, 0);
        assertEquals(1, bulding.getTuile());
    } 

    @Test
    public final void TestGetPointVictory(){
        Bulding bulding = new Bulding(1,2,3,4,"Test",5, 0);
        assertEquals(5, bulding.getPointVictory());
    } 

    @Test
    public final void TestGetStone(){
        Bulding bulding = new Bulding(1,2,3,4,"Test",5, 0);
        assertEquals(2, bulding.getStone());
    } 

    @Test
    public final void TestGetKnowledge(){
        Bulding bulding = new Bulding(1,2,3,4,"Test",5, 0);
        assertEquals(3, bulding.getKnowledge());
    } 

    @Test
    public final void TestGetWood(){
        Bulding bulding = new Bulding(1,2,3,4,"Test",5, 0);
        assertEquals(4, bulding.getwood());
    } 

    @Test
    public final void TestGetName(){
        Bulding bulding = new Bulding(1,2,3,4,"Test",5, 0);
        assertEquals("Test", bulding.getName());
    } 

    @Test
    public final void TestFinish(){
        Bulding bulding = new Bulding(1,2,3,4,"Test",5, 0);
        assertEquals(false, bulding.isFinish());
    } 

}
