import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Validator {
	
	public static HashSet<Integer> allPossibleValues(){
		return new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	}
	
	public static void checkIfSomethingWrong(SudokuBoard board){
		for(int i = 0; i < 9; i++){
			if(containsDuplicates(board.getRowList(board.board[i]))){
				System.out.println("Dups in row " + i + " " + board.getRowList(board.board[i]));
				assert false : "SOMETHING IS WRONG";
			}
			if(containsDuplicates(board.getColumnList(i))){
				System.out.println("Dups in col " + i + " " + board.getColumnList(i));
				assert false : "SOMETHING IS WRONG";
			}
			if(containsDuplicates(board.getBoxList(i))){
				System.out.println("Dups in box " + i + " " + board.getBoxList(i));
				assert false : "SOMETHING IS WRONG";
			}
		}
	}
	
	public static Boolean isCompleted(SudokuBoard board){
		checkIfSomethingWrong(board);
		for(int i = 0; i < 9; i++){
			if(!isListFinished(board.getRowList(board.board[i])) || 
					!isListFinished(board.getColumnList(i)) ||
					!isListFinished(board.getBoxList(i)) ){
				return false;
			}
		}
		return true;
	}
	
	private static Boolean containsDuplicates(ArrayList<Integer> list){
		Comparator<Integer> c = new Comparator<Integer>();
		return c.containsDuplicats(list);
	}
	
	private static Boolean isListFinished(ArrayList<Integer> list){
		return (new HashSet<Integer>(list)).equals(allPossibleValues());
	}

}
