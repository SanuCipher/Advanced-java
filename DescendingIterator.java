package linkedList;

import java.util.Iterator;
import java.util.LinkedList;


public class DescendingIterator{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String>	ls = new LinkedList<>();
		ls.add("Orange");
		ls.add("green");
		ls.add("pink");
		ls.add("red");
		ls.add("Blue");
//		ListIterator<String> listIterator = ls.listIterator(ls.size());
//        while (listIterator.hasPrevious()) {
//            System.out.println(listIterator.previous());
//        }
		Iterator iterator =  ls.descendingIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			}
	}

}