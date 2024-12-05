package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
public static void main(String[] args) {
    Map<Integer,String> map = new TreeMap<>();
    map.put(1, "One");
    map.put(2, "Two");
    map.merge(1,"Extended", String::concat);

    System.out.println(map.get(1));

    Map<Integer, List<String>> map2 = new TreeMap<>();
    map2.put(1, List.of("One","Two"));
    map2.put(2, List.of("Ellewen","Twelve"));
    System.out.println(map2.get(1));

    List<String> tempList = map2.get(1);
    tempList.add("Three");
    map2.replace(1,tempList);
    System.out.println(map2.get(1));

}

}
