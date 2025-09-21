package school.faang.onlineDiary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File jsonFile = new File("src/main/java/school/faang/onlineDiary/students_test_data.json"); // положи файл сюда

        List<Student> students = Arrays.asList(mapper.readValue(jsonFile, Student[].class));

        Student helper = new Student();

        Map<String, Integer> averageCourseNote = helper.getAverageCourseNote(students);
        System.out.println("Средняя оценка по каждому предмету: " + averageCourseNote);

        Map<String, Integer> studentNote = helper.getAverageStudentNote(students, "Андрей", "Васильева");
        System.out.println("Средняя оценка: " + studentNote);

        String hardestCourse = helper.findTheHardestCourse(students);
        System.out.println("Самый сложный предмет: " + hardestCourse);

        System.out.println("\nТаблица успеваемости:");
        helper.printStudentPerformanceTable(students);
    }
}
