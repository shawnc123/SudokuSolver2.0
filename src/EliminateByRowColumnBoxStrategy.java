import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class EliminateByRowColumnBoxStrategy implements IStrategy{
	
	public SudokuBoard attempt(SudokuBoard board){
		
		//Stores the board's column values to keep from computing it for each tile
		Map<Integer, Set<Integer>> columnValues = new HashMap<Integer, Set<Integer>>();
		
		for(Tile[] row : board.board){
			Set<Integer> rowValues = board.getRowValues(row);
			
			Integer colIndex = 0;
			for(Tile tile : row){
				//For each tile in each row, eliminate values
				tile.eliminateValues(rowValues);
				
				//Store column values
				if(!columnValues.containsKey(colIndex)){
					columnValues.put(colIndex, board.getColumnValues(colIndex));
				}
				
				colIndex++;
			}
		}
		
		//for each tile on board
			
			//for each tile in column
				//remove from possible values
			
			//for each tile in box
				//remove from possible values
		
		assert false : "Not implemented yet";
		return null;
	}
	
	

}
