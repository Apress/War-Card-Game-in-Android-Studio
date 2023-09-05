package com.radefffactory.warcardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView playerDeck, robotDeck;
    ImageView playerCard, robotCard;

    TextView playerCount, robotCount;
    TextView playerStatus, robotStatus;

    List<Card> playerCards, robotCards;

    List<Card> deck;

    boolean isWar = false;
    List<Card> warCards;
    int warCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerDeck = findViewById(R.id.playerDeck);
        robotDeck = findViewById(R.id.robotDeck);

        playerCard = findViewById(R.id.playerCard);
        robotCard = findViewById(R.id.robotCard);

        playerCount = findViewById(R.id.playerCount);
        robotCount = findViewById(R.id.robotCount);

        playerStatus = findViewById(R.id.playerStatus);
        robotStatus = findViewById(R.id.robotStatus);

        warCards = new ArrayList<>();

        createDeck();

        dealCards();

        playerDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isWar) {
                    //not a war
                    Card playedCardPlayer = playerCards.get(0);
                    playerCards.remove(0);

                    Card playedCardRobot = robotCards.get(0);
                    robotCards.remove(0);

                    playerCard.setImageResource(playedCardPlayer.getImage());
                    robotCard.setImageResource(playedCardRobot.getImage());

                    if (playedCardPlayer.rank > playedCardRobot.rank) {
                        playerStatus.setText("Player wins the round!");
                        robotStatus.setText("");

                        playerCards.add(playedCardPlayer);
                        playerCards.add(playedCardRobot);

                        playerCount.setText(String.valueOf(playerCards.size()));
                        robotCount.setText(String.valueOf(robotCards.size()));
                    } else if (playedCardPlayer.rank < playedCardRobot.rank) {
                        playerStatus.setText("");
                        robotStatus.setText("Robot wins the round!");

                        robotCards.add(playedCardPlayer);
                        robotCards.add(playedCardRobot);

                        playerCount.setText(String.valueOf(playerCards.size()));
                        robotCount.setText(String.valueOf(robotCards.size()));
                    } else {
                        //it is war
                        playerStatus.setText("War!");
                        robotStatus.setText("War!");

                        isWar = true;
                        warCount = 0;

                        warCards.add(playedCardPlayer);
                        warCards.add(playedCardRobot);
                    }
                } else {
                    //it is war
                    if (warCount < 2) {
                        warCount = warCount + 1;

                        playerStatus.setText("War! " + warCount);
                        robotStatus.setText("War! " + warCount);

                        Card playerWarCard = playerCards.get(0);
                        playerCards.remove(0);

                        Card robotWarCard = robotCards.get(0);
                        robotCards.remove(0);

                        warCards.add(playerWarCard);
                        warCards.add(robotWarCard);

                        playerCard.setImageResource(playerWarCard.getImage());
                        robotCard.setImageResource(robotWarCard.getImage());
                    } else {
                        //end of the war
                        Card playerWarCard = playerCards.get(0);
                        playerCards.remove(0);

                        Card robotWarCard = robotCards.get(0);
                        robotCards.remove(0);

                        warCards.add(playerWarCard);
                        warCards.add(robotWarCard);

                        playerCard.setImageResource(playerWarCard.getImage());
                        robotCard.setImageResource(robotWarCard.getImage());

                        if (playerWarCard.rank > robotWarCard.rank) {
                            playerStatus.setText("Player wins the war!");
                            robotStatus.setText("");

                            playerCards.addAll(warCards);
                            warCards.clear();
                            isWar = false;

                            playerCount.setText(String.valueOf(playerCards.size()));
                            robotCount.setText(String.valueOf(robotCards.size()));
                        } else if (playerWarCard.rank < robotWarCard.rank) {
                            playerStatus.setText("");
                            robotStatus.setText("Robot wins the war!");

                            robotCards.addAll(warCards);
                            warCards.clear();
                            isWar = false;

                            playerCount.setText(String.valueOf(playerCards.size()));
                            robotCount.setText(String.valueOf(robotCards.size()));
                        } else {
                            //it is war again
                            playerStatus.setText("The war continues!");
                            robotStatus.setText("The war continues!");

                            isWar = true;
                            warCount = 0;
                        }
                    }
                }

                checkWin();
            }
        });
    }

    private void checkWin() {
        if (playerCards.size() == 0) {
            playerStatus.setText("Robot wins the game!");
            robotStatus.setText("Robot wins the game!");

            playerCount.setText("0");
            robotCount.setText("52");

            playerDeck.setVisibility(View.INVISIBLE);
            playerDeck.setEnabled(false);
        }

        if (robotCards.size() == 0) {
            playerStatus.setText("Player wins the game!");
            robotStatus.setText("Player wins the game!");

            playerCount.setText("52");
            robotCount.setText("0");

            robotDeck.setVisibility(View.INVISIBLE);
            playerDeck.setEnabled(false);
        }
    }

    private void createDeck() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                deck.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(deck);
    }

    private void dealCards() {
        playerCards = new ArrayList<>();
        robotCards = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            playerCards.add(deck.get(i));
        }

        for (int i = 26; i < deck.size(); i++) {
            robotCards.add(deck.get(i));
        }

        playerCount.setText(String.valueOf(playerCards.size()));
        robotCount.setText(String.valueOf(robotCards.size()));
    }
}