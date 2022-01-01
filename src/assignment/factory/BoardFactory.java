package assignment.factory;

import assignment.domain.Board;
import assignment.domain.Cell;

public class BoardFactory {

	public Board createBoard(Integer sizeX, Integer sizeY) {
		Cell[][] cells = createCells(sizeX, sizeY);
		mapCells(cells);

		return new Board(cells);
	}

	private Cell[][] createCells(Integer sizeX, Integer sizeY) {
		Cell[][] cells = new Cell[sizeX][sizeY];

		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				cells[x][y] = new Cell(x + 1, y + 1);
			}
		}

		return cells;
	}

	private void mapCells(Cell[][] cells) {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				Cell cell = cells[x][y];
				
				try {
					cell.addAdjacentCell(cells[x - 1][y]);
				} catch (ArrayIndexOutOfBoundsException e) {
					// If this error appears is because the cell is on the top edge of the board
				}

				try {
					cell.addAdjacentCell(cells[x + 1][y]);
				} catch (ArrayIndexOutOfBoundsException e) {
					// If this error appears is because the cell is on the bottom edge of the board
				}
				
				try {
					cell.addAdjacentCell(cells[x][y - 1]);
				} catch (ArrayIndexOutOfBoundsException e) {
					// If this error appears is because the cell is on the left edge of the board
				}

				try {
					cell.addAdjacentCell(cells[x][y + 1]);
				} catch (ArrayIndexOutOfBoundsException e) {
					// If this error appears is because the cell is on the right edge of the board
				}
			}
		}
	}

}
