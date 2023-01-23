package com.thehiflyer.kata.yatzy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    private YatzyScorer yatzyScorer;
    private YatzyRoll yatzyRoll;

	@BeforeEach
	public void setUp() {
		yatzyScorer = new YatzyScorer();
	}

    @Test
    public void chanceScoreIsTheSumOfTheDice() {
        int score = yatzyScorer.calculateScore(Category.CHANCE, new YatzyRoll(5, 2, 1, 4, 6));
        assertEquals(18, score);
        assertNotEquals(-18, score);
    }

    @Test
    public void YatzyScoreIsFifty() {
        int score = yatzyScorer.calculateScore(Category.YATZY, new YatzyRoll(5, 5, 5, 5, 5));
        assertEquals(50, score);
        assertNotEquals(-18, score);
    }

    @Test
    public void FullHouseScoreIsTheSumOfTheDice() {
        int score = yatzyScorer.calculateScore(Category.FULL_HOUSE, new YatzyRoll(5, 5, 6, 6, 6));
        assertEquals(28, score);
        assertNotEquals(-18, score);
    }

    @Test
    public void LargeStraightScoreIsTheSumOfTheDice() {
        int score = yatzyScorer.calculateScore(Category.LARGE_STRAIGHT, new YatzyRoll(5, 2, 4, 3, 6));
        assertEquals(20, score);
        assertNotEquals(-18, score);
    }

    @Test
    public void YatzyRollTest() {
        int[] dice = new YatzyRoll(1, 1, 1, 1, 1).get();
        assertEquals(5, dice.length);
        assertNotEquals(4, dice.length);
    }

    @Test
    public void SmallStraightScoreIsTheSumOfTheDice() {
        int score = yatzyScorer.calculateScore(Category.SMALL_STRAIGHT, new YatzyRoll(1, 2, 3, 4, 5));
        assertEquals(15, score);
        assertNotEquals(-18, score);
    }

    @Test
    public void FourOfAKindScoreIsFourTimesNumber() { //förutsätter att roll är sorterad
        int score = yatzyScorer.calculateScore(Category.FOUR_OF_A_KIND, new YatzyRoll(1, 1, 1, 1, 5));
        assertEquals(4, score);
        assertNotEquals(-18, score);
    }

    @Test
    public void ThreeOfAKindScoreIsThreeTimesNumber() { //förutsätter att roll är sorterad
        int score = yatzyScorer.calculateScore(Category.THREE_OF_A_KIND, new YatzyRoll(1, 1, 1, 3, 5));
        assertEquals(3, score);
        assertNotEquals(-18, score);
    }

    @Test
    public void PairsScoreIsTwoTimesNumber() { //förutsätter att roll är sorterad
        int score = yatzyScorer.calculateScore(Category.PAIR, new YatzyRoll(4, 4, 1, 3, 5));
        assertEquals(8, score);
        assertNotEquals(-18, score);
    }

    @Test
    public void TwoPairsScoreIsSumOfPairs() { //förutsätter att roll är sorterad
        int score = yatzyScorer.calculateScore(Category.TWO_PAIRS, new YatzyRoll(4, 4, 3, 3, 5));
        assertEquals(14, score);
        assertNotEquals(-18, score);
    }
    @Test
    public void OnesScoreIsSumOfOnes() { //förutsätter att roll är sorterad
        int score = yatzyScorer.calculateScore(Category.ONES, new YatzyRoll(1, 1, 3, 3, 5));
        assertEquals(2, score);
        assertNotEquals(-18, score);
    }
    @Test
    public void TwosScoreIsSumOfTwos() { //förutsätter att roll är sorterad
        int score = yatzyScorer.calculateScore(Category.TWOS, new YatzyRoll(2, 2, 2, 3, 5));
        assertEquals(6, score);
        assertNotEquals(-18, score);
    }
    @Test
    public void FiveDifferentPresent() {
        YatzyRoll fourOfAKindRoll = new YatzyRoll(1, 2, 3, 4, 5);
        int[] numbers = fourOfAKindRoll.get();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        boolean fiveDifferent = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                fiveDifferent = true;
                break;
            }
        }
        assert fiveDifferent;
    }

    @Test
    public void FourOfAKindPresent() {
        YatzyRoll fourOfAKindRoll = new YatzyRoll(2, 2, 2, 2, 4);
        int[] numbers = fourOfAKindRoll.get();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        boolean fourOfAKind = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 4) {
                fourOfAKind = true;
                break;
            }
        }
        assert fourOfAKind;
    }

    @Test
    public void ThreeOfAKindPresent() {
        YatzyRoll fourOfAKindRoll = new YatzyRoll(2, 2, 2, 5, 4);
        int[] numbers = fourOfAKindRoll.get();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        boolean threeOfAKind = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3) {
                threeOfAKind = true;
                break;
            }
        }
        assert threeOfAKind;
    }
}
