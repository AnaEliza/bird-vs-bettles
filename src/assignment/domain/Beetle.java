package assignment.domain;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Set;

public class Beetle implements Observer {
	
	private Cell cell;
	
	public void goToCell(Cell cell) {
		this.cell = cell;
		cell.placeBeetle(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Cell landingCell = getLandingCell();
		
		cell.removeBeetle(this);
		landingCell.placeBeetle(this);
		
		cell = landingCell;
	}
	
	private Cell getLandingCell() {
		Set<Cell> adjacentCells = cell.getAdjacentCells();
		
		// Picking a random cell to land
		int randomPosition = new Random().nextInt(adjacentCells.size());
		int i = 0;
		
		for (Cell cell : adjacentCells) {
			if (i == randomPosition) {
				return cell;
			}
			
			i++;
		}
		
		throw new RuntimeException("Error at getLandingCell()");
	}
	
}
