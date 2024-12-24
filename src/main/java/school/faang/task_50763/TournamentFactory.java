package school.faang.task_50763;

import java.util.List;

public class TournamentFactory {
    public static School createHogwarts() {
        return new School(Constants.HOGWARTS_NAME, List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0)
        ));
    }

    public static School createBeauxbatons() {
        return new School(Constants.BEAUXBATONS_NAME, List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        ));
    }

    public static List<Task> createTasks() {
        return List.of(
                new Task(Constants.TASK_ONE_NAME, 10, Constants.TASK_ONE_POINTS),
                new Task(Constants.TASK_TWO_NAME, 5, Constants.TASK_TWO_POINTS)
        );
    }
}
