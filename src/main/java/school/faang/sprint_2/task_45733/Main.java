package school.faang.sprint_2.task_45733;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(5);
        numbers.add(8);
        numbers.add(9);
        try {
            System.out.println(CalculatorService.sum(numbers));
            System.out.println(CalculatorService.product(numbers));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
