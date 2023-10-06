package helpers;

import java.util.Collections;
import java.util.List;

public class GoogleHelperImpl extends GoogleHelper {

	@Override
	public void printResults(List<String> list, String title) {
		System.out.println(title);
		
		int i = 1;
		for(String element : list) {
			System.out.println(i + ". " + element);
			i++;
		}
		
	}

	@Override
	public boolean checkCoincidences(List<String> list1, List<String> list2) {
		return !Collections.disjoint(list1, list2);
	}	
	
}
