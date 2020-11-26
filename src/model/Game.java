package model;

import java.util.EnumMap;
import java.util.Map;

import output.GameInterface;

public class Game {
	private GameInterface console = new GameInterface();
	private PlayedMove lastComputerMove = PlayedMove.NONE;
	private PlayedMove lastPlayerMove = PlayedMove.NONE;
	private Map<Winer, Integer> result = new EnumMap<>(Winer.class);

	public Game() {
		result.put(Winer.PLAYER, 0);
		result.put(Winer.DRAW, 0);
		result.put(Winer.COMPUTER, 0);
	}

	public void start() {
		while (true) {
			PlayedMove playerMove = console.getPlayerMove(result, lastPlayerMove, lastComputerMove);
			lastPlayerMove = playerMove;

			PlayedMove computerMove = PlayedMove.ROCK;
			lastComputerMove = computerMove;

			GameLogic.getWiner(playerMove, computerMove);
			Winer outcome = GameLogic.getWiner(playerMove, computerMove);
			int newResult = result.get(outcome) + 1;
			result.put(outcome, newResult);
		}
	}
}