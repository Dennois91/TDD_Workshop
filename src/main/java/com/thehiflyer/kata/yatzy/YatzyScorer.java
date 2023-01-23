package com.thehiflyer.kata.yatzy;

public class YatzyScorer {
	public int calculateScore(Category category, YatzyRoll roll) {
		int res=0;

		if (category == Category.ONES){
			for (int i = 0; i < roll.get().length; i++) {
				if (roll.get()[i] ==1)
					res+=roll.get()[i];
			}
		}
		else if (category == Category.TWOS){
			for (int i = 0; i < roll.get().length; i++) {
				if (roll.get()[i] ==2)
					res+=roll.get()[i];
			}
		}else if (category == Category.PAIR){
			res = 2 * roll.get()[0];
		}
		else if (category == Category.THREE_OF_A_KIND){
			res = 3 * roll.get()[0];
		}
		else if (category == Category.TWO_PAIRS){
			for (int i = 0; i < roll.get().length-1; i++) {
				res+=roll.get()[i];
			}
		}
		else if (category == Category.FOUR_OF_A_KIND){
			res = 4 * roll.get()[0];
		}
		else if (category == Category.CHANCE	|| category == Category.SMALL_STRAIGHT || category == Category.LARGE_STRAIGHT
			|| category == Category.FULL_HOUSE) {
			for (int i = 0; i < roll.get().length; i++) {
				res += roll.get()[i];
			}
		}
		else if (category == Category.YATZY){
			res=50;
		}
		return res;
	}
}
//summan av alla 5 tärningarna :
// chance, full house, small straight, large straight

