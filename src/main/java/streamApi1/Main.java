package streamApi1;

import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(3, 6, 8, 3, 7, 8, 3, 3, 400, 67, 8, 5, 4, 36, 36);
        List<String> stringList = List.of("Привет", "Просвет", "Веранда", "Москва", "Кремль", "Крекер");
        Stream stream = new Stream();

//        stream.count(integerList);
//        stream.maxInt(integerList);
//        stream.srInt(integerList);
//        stream.countString(stringList);
//        stream.sortedString(stringList, "ре");
//        stream.filterLength(stringList);
//        stream.checkList(stringList);
//        stream.matchNum(integerList, 40);
        stream.stringToLength(stringList);
    }
}

