package turn_around;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Example {

    public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<>(Arrays.asList(1, 2, 8, 4, 5));
        System.out.println(reverse(myArray));
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> numbersArray) {
        ArrayList<Integer> reverse = new ArrayList<>(numbersArray.size());
        new LinkedList<>(numbersArray)
                .descendingIterator()
                .forEachRemaining(reverse::add);
        return reverse;
    }
}
