package com.example.gc.blackjack;
import java.util.ArrayList;

/**
 * The Dealer class which create a dealer object and extends it's super class player
 *
 * @author Gilchrist Toh
 * @version 1.0 - Add Date here -- 2018-10-06
 * @since - put a version number here
 */
public class Dealer extends Player{

    /**
     * Uses the same constructor as the player
     */
    public Dealer() {
        super();
    }

    /**
     * -- Describe the purpose of the method
     * @return if the dealer can get a new card
     */
    public boolean needCard () {
        if (this.sumHand() >= 17) {
            return false;
        }
        return true;
    }
}
