package school.faang.sprint_1.task_43644;

import static school.faang.sprint_1.task_43644.Example.revers;

public class Main {
    public static void main(String[] args) {
        int[] example = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        revers(example);
        for (Integer e : example) {
            System.out.println(e);
        }
    }
}