import java.io.Console;

public class Main {
	
	public static void main(String [] args){
		testEliminateValuesStrategy();
		//testSolveMedPuzzle();
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
		
		t = board.board[8][8];
		assert t.getValue() == null;
		assert !t.possibleValues.contains(5);
		assert !t.possibleValues.contains(6);
		assert !t.possibleValues.contains(1);
		assert !t.possibleValues.contains(9);
		assert !t.possibleValues.contains(8);
		assert !t.possibleValues.contains(3);
		assert !t.possibleValues.contains(2);
		assert t.possibleValues.size() == 2;
		
		t = board.board[7][3];
		assert t.getValue() == 8;

		System.out.println("TEST PASSED!");
		
		while(!board.isCompleted()){
			board = s.attempt(board);
		}
		
		System.out.println("");
		System.out.println("DONE!");
		board.print();
		
	}

	
	public static void testSolveMedPuzzle(){
		SudokuBoard board = new SudokuBoard("med.pzl");
		board.print();
		
		IStrategy s = new EliminateByRowColumnBoxStrategy();
		for(int i = 0; i < 100; i++){
			board = s.attempt(board);
		}
		
		System.out.println("");
		board.print();
	}
}
