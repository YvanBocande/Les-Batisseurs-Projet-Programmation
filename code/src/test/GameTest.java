package Test;

import org.junit.After;
import org.junit.Before;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

import Game.Game;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
* La classe GameTest
* @author Yvan
* @version 1.0
*/
public class GameTest {
	private String name2;
	private String name3;
	private String name4;


    @Test
    public final void TestGame(){
        Game game = new Game(false);
        assertNotNull("Instance non creee", game); 
    }

    @Test
    public final void TestCreatePlayers(){
        // TODO - Modifier le String en fonction
        Game game = new Game(false);
    }


    @Test
    public final void TestChangeCurrent(){
        Game game = new Game(false);;
        game.changeCurrentPlayer();
        assertSame(1, game.getCurent());
    }


    @Test
    public final void TestToString(){
        // TODO - Modifier le toString en fonction
        Game game = new Game("yvan","arthur", HH, table);
        assertEquals("a definir", game.toString());
    } 

    @Test
    public final void TestGetPlayer1(){
        Game game = new Game("yvan","arthur","matteo","eva", "../data/Test");
        assertEquals(this.player1, game.GetPlayer1());
    } 

    @Test
    public final void TestGetPlayer2(){
        Game game = new Game("yvan","arthur","matteo","eva", "../data/Test");
        assertEquals(this.player1, game.GetPlayer2());
    } 

    @Test
    public final void TestGetPlayer3(){
        Game game = new Game("yvan","arthur","matteo","eva", "../data/Test");
        assertEquals(this.player1, game.GetPlayer3());
    } 

    @Test
    public final void TestGetPlayer4(){
        Game game = new Game("yvan","arthur","matteo","eva", "../data/Test");
        assertEquals(this.player1, game.GetPlayer4());
    } 

    @Test
    public final void TestGetDeck(){
        Game game = new Game("yvan","arthur","matteo","eva", "../data/Test");
        assertEquals(this.deck, game.GetDeck());
    } 

    @Test
    public final void TestGetMode(){
        Game game = new Game("yvan","arthur","matteo","eva", "../data/Test");
        assertEquals(this.mode, game.GetMode());
    } 

}