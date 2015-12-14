import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Comparator<T> {
	
	public Boolean containsDuplicats(ArrayList<T> list){
		list.removeAll(Collections.singleton(null));
		return list.size() != (new HashSet<T>(list)).size();
	}

}
