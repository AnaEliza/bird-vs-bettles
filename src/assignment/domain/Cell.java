package assignment.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cell {

	private Integer x, y;

	private Set<Cell> adjacentCells;
	private List<Beetle> beetles;

	public Cell(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		
		adjacentCells = new HashSet<Cell>();
		beetles = new ArrayList<Beetle>();
	}

	public void addAdjacentCell(Cell cell) {
		adjacentCells.add(cell);
	}

	public Set<Cell> getAdjacentCells() {
		return adjacentCells;
	}

	public void placeBeetle(Beetle beetle) {
		beetles.add(beetle);
	}
	
	public void removeBeetle(Beetle beetle) {
		beetles.remove(beetle);
	}

	public Integer getTotalBeetles() {
		return beetles.size();
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}

}
