package com.example.gc.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * The Game Activity class represents the Main Activity that occurs
 * during a Blackjack game.  It includes the proper fields and methods
 * in order to simulate playing black jack.  This version of black jack
 * assumes 52 cards in a deck
 *
 * @author Gilchrist Toh
 * @version 1.0
 * @since 2018-10-06
 */

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        
        final ArrayList<Card> playerHand = new ArrayList<Card>();
        final ArrayList<Card> dealerHand = new ArrayList<Card>();

        // ADD SOME INLINE COMMENTS WITHIN METHODS
        
        Deck myDeck = new Deck();
        final Random rand;

        final ImageView playerCard1 = (ImageView) findViewById(R.id.playerCard1);
        final ImageView playerCard2 = (ImageView) findViewById(R.id.playerCard2);
        ImageView playerCard3 = (ImageView) findViewById(R.id.playerCard3);
        ImageView playerCard4 = (ImageView) findViewById(R.id.playerCard4);
        ImageView playerCard5 = (ImageView) findViewById(R.id.playerCard5);

        final ImageView dealerCard1 = (ImageView) findViewById(R.id.dealerCard1);
        final ImageView dealerCard2 = (ImageView) findViewById(R.id.dealerCard2);
        ImageView dealerCard3 = (ImageView) findViewById(R.id.dealerCard3);
        ImageView dealerCard4 = (ImageView) findViewById(R.id.dealerCard4);
        ImageView dealerCard5 = (ImageView) findViewById(R.id.dealerCard5);

        final TextView  dealerScoreView = (TextView) findViewById(R.id.dealerTextView);
        final TextView  playerScoreView = (TextView) findViewById(R.id.playerTextView);
        final TextView winOrlose = (TextView) findViewById(R.id.wins);
        winOrlose.setText(null);

        final ArrayList<ImageView> dealerList = new ArrayList<ImageView>();
        dealerList.add(dealerCard1);
        dealerList.add(dealerCard2);
        dealerList.add(dealerCard3);
        dealerList.add(dealerCard4);
        dealerList.add(dealerCard5);

        final ArrayList<ImageView> playerList = new ArrayList<ImageView>();
        playerList.add(playerCard1);
        playerList.add(playerCard2);
        playerList.add(playerCard3);
        playerList.add(playerCard4);
        playerList.add(playerCard5);

        hide_last_three(playerList);
        hide_last_three(dealerList);


        rand = new Random();

        final ArrayList<Card> newDeck = myDeck.shuffle();

        for(int i = 0; i < 4; i++) {
            int rand_card = rand.nextInt(newDeck.size());
            Card newCard = newDeck.get(rand_card);

            if(i < 2) {
                playerHand.add(newCard);
                newDeck.remove(newCard);
            }
            else {
                dealerHand.add(newCard);
                newDeck.remove(newCard);
            }
        }


        Log.w("card","player hand 1 " + playerHand.get(0));
        Log.w("card","player hand 1 value " + playerHand.get(0).getValue());
        Log.w("card","ph 2 " + playerHand.get(1));
        Log.w("card","ph 2 value " + playerHand.get(1).getValue());
        Log.w("card","dh 1 " + dealerHand.get(0));
        Log.w("card","dh 1 value " + dealerHand.get(0).getValue());
        Log.w("card","dh 2 " + dealerHand.get(1));
        Log.w("card","dh 2 value " + dealerHand.get(1).getValue());

        int player_first_imageID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ playerHand.get(0), "null", getPackageName());
        playerCard1.setImageResource(player_first_imageID);

        int player_second_imageID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ playerHand.get(1), "null", getPackageName());
        playerCard2.setImageResource(player_second_imageID);

        int dealer_second_imageID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ dealerHand.get(1), "null", getPackageName());
        dealerCard2.setImageResource(dealer_second_imageID);


        //dealerScoreView.setText(Integer.toString(getScore(dealerHand)));

        dealerScoreView.setText(Integer.toString(0));
        playerScoreView.setText(Integer.toString(getScore(playerHand)));

        final Button hit = findViewById(R.id.hitbutton);
        final Button stand = findViewById(R.id.standbutton);

        Button newGame = (Button) findViewById(R.id.new_game_button);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide_last_three(playerList);
                hide_last_three(dealerList);
                playerHand.clear();
                dealerHand.clear();
                for(int i = 0; i < 4; i++) {
                    int rand_card = rand.nextInt(newDeck.size());
                    Card newCard = newDeck.get(rand_card);

                    if(i < 2) {
                        playerHand.add(newCard);
                        newDeck.remove(newCard);
                    }
                    else {
                        dealerHand.add(newCard);
                        newDeck.remove(newCard);
                    }
                }

                int first_player_imageID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ playerHand.get(0), "null", getPackageName());
                playerCard1.setImageResource(first_player_imageID);

                int second_player_imageID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ playerHand.get(1), "null", getPackageName());
                playerCard2.setImageResource(second_player_imageID);

                int second_dealer_imageID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ dealerHand.get(1), "null", getPackageName());
                dealerCard2.setImageResource(second_dealer_imageID);

                int imageID = getResources().getIdentifier("com.example.gc.blackjack:drawable/back_card", "null", getPackageName());
                dealerCard1.setImageResource(imageID);

                dealerScoreView.setText(Integer.toString(0));
                playerScoreView.setText(Integer.toString(getScore(playerHand)));
            }
        });

        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card newCard = getCard(newDeck);
                playerHand.add(newCard);
                int new_cardID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ newCard, "null", getPackageName());
                for(ImageView newView: playerList) {
                    if(newView.getAlpha() == 0.0){
                        newView.setAlpha((float)1.0);
                        newView.setImageResource(new_cardID);
                        break;
                    }

                }
                playerScoreView.setText(Integer.toString(getScore(playerHand)));
                if(getScore(playerHand) >= 21) {

                    if(getScore(playerHand) == 21){
                        hit.setClickable(false);
                    }
                    else {
                        hit.setClickable(false);
                        stand.setClickable(false);
                        winOrlose.setText("Dealer won!!!!");
                    }


                }

            }
        });

        stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stand.setClickable(false);
                hit.setClickable(false);

                int dealer_first_imageID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ dealerHand.get(0), "null", getPackageName());
                dealerCard1.setImageResource(dealer_first_imageID);
                dealerScoreView.setText(Integer.toString(getScore(dealerHand)));

                while(getScore(dealerHand) <= getScore(playerHand)){
                    Card newCard = getCard(newDeck);
                    dealerHand.add(newCard);
                    int new_cardID = getResources().getIdentifier("com.example.gc.blackjack:drawable/"+ newCard, "null", getPackageName());
                    for(ImageView newView: dealerList) {
                        if(newView.getAlpha() == 0.0){
                            newView.setAlpha((float)1.0);
                            newView.setImageResource(new_cardID);
                            dealerScoreView.setText(Integer.toString(getScore(dealerHand)));
                            break;
                        }

                    }
                    if(getScore(dealerHand) > 21){
                        winOrlose.setText("You Win !!!");
                    }
                }

            }
        });

    }

    /**
     * -- WRITE A METHOD DESCRIPTION
     * @param cardsList Returns the card list with last three cards not visible
     */
    public void hide_last_three(ArrayList<ImageView> cardsList){
        for(int i = 2; i < cardsList.size(); i++){
            cardsList.get(i).setAlpha((float) 0.0);
        }
    }

    /**
     * -- DESCRIBE THE METHOD
     * @param cards The cards to find the total
     * @return The total value of the cards
     *
     */
    public int getScore(ArrayList<Card> cards) {
        int total = 0;
        for(int i = 0; i < cards.size();i++){
            total+= cards.get(i).getValue();
        }
        return total;
    }

    /**
     *
     * @param newDeck The deck to get a card from
     * @return the card from the deck
     */
    public Card getCard(ArrayList<Card> newDeck){
        Random rand = new Random();
        int rand_card = rand.nextInt(newDeck.size());
        Card currCard = newDeck.get(rand_card);
        newDeck.remove(currCard);
        return currCard;
    }

}
