package faang.school.godbless.task.count.student.absences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StudentManager {
    private final Map<Student, Student> studentMap;
    private final Map<FacultyYear, List<Student>> sortedStudentMap;
    private final List<Student> studentList;

    public StudentManager(Map<Student, Student> stringStudentMap, List<Student> studentList,
                          Map<FacultyYear, List<Student>> sortedStudentMap) {
        this.studentMap = stringStudentMap;
        this.sortedStudentMap = sortedStudentMap;
        this.studentList = studentList;
    }

    public void addNewStudent(Student student) throws NoSuchElementException {
        Optional.ofNullable(student).ifPresentOrElse(std -> {
            studentMap.put(std, std);
            studentList.add(std);
        }, () -> {
            studentShouldNotNullExceptionThrow();
        });
    }

    public void deleteStudent(Student student) throws NoSuchElementException {
        Optional.ofNullable(student).ifPresentOrElse(std -> {
            if (studentList.remove(std)) {
                studentMap.remove(std);
            } else {
                studentNotFoundExceptionThrow(student);
            }
        }, () -> {
            studentShouldNotNullExceptionThrow();
        });
    }

    public Student findStudent(Student student) throws NoSuchElementException {
        Optional.ofNullable(student).ifPresentOrElse(std -> {
            if (studentMap.get(student) == null) {
                studentNotFoundExceptionThrow(student);
            }
        }, () -> {
            studentShouldNotNullExceptionThrow();
        });
        return studentMap.get(student);
    }

    private void studentShouldNotNullExceptionThrow() throws NoSuchElementException {
        throw new NoSuchElementException("Студент не может быть null");
    }

    private void studentNotFoundExceptionThrow(Student student) throws NoSuchElementException {
        throw new NoSuchElementException("Студент: %s не найден".formatted(student));
    }

    public List<Student> findAllStudentByFacultyAndYear(String faculty, int year) {
        return sortStudentByFacultyAndYear(studentList).get(new FacultyYear(faculty, year));
    }

    public Map<FacultyYear, List<Student>> findAllSortedStudentMap() {
        return sortStudentByFacultyAndYear(studentList);
    }

    public Map<FacultyYear, List<Student>> sortStudentByFacultyAndYear(List<Student> students) {
        if (students == null) {
            return null;
        }
        sortedStudentMap.clear();
        students.forEach(student -> {
            sortedStudentMap.computeIfAbsent(
                    new FacultyYear(student.getFaculty(), student.getYear()), k -> new ArrayList<>()).add(student);
        });
        return sortedStudentMap;
    }
}
