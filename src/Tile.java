import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Tile {
	
	private Integer value;
	public Integer row;
	public Integer column;
	public Integer boxNumber;
	public Set<Integer> possibleValues;
	
	public Tile(){
		possibleValues = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	} 
	
	public Tile(char c, Integer row, Integer column){
		this();
		int i = Character.getNumericValue(c);
		setValue(i);
		this.row = row;
		this.column = column;
		this.boxNumber = ((row/3)*3) + (column/3);
	}
	
	public void setValue(int i){
		value = i == -1 ? null : i;
		if(value != null){
			possibleValues = null;
		}
	}
	
	public Integer getValue(){
		return value;
	}
	
	public void eliminateValues(Set<Integer> values){
		if(this.possibleValues == null){
			return;
		}
		for(Integer i : values){
			this.possibleValues.remove(i);
		}
	}
	
	public void print(){
		if(value != null){
			System.out.printf("%d", value);
		}
		else{
			System.out.printf(" ");
		}
	}

}
