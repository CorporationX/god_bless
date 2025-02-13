package school.faang.task58236;

import school.faang.task58236.service.ListOperations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers.add((int) (Math.random() * 1000));
        }
        ListOperations listOperations = new ListOperations();

        System.out.println(listOperations.summaChet(numbers));
    }
}
