package school.faang.BJS2_32503;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentManagementService {
    private final List<Student> students;
    private final Map<Student, Integer> studentToIndex;

    public StudentManagementService() {
        students = new ArrayList<>();
        studentToIndex = new HashMap<>();
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
        students.add(student);
        studentToIndex.put(student, students.size() - 1);
    }

    public void removeStudent(String name, String faculty, int year) {
        //принцип в том, чтобы долго не искать нужный элемент в списке для удаления
        //и чтобы после этого все долго не сдвигалось в списке
        //будет мапа (студент - индекс в списке), чтобы быстро удалять по индексу
        //когда удаляется студент, ищется его индекс в списке, на это место встает последний элемент из списка
        //а последний элемент просто затирается, в мапе удаляется пара с ключом в виде этого студента, а для того,
        //который был последним, обновляется информация в мапе
        Student studentToDelete = new Student(name, faculty, year);
        int index = studentToIndex.getOrDefault(studentToDelete, -1);
        if (index != -1) {
            if (index == students.size() - 1)
                students.remove(index);
            else {
                Student newStudent = students.get(students.size() - 1);
                students.set(index, newStudent);
                students.remove(students.size() - 1);
                studentToIndex.remove(studentToDelete);
                studentToIndex.put(newStudent, index);
            }
        }
    }

    public List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        return students.stream()
                .filter(student -> student.getFaculty().equals(faculty) && student.getYear() == year)
                .collect(Collectors.toList());
    }

    public void printGroupedStudents() {
        groupStudentsByFacultyAndYear(students).forEach((facultyYear, students) ->
                {
                    System.out.print(facultyYear + ": ");
                    students.forEach(student -> System.out.print(student + " "));
                    System.out.println();
                }
        );
    }
}
