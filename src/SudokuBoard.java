import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


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
            		board[i][j] = new Tile(chars[j]);
            	}
            	i++;
            }   
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

}
