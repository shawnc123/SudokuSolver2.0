import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class SudokuBoard {
	
	public Tile[][] board;
	
	public SudokuBoard(){
		
	}
	
	public SudokuBoard(String fileName){
		
		try{
			String line;
			FileReader fileReader = new FileReader("src/"+fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			board = new Tile[9][9];
			int i = 0;
            while((line = bufferedReader.readLine()) != null) {
            	char[] chars = line.toCharArray();
            	for(int j = 0; j < line.length(); j++){
            		board[i][j] = new Tile(chars[j], i, j);
            	}
            	i++;
            }   
            bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
	}
	
	
	public void print(){
		for(Tile[] row : board){
			for(Tile t : row){
				t.print();
			}
			System.out.println();
		}
	}
	
	
	public Set<Integer> getRowValues(Tile[] row){
		Set<Integer> values = new HashSet<Integer>();
		for(Tile tile : row){
			values.add(tile.getValue());
		}
		return values;
	}
	
	
	public Set<Integer> getColumnValues(int column){
		Set<Integer> values = new HashSet<Integer>();
		for(Tile[] row : board){
			values.add(row[column].getValue());
		}
		return values;
	}

	public Set<Integer> getBoxValues(int boxNumber){
		Integer startCol = (boxNumber % 3) * 3;
		Integer startRow = (boxNumber / 3) * 3;
		Set<Integer> values = new HashSet<Integer>();
		
		for(int row = startRow; row < startRow+3; row++){
			for(int col = startCol; col < startCol+3; col++){
				values.add(board[row][col].getValue());
			}
		}
		
		return values;
	}
	
	public Set<Integer> getBoxValues(Tile tile){
		return getBoxValues(tile.boxNumber); 
	}

	
	
	
	

}
