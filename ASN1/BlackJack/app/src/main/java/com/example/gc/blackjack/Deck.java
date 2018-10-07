package com.example.gc.blackjack;

import android.nfc.cardemulation.CardEmulation;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck Class which hold the deck of cards
 *
 * @author Gilchrist Toh
 * @version 1.0
 * @since 2018-10-06
 */
public class Deck
{

    public ArrayList<Card> deck;

    /**
     * instatiates a deck of Cards
     */
    public Deck()
    {
        this.deck = new ArrayList<>();
        this.deck = shuffle();
    }

    /*
     * Shuffles the deck by changing the indexes of 200 random pairs of cards in the deck.
     */
    public ArrayList<Card> shuffle()
    {
        ArrayList<Card> cards = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                Card curCard = new Card(i,j);
                cards.add(curCard);
            }
        }
        return cards;
    }
    /*
     * Draws a card from the deck.
     */
    public Card deal()
    {
        if(this.deck.isEmpty()) {
            this.deck = shuffle();
        }
        return this.deck.get(0);
    }

    /**
     * prints the cards in the deck
     */
    public void print() {
        for(Card currCard: deck) {
            currCard.toString();
        }
    }
}

