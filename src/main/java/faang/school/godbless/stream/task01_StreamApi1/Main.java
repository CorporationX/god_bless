package faang.school.godbless.stream.task01_StreamApi1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Math math = new Math();
        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            integerList.add(i, i+1);
        }
        stringList.add("hello");
        stringList.add("goodbye");
        stringList.add("you");

    }
}
