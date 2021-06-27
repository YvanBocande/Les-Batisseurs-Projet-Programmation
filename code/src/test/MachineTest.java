package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Game.Machine;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
* La classe machine
* @author Yvan
* @version 1.0
*/
public class MachineTest{


    @Test
    public final void TestMachine(){
        Machine machine = new Machine(1,1,1,1,"Test",1,1,1,1, 0);
        assertNotNull("Instance non creee", machine); 
    }

    @Test
    public final void TestGetStone(){
        Machine machine = new Machine(1,2,3,4,"Test",5,6,7,8, 0);
        assertEquals(2, machine.getStone());
    } 

    @Test
    public final void TestGetKnowledge(){
        Machine machine = new Machine(1,2,3,4,"Test",5,6,7,8, 0);
        assertEquals(3, machine.getKnowledge());
    } 

    @Test
    public final void TestGetWood(){
        Machine machine = new Machine(1,2,3,4,"Test",5,6,7,8, 0);
        assertEquals(4, machine.getwood());
    } 

    @Test
    public final void TestGetName(){
        Machine machine = new Machine(1,2,3,4,"Test",5,6,7,8, 0);
        assertEquals("Test", machine.getName());
    } 

    @Test
    public final void TestGetStoneP(){
        Machine machine = new Machine(1,2,3,4,"Test",5,6,7,8, 0);
        assertEquals(6, machine.getStoneP());
    } 

    @Test
    public final void TestGetKnowledgeP(){
        Machine machine = new Machine(1,2,3,4,"Test",5,6,7,8, 0);
        assertEquals(7, machine.getKnowledgeP());
    } 

    @Test
    public final void TestGetWoodP(){
        Machine machine = new Machine(1,2,3,4,"Test",5,6,7,8, 0);
        assertEquals(8, machine.getWoodP());
    } 
}

