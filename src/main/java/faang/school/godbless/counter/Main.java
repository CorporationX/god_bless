package faang.school.godbless.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {

  private static final List<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    students.addAll(List.of(
        new Student("Стас Борецкий", "Биологии", 1),
        new Student("Лев Лещенко", "Зоологии", 4),
        new Student("Стас Костюшкин", "Мех.мат", 3),
        new Student("Лайма Вайкуле", "Мех.мат", 3),
        new Student("Рауль Гонсалес", "Биологии", 2),
        new Student("Андрей Аршавин", "Биологии", 1)
    ));
    StudentService.addStudent(new Student("Валерий Шмель", "Мех.мат", 3));
    log.info(String.format("Студенты первого курса факультета Биологии: %s",
        StudentService.findStudentsByFacultyAndYear("Биологии", 1)));
    StudentService.removeStudentByInfo("Лев Лещенко", "Зоологии", 4);

    Map<String, List<Student>> mappedStudents = StudentService.mapStudentsByFacultyAndYear();
    StudentService.printMappedStudents(mappedStudents);
  }

  private static class StudentService {

    static Map<String, List<Student>> mapStudentsByFacultyAndYear() {
      return students.stream().collect(Collectors.groupingBy(((student -> student.getFaculty() + student.getYear()))));
    }
    static void addStudent(Student student) {
      students.add(student);
      log.info(String.format("Добавили студента: %s | %s", student.getName(), students));
    }

    static void removeStudentByInfo(String name, String faculty, Integer year) {
      students.remove(new Student(name, faculty, year));
      log.info(String.format("Отчислили студента: %s | %s", name, students));
    }

    static List<Student> findStudentsByFacultyAndYear(String faculty, Integer year) {
      return students.stream()
          .filter(student -> year.equals(student.getYear()) && faculty.equals(student.getFaculty()))
          .collect(Collectors.toList());
    }

    static void printMappedStudents(Map<String, List<Student>> students) {
      students.keySet().forEach((key) -> log.info(String.format("Студенты: %s --- %s", key, students.get(key))));
    }
  }
}
