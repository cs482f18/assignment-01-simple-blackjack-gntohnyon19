package com.example.gc.blackjack;

import java.util.ArrayList;

/**
 * The Player Class which holds a player object
 *
 *
 * @author Gilchrist Toh
 * @version 1.0
 * @since 2018-10-06
 */

public class Player {

    protected ArrayList<Card> hand;

    /**
     * Creates a player object
     *
     */
    public Player(){
        hand = new ArrayList<>();
    }


    /**
     * prints the cards in the hand
     */
    public void printHand(){
        for(Card currCard: hand){
            currCard.toString();
        }
    }

    /**
     *
     * @return the sum of the hand
     */
    protected int sumHand(){
        int total = 0;
        boolean is_ace = false;

        for(Card newCard: hand){
            total+= newCard.getValue();
            if(newCard.toString().charAt(0) == 'a')
            {
                is_ace = true;
            }
        }
        if(total > 21 && is_ace){
            total-=10;
        }
        return total;
    }
}
