package school.faang.sprint_2.task_45733;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 11, 12);
        try {
            System.out.println(CalculatorService.sum(numbers));
            System.out.println(CalculatorService.product(numbers));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
