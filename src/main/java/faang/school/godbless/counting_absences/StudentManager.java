package faang.school.godbless.counting_absences;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Slf4j
public class StudentManager {
    private Map<String, List<Student>> facultyStudentMap;

    public StudentManager() {
        facultyStudentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        String key = composeKey(student.getFaculty(), student.getYear());

        facultyStudentMap.computeIfAbsent(key, composedKey -> new ArrayList<>());
        facultyStudentMap.get(key).add(student);
    }

    public void deleteStudentFromMap(String name, String faculty, int year) {
        Student studentToDelete = new Student(name, faculty, year);
        String key = composeKey(faculty, year);
        List<Student> studentList = facultyStudentMap.get(key);
        if (studentList != null) {
            studentList.remove(studentToDelete);
            // If after deleting student, the faculty is empty -> delete faculty
            if (studentList.isEmpty()) {
                facultyStudentMap.remove(key);
            }
        } else {
            log.info("Could not find student with name: {} in {} faculty and {} year", name, faculty, year);
        }
    }

    public List<Student> searchByFacultyAndYear(String faculty, int year) {
        String key = composeKey(faculty, year);

        return facultyStudentMap.get(key);
    }

    public void showStudentsGropedByFacultyAndYear() {
        for (Map.Entry<String, List<Student>> gropedStudents : facultyStudentMap.entrySet()) {
            System.out.println("Students in " +
                    gropedStudents.getKey().replace("#", " and ") + " year");
            for (Student student : gropedStudents.getValue()) {
                System.out.println(student);
            }
            System.out.println("End of List");
        }
    }

    public static StudentManager groupStudentsByFacultyAndYear(List<Student> students) {
        StudentManager result = new StudentManager();

        for (Student student : students) {
            result.addStudent(student);
        }

        return result;
    }

    public static String composeKey(String faculty, int year) {
        return faculty + "#" + year;
    }
}
