package school.faang.sprint1.bjs_45265;

import java.util.*;
import com.github.javafaker.Faker;

public class DataGenerationForTest {

    public static List<Student> generateStudentsData(int count) {
        Faker faker = new Faker();
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            students.add(new Student(faker.number().numberBetween(1, 200), faker.name().fullName()));
        }
        return students;
    }

    public static List<Subject> generateSubjectsData(int count) {
        Faker faker = new Faker();
        List<Subject> subjects = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            subjects.add(new Subject(faker.number().numberBetween(1, 300), faker.educator().course()));
        }
        return subjects;
    }

    public static Map<Subject, Integer> generateSubjectMap(List<Subject> subjects) {
        Map<Subject, Integer> map = new HashMap<>();
        Random random = new Random();
        for (Subject subject : subjects) {
            map.put(subject, random.nextInt(101));
        }
        return map;
    }
}


