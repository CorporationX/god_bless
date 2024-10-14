package school.faang.onlineJournal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    StudentService studentService = new StudentService();
    Gson gson = new Gson();

    List<Student> students = gson.fromJson(
        new FileReader("src/main/java/school/faang/onlineJournal/resources/students_test_data.json"),
        new TypeToken<List<Student>>(){}.getType());

    System.out.printf("средние оценки учеников по всей школе %s",
        studentService.calculateAverageGradesBySubject(students));

    System.out.printf("средний бал учеников с именем \"Олег\" и фамилией \"Сидоров\" \n %s \n",
        studentService.calculateFinalGradesForStudent(students, "Олег", "Сидоров"));

    System.out.printf("самый сложный предмет: %s \n", studentService.hardestSubject(students));

    studentService.showStudentPerformanceTable(students);
  }
}
