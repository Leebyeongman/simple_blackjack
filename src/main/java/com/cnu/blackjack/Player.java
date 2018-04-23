package com.cnu.blackjack;


import com.cnu.blackjack.exception.NoEnoughBalanceException;
import lombok.Data;

@Data
public class Player {

    private int balance;
    private int currentBet;
    private Hand playerHand;

    public Player(int balance, Deck deck) {
        this.balance = balance;
        playerHand = new Hand(deck);

    }

    public void placeBet(int bet) {
        if( bet > balance ) {
            throw new NoEnoughBalanceException();
        }
        balance = balance - bet;
        this.currentBet = bet;
    }

    public int getScore() {
        int score = 0;
        for( int i=0 ; i<playerHand.getCurrentHandSize() ; i++ ) {
            score += playerHand.getHandList().get(i).getRank();
        }
        return score;
    }
}
