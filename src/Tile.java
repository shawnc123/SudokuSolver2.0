import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Tile {
	
	private Integer value;
	public Set<Integer> possibleValues;
	
	public Tile(){
		possibleValues = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	} 
	
	public Tile(char c){
		this();
		int i = Character.getNumericValue(c);
		setValue(i);
	}
	
	public void setValue(int i){
		value = i == -1 ? null : i;
		possibleValues = null;
	}
	
	public Integer getValue(){
		return value;
	}
	
	public void eliminateValues(Set<Integer> values){
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
