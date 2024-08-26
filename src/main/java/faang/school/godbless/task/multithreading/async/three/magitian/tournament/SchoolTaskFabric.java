package faang.school.godbless.task.multithreading.async.three.magitian.tournament;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SchoolTaskFabric {
    private static final int NUMBER_OF_STUDENTS = 12;
    private static final int DIFFICULT_MIN = 1000;
    private static final int DIFFICULT_MAX = 5000;

    private final Random random = new Random();
    private final int numberOfSchools;
    private final int numberOfTasks;

    public List<School> getSchools() {
        return IntStream
                .rangeClosed(1, numberOfSchools)
                .mapToObj(i -> new School("School " + i, getStudents()))
                .toList();
    }

    private List<Student> getStudents() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_STUDENTS)
                .mapToObj(i -> new Student("Student " + i, getYear()))
                .toList();
    }

    private int getYear() {
        return random.nextInt(2004 - 2002) + 2002;
    }

    public List<Task> getTasks() {
        return IntStream
                .rangeClosed(1, numberOfTasks)
                .mapToObj(i -> new Task("Task " + i, getDifficult()))
                .toList();
    }

    private int getDifficult() {
        return random.nextInt(DIFFICULT_MAX - DIFFICULT_MIN) + DIFFICULT_MIN;
    }
}
