import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class EliminateByRowColumnBoxStrategy implements IStrategy{
	
	public SudokuBoard attempt(SudokuBoard board){
		
		//Stores the board's column values to keep from computing it for each tile
		Map<Integer, Set<Integer>> columnValuesMap = new HashMap<Integer, Set<Integer>>();
		
		Integer rowIndex = 0;
		for(Tile[] row : board.board){
			Set<Integer> rowValues = board.getRowValues(row);
			
			Integer colIndex = 0;
			for(Tile tile : row){
				//For each tile in each row, eliminate values
				tile.eliminateValues(rowValues);
				
				//Store column values
				if(!columnValuesMap.containsKey(colIndex)){
					columnValuesMap.put(colIndex, board.getColumnValues(colIndex));
				}
				//Eliminate values for tile's column
				tile.eliminateValues(columnValuesMap.get(colIndex));
				
				//Eliminate values for the tile in its box
				
				
				colIndex++;
			}
			rowIndex++;
		}
		
		//for each tile on board
			//for each tile in box
				//remove from possible values
		
		assert false : "Not implemented yet";
		return null;
	}
	
	

}
