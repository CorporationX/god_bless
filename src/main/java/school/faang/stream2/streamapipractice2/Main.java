package school.faang.stream2.streamapipractice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int reference = 6;

        try{
            List<List<Integer>> pairs = new ArrayList<>();
            numbers.stream()
                    .filter(integer -> numbers.contains(reference - integer))
                    .
        }
    }
}
