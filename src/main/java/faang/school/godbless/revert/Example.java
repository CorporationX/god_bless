package faang.school.godbless.revert;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Example {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        reverse(list);
    }
    public static void reverse (List<Integer> list ){
        Collections.reverse(list);
        System.out.println(list);
    }
}
