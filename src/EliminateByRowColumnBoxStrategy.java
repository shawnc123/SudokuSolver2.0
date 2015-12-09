import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EliminateByRowColumnBoxStrategy implements IStrategy{
	
	private Map<Integer, Set<Integer>> columnValuesMap;
	private Map<Integer, Set<Integer>> boxValuesMap;
	
	public SudokuBoard attempt(SudokuBoard board){
		
		buildColumnMap(board);
		buildBoxMap(board);
		
		for(Tile[] row : board.board){
			Set<Integer> rowValues = board.getRowValues(row);
			
			Integer colIndex = 0;
			for(Tile tile : row){
				//For each tile in each row, eliminate values
				tile.eliminateValues(rowValues);
				//Eliminate values for tile's column
				tile.eliminateValues(columnValuesMap.get(colIndex));
				//Eliminate values for the tile in its box
				tile.eliminateValues(boxValuesMap.get(tile.boxNumber));
				
				colIndex++;
			}
		}
		
		return board;
	}
	
	
	private void buildColumnMap(SudokuBoard board){
		//Stores the board's column values to keep from computing it for each tile
		columnValuesMap = new HashMap<Integer, Set<Integer>>();
		for(int i = 0; i < 9; i++){
			columnValuesMap.put(i, board.getColumnValues(i));
		}
	}
	
	private void buildBoxMap(SudokuBoard board){
		boxValuesMap = new HashMap<Integer, Set<Integer>>();
		for(int i = 0; i < 9; i++){
			boxValuesMap.put(i, board.getBoxValues(i));
		}
	}
	
	

}
