package lecture_1;

import java.util.Random;

//sample client code that manipulates two ArrayIntList objects

public class ArrayIntListClient {
	public static void main(String[] args) {
		IntList list = new ArrayIntList(25);
		list.add(3);
		list.add(7);
		list.add(11);
		list.add(list.size(), 17);
		System.out.println("initial list = " + list);
		list.add(0, 2);
		list.add(2, 5);
		System.out.println("after some adds, list = " + list);
		System.out.println();

		for (int i = 1; i < 10; i += 2) {
			if (list.contains(i)) {
				System.out.println("index of " + i + " = " + list.indexOf(i));
			} else {
				System.out.println("list does not contain " + i);
			}
		}
		System.out.println();

		for (int i = 0; i < list.size(); i++) {
			System.out.println("get(" + i + ") returns " + list.get(i));
		}
		System.out.println();

		IntList list2 = new ArrayIntList();
		list2.add(42);
		System.out.println("after adding 42 to empty list, list2 = " + list2);
		
		// addAll() is unique to ArrayIntList objects and since we declared
		// list2 to be an interface object, we can't use addAll
		//list2.addAll(list);
		
		
		System.out.println("after addAll of list, list2 = " + list2);
		System.out.println("and list still = " + list);
		System.out.println();

		Random r = new Random();
		while (list.size() > 0) {
			int i = r.nextInt(list.size());
			list.remove(i);
			System.out.println("after removing at " + i + " list = " + list);
		}
	}
}
