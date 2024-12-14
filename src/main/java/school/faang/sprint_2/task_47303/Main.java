package school.faang.sprint_2.task_47303;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream jsonInputStream = Main.class.getResourceAsStream("/students_test_data.json");
        List<Student> students = new ObjectMapper().readValue(jsonInputStream,
                new TypeReference<>() {});
        SchoolService schoolService = new SchoolService(students);

        System.out.println(schoolService.getAverageGrades());
        System.out.println(schoolService.getHardestSubject());
        System.out.println(schoolService.getStudents());
        System.out.println(schoolService.getStudentFinalGrades(students.get(0)));

        schoolService.printStudents();
    }
}
