package faang.BJS2_74958;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public final class Main {
    private static final String NOBODY_WINS = "Nobody wins";
    private static final String FIRST_SCHOOL_WINS = "First School wins";
    private static final String SECOND_SCHOOL_WINS = "Second School wins";

    public static void main(final String[] args) {
        final Tournament tournament = new Tournament();
        final School firstSchool = getFirstSchool();
        final School secondSchool = getSecondSchool();

        final CompletableFuture<School> firstSchoolResult = tournament.startTask(firstSchool, new Task("Task1", 2, 10));
        final CompletableFuture<School> secondSchoolResult = tournament.startTask(secondSchool, new Task("Task2", 3, 5));

        CompletableFuture.allOf(firstSchoolResult, secondSchoolResult).join();

        int firstSchoolPoints = firstSchoolResult.join().getStudents().stream()
                .mapToInt(Student::getPoints)
                .sum();
        int secondSchoolPoints = secondSchoolResult.join().getStudents().stream()
                .mapToInt(Student::getPoints)
                .sum();

        determineWinner(firstSchoolPoints, secondSchoolPoints);
    }

    private static void determineWinner(int firstSchoolPoints, int secondSchoolPoints) {
        if (firstSchoolPoints == secondSchoolPoints) {
            log.info(NOBODY_WINS);
        } else if (firstSchoolPoints > secondSchoolPoints) {
            log.info(FIRST_SCHOOL_WINS);
        } else {
            log.info(SECOND_SCHOOL_WINS);
        }
    }

    private static School getSecondSchool() {
        return new School("School2",
                List.of(
                        new Student("Eva", 2002),
                        new Student("Maria", 2003),
                        new Student("Nikita", 2001)
                )
        );
    }

    private static School getFirstSchool() {
        return new School("School1",
                List.of(
                        new Student("Daniyal", 2002),
                        new Student("Lada", 2003),
                        new Student("Misha", 2001)
                )
        );
    }
}
