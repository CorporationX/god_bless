package school.faang.train_streamapi2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        var set = Set.of(1, 2, 3, 4, 5, 6);
        int aim = 6;

        var list = new ArrayList<>(set);
        var map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == 6) {
                    //map.putIfAbsent(list.get(list.get(j)), j);
                    System.out.println(String.format("[i] = %d, [j] = %d", list.get(i), list.get(j)));
                }
            }
        }



        System.out.println("");
        map.entrySet().forEach(System.out::println);

    }
}
