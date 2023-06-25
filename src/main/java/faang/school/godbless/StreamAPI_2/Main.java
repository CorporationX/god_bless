package faang.school.godbless.StreamAPI_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 23, 5, 45, 34, 2, 5, 3, 4);
        list = new HashSet<>(list).stream().toList();
        int key = 7;

        List<int[]> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int i1 = list.get(i);
                int j1 = list.get(j);
                if (i1 + j1 == key) {
                    list1.add(new int[]{i1, j1});
                }
            }
        }

        list1.forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}
