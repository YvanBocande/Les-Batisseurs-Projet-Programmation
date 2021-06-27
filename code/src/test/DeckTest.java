package test;

import Game.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
* La classe Game DECK
* @author Yvan
* @version 1.0
*/
public class DeckTest{
    private ArrayList<Card> cards;

    @Test
    public final void TestDeck(){
        Deck deck = new Deck("BW");
        assertNotNull("Instance non creee", deck); 
    }

    @Test
    public final void TestInitializeDeck(){
        Deck deck = new Deck("BW");
        assertNotNull("ArrayList non cree", this.cards); 
    }

    @Test
    public final void GetFisrtCard(){
        Deck game = new Deck("BW");
        assertEquals("a definir", this.cards.get(0)); 
    }

    @Test
    public final void deleteCard(){
        Deck game = new Deck("BW");
        assertNotEquals("a definir", this.cards.get(0)); 
    }

    @Test
    public final void ShowCard(){
        Deck game = new Deck("BW");
        assertEquals("a definir", this.cards.get(0)); 
    }
}