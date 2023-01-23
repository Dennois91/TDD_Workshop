package com.thehiflyer.kata.yatzy;

import java.util.Arrays;

public class YatzyRoll {
    private int[] dice;

    public YatzyRoll(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[]{d1, d2, d3, d4, d5};
    }

    public int[] get() {
        Arrays.sort(dice);
        if (dice[0] == dice[4]) {
            //Yatzy
            return dice;
        } else if (dice[0] == dice[3] || dice[1] == dice[4]) {
            //Four of a kind
            return dice;
        }

        return dice;
    }
}
//5 randomiserade intar 1-6
