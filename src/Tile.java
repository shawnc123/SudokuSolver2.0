
public class Tile {
	
	public Integer value;
	
	public Tile(){
		
	}
	
	public Tile(char c){
		int i = Character.getNumericValue(c);
		value = i == -1 ? null : i;
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
