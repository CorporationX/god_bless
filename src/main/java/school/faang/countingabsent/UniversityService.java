package school.faang.countingabsent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversityService {

    // Метод для группировки студентов по факультетам и курсам
    public Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();

            // Добавляем студента в соответствующую группу
            groupedStudents
                    .computeIfAbsent(key, k -> new ArrayList<>())
                    .add(student);
        }

        return groupedStudents;
    }

    // Метод для добавления нового студента в список
    public void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    // Метод для удаления студента из списка по имени, факультету и курсу
    public boolean removeStudent(List<Student> students, String name, String faculty, int year) {
        return students.removeIf(student ->
                student.getName().equalsIgnoreCase(name) &&
                        student.getFaculty().equalsIgnoreCase(faculty) &&
                        student.getYear() == year
        );
    }

    // Метод для поиска всех студентов определенного факультета и курса
    public List<Student> findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equalsIgnoreCase(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }

    // Метод для вывода списка всех студентов, сгруппированных по факультетам и курсам
    public void printGroupedStudents(Map<String, List<Student>> groupedStudents) {
        groupedStudents.forEach((key, studentList) -> {
            System.out.println("Faculty-Year: " + key);
            studentList.forEach(student -> System.out.println(" - " + student));
        });
    }
}
