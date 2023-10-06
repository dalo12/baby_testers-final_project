package exercise1.helpers;

import java.util.List;

public abstract class GoogleHelper {

	public abstract void printResults(List<String> list, String title);
	
	public abstract boolean checkCoincidences(List<String> list1, List<String> list2);
}
