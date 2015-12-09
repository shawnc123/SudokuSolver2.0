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
		assert !board.board[1][8].possibleValues.contains(1);
		assert !board.board[1][8].possibleValues.contains(5);
		assert !board.board[1][8].possibleValues.contains(6);

		System.out.println("TEST PASSED!");
	}

}
