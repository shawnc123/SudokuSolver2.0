import java.io.Console;

public class Main {
	
	public static void main(String [] args){
		SudokuBoard board = new SudokuBoard(args[0]);
		board.print();
		testEliminateValuesStrategy(board);
	}
	
	public static void testEliminateValuesStrategy(SudokuBoard board){
		IStrategy s = new EliminateByRowColumnBoxStrategy();
		board = s.attempt(board);
		assert board.board[1][8].getValue() == null;
		assert !board.board[1][8].possibleValues.contains(1);
		assert !board.board[1][8].possibleValues.contains(5);
		assert !board.board[1][8].possibleValues.contains(6);
		
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
	}

}
