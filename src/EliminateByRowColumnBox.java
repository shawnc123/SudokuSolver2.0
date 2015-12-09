import java.util.Set;


public class EliminateByRowColumnBox implements IStrategy{
	
	public SudokuBoard attempt(SudokuBoard board){
		
		//For each tile in each row, eliminate values
		for(Tile[] row : board.board){
			Set<Integer> rowValues = board.getRowValues(row);
			
			for(Tile tile : row){
				tile.eliminateValues(rowValues);
			}
		}
		
		//for each tile on board
			//for each tile in row
				//remove from possible values
			
			//for each tile in column
				//remove from possible values
			
			//for each tile in box
				//remove from possible values
		
		assert false : "Not implemented yet";
		return null;
	}
	
	

}
