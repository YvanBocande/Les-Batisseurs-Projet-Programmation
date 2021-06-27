package Test;

import org.junit.After;
import org.junit.Before;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
* La classe Worker
* @author Yvan
* @version 1.0
*/
public class WorkerTest{


    @Test
    public final void TestWorker(){
        Worker worker = new Worker(1,1,1,1,"Test",1);
        assertNotNull("Instance non creee", worker); 
    }

    @Test
    public final void TestGetGold(){
        Worker worker = new Worker(1,2,3,4,"Test",5);
        assertEquals(1, worker.getGold());
    } 

    @Test
    public final void TestGetCost(){
        Worker worker = new Worker(1,2,3,4,"Test",5);
        assertEquals(5, worker.getCost());
    } 

    @Test
    public final void TestGetStone(){
        Worker worker = new Worker(1,2,3,4,"Test",5);
        assertEquals(2, worker.getStone());
    } 

    @Test
    public final void TestGetKnowledge(){
        Worker worker = new Worker(1,2,3,4,"Test",5);
        assertEquals(3, worker.getKnowledge());
    } 

    @Test
    public final void TestGetWood(){
        Worker worker = new Worker(1,2,3,4,"Test",5);
        assertEquals(4, worker.getWood());
    } 

    @Test
    public final void TestGetName(){
        Worker worker = new Worker(1,2,3,4,"Test",5);
        assertEquals("Test", worker.getName());
    } 

    @Test
    public final void TestWorking(){
        Worker worker = new Worker(1,2,3,4,"Test",5);
        assertEquals(false, worker.isWorking());
        worker.setIsWorking(true);
        assertEquals(true, worker.isWorking());
    } 

}