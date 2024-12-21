package school.faang.sprint4.task51100;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task51100.model.School;
import school.faang.sprint4.task51100.model.Student;
import school.faang.sprint4.task51100.model.Task;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {

    private static final int MAX_RAND_INT_BOUND = 1000;
    private static final int MIN_RAND_YEAR_BOUND = 1970;
    private static final int MIN_RAND_YEAR_DELTA = 10;
    private static final int MAX_STUDENTS_PER_SCHOOL = 10;

    public static void main(String[] args) {
        List<School> schools = getSchools();
        List<Task> tasks = getTasks();
        Tournament tournament = new Tournament();

        List<Future<School>> schoolTasks = new ArrayList<>();
        schoolTasks.add(tournament.startTask(schools.get(0), tasks.get(0)));
        schoolTasks.add(tournament.startTask(schools.get(1), tasks.get(1)));
        schoolTasks.add(tournament.startTask(schools.get(2), tasks.get(2)));
        schoolTasks.add(tournament.startTask(schools.get(3), tasks.get(3)));
        schoolTasks.add(tournament.startTask(schools.get(4), tasks.get(4)));

        schoolTasks.add(tournament.startTask(schools.get(0), tasks.get(4)));
        schoolTasks.add(tournament.startTask(schools.get(1), tasks.get(3)));
        schoolTasks.add(tournament.startTask(schools.get(2), tasks.get(2)));
        schoolTasks.add(tournament.startTask(schools.get(3), tasks.get(1)));
        schoolTasks.add(tournament.startTask(schools.get(4), tasks.get(0)));

        CompletableFuture<?>[] schoolTasksArray = schoolTasks.toArray(new CompletableFuture<?>[0]);
        Future<Void> allTask = CompletableFuture.allOf(schoolTasksArray);

        try {
            allTask.get();
        } catch (InterruptedException | ExecutionException e) {
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
        School school1 = createSchool("School 1", MAX_STUDENTS_PER_SCHOOL);
        School school2 = createSchool("School 2", MAX_STUDENTS_PER_SCHOOL);
        School school3 = createSchool("School 3", MAX_STUDENTS_PER_SCHOOL);
        School school4 = createSchool("School 4", MAX_STUDENTS_PER_SCHOOL);
        School school5 = createSchool("School 5", MAX_STUDENTS_PER_SCHOOL);

        List<School> schools = new ArrayList<>();
        schools.add(school1);
        schools.add(school2);
        schools.add(school3);
        schools.add(school4);
        schools.add(school5);
        return schools;
    }

    private static School createSchool(String name, int numOfStudents) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numOfStudents; i++) {
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
