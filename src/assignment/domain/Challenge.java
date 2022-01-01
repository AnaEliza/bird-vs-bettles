package assignment.domain;


public class Challenge {

	private Bird bird;
	private Board board;

	public Challenge(Bird bird, Board board) {
		this.bird = bird;
		this.board = board;
	}

	public void start() {
		board.printBeetlePopulation();
		
		for (int i = 1; i <= 100; i++) {
			bird.fly();

			if (i == 25 || i == 50 || i == 100) {
				System.out.println("Flight #" + i);

				board.printBeetlePopulation();
				board.printMostPopulatedCell();
			}
		}
	}
	
}
