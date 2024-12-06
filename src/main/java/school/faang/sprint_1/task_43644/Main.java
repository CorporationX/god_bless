package school.faang.sprint_1.task_43644;

import lombok.extern.slf4j.Slf4j;

import static school.faang.sprint_1.task_43644.Example.revers;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        try {
            revers(array);
            for (Integer e : array) {
                System.out.println(e);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}