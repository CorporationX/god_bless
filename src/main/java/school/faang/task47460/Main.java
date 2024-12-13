package school.faang.task47460;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Student> students = mapper.readValue(
                    new File("src/main/java/school/faang/task47460/students_test_data.json"),
                    new TypeReference<List<Student>>() {
                    });
            //System.out.println(ElectronicDiary.averageGrade(students));
            //System.out.println(ElectronicDiary.finalGrade(students, "Олег", "Сидоров"));
            //System.out.println(ElectronicDiary.hardSubject(students));
            ElectronicDiary.printResults(students);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
