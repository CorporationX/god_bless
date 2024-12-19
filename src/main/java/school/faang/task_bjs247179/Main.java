package school.faang.task_bjs247179;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        System.out.println(ActionsWithList.findSumOfEven(list1));
        System.out.println(ActionsWithList.findMax(list1));
        System.out.println(ActionsWithList.findAvg(list1));
        System.out.println(ActionsWithList.predicateByCondition(list1, (integer -> integer > 0)));
        System.out.println(ActionsWithList.findMinIntMoreThis(list1, 4));

        List<String> list2 = new ArrayList<>();
        list2.add("");
        list2.add("rrr");
        list2.add(("ab ab ab ab"));
        list2.add("round");
        list2.add("mouse");
        System.out.println(ActionsWithList.countFilteredStrings(list2, 'r'));
        System.out.println(ActionsWithList.filterStrings(list2, "ou"));
        System.out.println(ActionsWithList.sortStringsByLength(list2));
        System.out.println(ActionsWithList.mapStringsToInt(list2));
    }
}
