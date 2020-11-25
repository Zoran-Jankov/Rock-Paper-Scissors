package output;

import java.io.IOException;
import java.util.Map;

import model.PlayedMove;
import model.Winer;

public class GameInterface
{
	public PlayedMove getPlayerMove(Map<Winer,Integer> result, PlayedMove lastPlayerMove, PlayedMove lastComputerMove)
	{
		showDisplay(result, lastComputerMove, lastComputerMove);
		
		int input = 0;
		
		try {
			input = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (!(input == 1 || input == 2 || input == 3));
		
		PlayedMove playedMove = null;
		
		switch (input)
		{
			case 1:
				playedMove = PlayedMove.ROCK;
			case 2:
				playedMove = PlayedMove.PAPER;
			case 3:
				playedMove = PlayedMove.SCISSORS;
		}
		return playedMove;
	}
	
	public void showDisplay(Map<Winer,Integer> result, PlayedMove lastPlayerMove, PlayedMove lastComputerMove)
	{
		System.out.println("ROCK PAPER SCISSORS GAME");
		System.out.println();
		System.out.println("WINS " + result.get(Winer.PLAYER));
		System.out.println("TIES " + result.get(Winer.DRAW));
		System.out.println("LOSSES " + result.get(Winer.COMPUTER));
		System.out.println();
		System.out.print("Player: " + lastPlayerMove.name() + "     Computer: " + lastComputerMove.name());
		System.out.println();
		System.out.println("Choose your next move");
		System.out.println();
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");
	}
	
	public void showLastMoves(PlayedMove playerMove, PlayedMove computerMove)
	{
		System.out.print("Player: " + playerMove.name() + "     " + computerMove.name());
	}
}