package school.faang.BJS2_32503;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentManagementService {
    private final List<Student> STUDENTS;
    private final Map<Student, Integer> STUDENT_TO_INDEX;

    public StudentManagementService() {
        STUDENTS = new ArrayList<>();
        STUDENT_TO_INDEX = new HashMap<>();
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> studentsByFacultyAndYear = new HashMap<>();
        students.forEach(student ->
                studentsByFacultyAndYear.computeIfAbsent(
                        student.getFaculty() + " " + student.getYear(),
                        facultyYear -> new ArrayList<>()
                ).add(student)
        );
        return studentsByFacultyAndYear;
    }

    public void addStudent(Student student) {
        STUDENTS.add(student);
        STUDENT_TO_INDEX.put(student, STUDENTS.size() - 1);
    }

    public void removeStudent(String name, String faculty, int year) {
        //принцип в том, чтобы долго не искать нужный элемент в списке для удаления
        //и чтобы после этого все долго не сдвигалось в списке
        //будет мапа (студент - индекс в списке), чтобы быстро удалять по индексу
        //когда удаляется студент, ищется его индекс в списке, на это место встает последний элемент из списка
        //а последний элемент просто затирается, в мапе удаляется пара с ключом в виде этого студента, а для того,
        //который был последним, обновляется информация в мапе
        Student studentToDelete = new Student(name, faculty, year);
        int index = STUDENT_TO_INDEX.getOrDefault(studentToDelete, -1);
        if (index != -1) {
            if (index == STUDENTS.size() - 1)
                STUDENTS.remove(index);
            else {
                Student newStudent = STUDENTS.get(STUDENTS.size() - 1);
                STUDENTS.set(index, newStudent);
                STUDENTS.remove(STUDENTS.size() - 1);
                STUDENT_TO_INDEX.remove(studentToDelete);
                STUDENT_TO_INDEX.put(newStudent, index);
            }
        }
    }

    public List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        return STUDENTS.stream()
                .filter(student -> student.getFaculty().equals(faculty) && student.getYear() == year)
                .collect(Collectors.toList());
    }

    public void printGroupedStudents() {
        groupStudentsByFacultyAndYear(STUDENTS).forEach((facultyYear, students) ->
                {
                    System.out.print(facultyYear + ": ");
                    students.forEach(student -> System.out.print(student + " "));
                }
        );
    }
}
