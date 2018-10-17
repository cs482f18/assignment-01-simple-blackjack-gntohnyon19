package com.example.gc.blackjack;

import android.util.Log;

/**
 * The Card class which creates a card object
 *
 * @author Gilchrist Toh
 * @version 1.0 10/06/2018 -- Write Date Here
 * @since 1.0 // @since is for specifying from which release has this class been added to this software
 */
public class Card {
    /** Write Javadoc comments for your instance variables */
    private int rank;// Rank of the card
    private int suit;// Suit of the card
    private int value;//Value of the card
    private static String[] ranks = {"ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
    private static String[] suits = {"clubs","diamonds","hearts","spades"};// 1: Clubs, 2: Diamonds, 3: Hearts, 4: Spades

    /**
     * Parameterized constructor for a Card class
     * @param suit The suit of the card
     * @param value The value of the card
     */
    public Card (int suit, int value) {
        this.suit = suit;
        this.rank = value;
    }

    /**
     *
     * @return The rank of the card
     */
    public int getRank () {
        return rank;
    }

    /**
     * You have to specify what is the purpose of a method in the javadoc method description
     * @return The suit of the card
     */
    public int getSuit () {
        return suit;
    }

    /**
     *
     * @return The value of the card
     */
    public int getValue () {
        if(rank > 9)
        {
            value = 10;
            return value;
        }
        else if(rank == 1)
        {
            value = 11;
            return value;
        }
        else
        {
            value = rank;
        }
        return value + 1;
    }

    /**
     *
     * @return Prints the cards in a readable form
     */
    public String toString()
    {
        return  suits[suit] + "_of_" + ranks[rank];
    }
}
