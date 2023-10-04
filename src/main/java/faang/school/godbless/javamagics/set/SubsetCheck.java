package faang.school.godbless.javamagics.set;

import java.util.HashSet;
import java.util.Set;

public class SubsetCheck {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2.add(2);
        set2.add(3);

        System.out.println(isSubset(set1,set2));
    }

    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> temp = new HashSet<>(set1);
        temp.addAll(set2);

        return temp.size() == set1.size();
    }
}
