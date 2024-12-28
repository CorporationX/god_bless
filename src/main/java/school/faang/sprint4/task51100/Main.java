package school.faang.sprint4.task51100;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task51100.model.School;
import school.faang.sprint4.task51100.model.Student;
import school.faang.sprint4.task51100.model.Task;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@Slf4j
public class Main {

    private static final int MAX_RAND_INT_BOUND = 1000;
    private static final int MIN_RAND_YEAR_BOUND = 1970;
    private static final int MIN_RAND_YEAR_DELTA = 10;
    private static final int MAX_STUDENTS_PER_SCHOOL = 10;
    private static final int MAX_TASKS_PER_SCHOOL = 5;


    public static void main(String[] args) {
        List<School> schools = getSchools();
        List<Task> tasks = getTasks();
        Tournament tournament = new Tournament();

        List<Future<School>> schoolTasks = new ArrayList<>();
        for (int i = 0; i < MAX_TASKS_PER_SCHOOL; i++) {
            schoolTasks.add(tournament.startTask(schools.get(i), tasks.get(i)));
        }

        for (int i = 0; i < MAX_TASKS_PER_SCHOOL; i++) {
            schoolTasks.add(tournament.startTask(schools.get(i), tasks.get(MAX_TASKS_PER_SCHOOL - i - 1)));
        }

        CompletableFuture<?>[] schoolTasksArray = schoolTasks.toArray(new CompletableFuture[schoolTasks.size()]);
        Future<Void> allTask = CompletableFuture.allOf(schoolTasksArray);

        try {
            allTask.get(2, TimeUnit.MINUTES);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        School winnerSchool = Tournament.getSchoolWinner(schools);
        if (winnerSchool != null) {
            log.info("Winner: {} with {} points", winnerSchool.getName(), winnerSchool.getTotalPoints());
        } else {
            log.info("Winned is undefied");
        }
    }

    private static List<Task> getTasks() {
        Task task1 = new Task("Task 1", 1, 10);
        Task task2 = new Task("Task 2", 5, 50);
        Task task3 = new Task("Task 3", 3, 30);
        Task task4 = new Task("Task 4", 8, 80);
        Task task5 = new Task("Task 5", 9, 90);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        return tasks;
    }

    private static List<School> getSchools() {
        School school1 = createSchool("School 1");
        School school2 = createSchool("School 2");
        School school3 = createSchool("School 3");
        School school4 = createSchool("School 4");
        School school5 = createSchool("School 5");

        List<School> schools = new ArrayList<>();
        schools.add(school1);
        schools.add(school2);
        schools.add(school3);
        schools.add(school4);
        schools.add(school5);
        return schools;
    }

    private static School createSchool(String name) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < MAX_STUDENTS_PER_SCHOOL; i++) {
            students.add(createStudent());
        }
        return new School(name, students);
    }

    private static Student createStudent() {
        Random random = new Random();
        int randomStudentNumber = random.nextInt(MAX_RAND_INT_BOUND);
        int randomStudentYear = random.nextInt(MIN_RAND_YEAR_DELTA);
        return new Student("Student " + randomStudentNumber,
                MIN_RAND_YEAR_BOUND + randomStudentYear);
    }
}
