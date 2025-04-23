package school.faang.bjs2_70746;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            List<Student> students = StudentReader.parseStudentsFromJson("students_test_data.json");
            log.info("Average marks: {}", ElectronicDiaryService.findAverageMark(students));
            log.info("Student Олег Сидоров marks: {}",
                    ElectronicDiaryService.findStudentsMarks(students, "Олег", "Сидоров"));
            log.info("Hardest subject is: {}", ElectronicDiaryService.findHardestSubject(students));
        } catch (IOException e) {
            System.err.println("Ошибка чтения JSON: " + e.getMessage());
        }
    }
}