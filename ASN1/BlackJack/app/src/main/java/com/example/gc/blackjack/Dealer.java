package com.example.gc.blackjack;
import java.util.ArrayList;

/**
 * The Dealer class which create a dealer object and extends it's super class player
 *
 * @author Gilchrist Toh
 * @version 1.0
 * @since 2018-10-06
 */
public class Dealer extends Player{

    /**
     * Uses the same constructor as the player
     */
    public Dealer() {
        super();
    }

    /**
     *
     * @return if the dealer can get a new card
     */
    public boolean needCard () {
        if (this.sumHand() >= 17) {
            return false;
        }
        return true;
    }
}
