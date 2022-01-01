package assignment.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private Cell[][] cells;

	public Board(Cell[][] cells) {
		this.cells = cells;
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}

	public void printBeetlePopulation() {
		System.out.println("Beetle Population:");

		for (int x = 0; x < cells.length; x++) {
			System.out.print("|");
			
			for (int y = 0; y < cells[x].length; y++) {
				System.out.print(cells[x][y].getTotalBeetles() + "|");
			}

			System.out.println();
		}

		System.out.println();
	}

	public void printMostPopulatedCell() {
		Integer totalBeetles = 0;
		// We can find 2 or more cells with same max population
		List<Cell> mostPopulatedCells = new ArrayList<Cell>();

		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				Cell cell = cells[x][y];

				if (cell.getTotalBeetles() > totalBeetles) {
					mostPopulatedCells.clear();
					totalBeetles = cell.getTotalBeetles();
				}

				if (cell.getTotalBeetles() == totalBeetles) {
					mostPopulatedCells.add(cell);
				}
			}
		}

		System.out.println("Most Populated Cell: " + mostPopulatedCells + " with " + totalBeetles + " beetles.\r\n");
	}

	public void printBoardMapping() {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				System.out.println("Cell " + cells[x][y] + " is adjacent to " + cells[x][y].getAdjacentCells());
			}
		}
	}

}
