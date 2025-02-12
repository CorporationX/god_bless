package school.faang.train_streamapi2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        var initSet = Set.of(1, 2, 3, 4, 5, 6);
        int aim = 6;

        var list = new ArrayList<>(initSet);
        Set<List<Integer>> uniquePairs = new HashSet<>();

        /*for (Integer num : initSet) {
            var comp = aim - num;
            if (initSet.contains(comp) && comp > num) {
                uniquePairs.add(List.of(num, comp));
            }
        }
        System.out.println(uniquePairs);*/


        /*for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == 6) {
                    //map.putIfAbsent(list.get(list.get(j)), j);
                    System.out.println(String.format("[i] = %d, [j] = %d", list.get(i), list.get(j)));
                }
            }
        }*/

        initSet.stream()
                .peek(num1 -> System.out.println("Внешний поток: num1 = " + num1))
                .flatMap(num1 -> initSet.stream()
                    .peek(num2 -> System.out.println("   Внутренний поток: num1 = " + num1 + "; num2 = " + num2))
                        .map(num2 -> num2)).toList();
    }
}
