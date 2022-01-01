package assignment.factory;

import assignment.domain.Beetle;
import assignment.domain.Bird;
import assignment.domain.Board;
import assignment.domain.Challenge;

public class ChallengeFactory {

	public Challenge createChallenge() {
		int boardSizeX = 15;
		int boardSizeY = 15;
		
		Board board = new BoardFactory().createBoard(boardSizeX, boardSizeY);
		Bird bird = new Bird();

		for (int x = 0; x < boardSizeX; x++) {
			for (int y = 0; y < boardSizeY; y++) {
				Beetle beetle = new Beetle();

				// Place beetle in some cell
				beetle.goToCell(board.getCell(x, y));

				// Add beetle as a bird observer
				bird.addObserver(beetle);
			}
		}

		return new Challenge(bird, board);
	}

}
