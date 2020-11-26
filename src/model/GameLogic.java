package model;

public class GameLogic {
	public static Winer getWiner(PlayedMove player, PlayedMove computer) {
		if (player == computer) {
			return Winer.DRAW;
		} else if (isPlayerWiner(player, computer)) {
			return Winer.PLAYER;
		} else {
			return Winer.COMPUTER;
		}
	}

	private static boolean isPlayerWiner(PlayedMove player, PlayedMove computer) {
		return ((player == PlayedMove.ROCK && computer == PlayedMove.SCISSORS)
				|| (player == PlayedMove.SCISSORS && computer == PlayedMove.PAPER)
				|| (player == PlayedMove.PAPER && computer == PlayedMove.ROCK));
	}
}