import java.io.Console;

public class Main {
	
	public static void main(String [] args){
		testEliminateValuesStrategy();
	}
	
	public static void testEliminateValuesStrategy(){
		SudokuBoard board = new SudokuBoard("easy.pzl");
		board.print();
		
		IStrategy s = new EliminateByRowColumnBoxStrategy();
		board = s.attempt(board);
		
		Tile t = board.board[1][8];
		assert t.getValue() == null : t.getValue();
		assert !t.possibleValues.contains(1) : t.possibleValues;
		assert !t.possibleValues.contains(5);
		assert !t.possibleValues.contains(6);
		
		assert board.board[8][8].getValue() == null;
		assert !board.board[8][8].possibleValues.contains(5);
		assert !board.board[8][8].possibleValues.contains(6);
		assert !board.board[8][8].possibleValues.contains(1);
		assert !board.board[8][8].possibleValues.contains(9);
		assert !board.board[8][8].possibleValues.contains(8);
		assert !board.board[8][8].possibleValues.contains(3);
		assert !board.board[8][8].possibleValues.contains(2);
		assert board.board[8][8].possibleValues.size() == 2;
		
		assert board.board[7][3].getValue() == 8;

		System.out.println("TEST PASSED!");
		
		while(!board.isCompleted()){
			board = s.attempt(board);
		}
		
		System.out.println("");
		System.out.println("DONE!");
		board.print();
		
	}

}
