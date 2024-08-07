package faang.school.godbless.task.count.student.absences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StudentManager {
    private Map<Student, Student> studentMap;
    private Map<FacultyYear, List<Student>> sortedStudentMap;
    private List<Student> studentList;

    public StudentManager(Map<Student, Student> stringStudentMap, List<Student> studentList,
                          Map<FacultyYear, List<Student>> sortedStudentMap) {
        this.studentMap = stringStudentMap;
        this.sortedStudentMap = sortedStudentMap;
        this.studentList = studentList;
    }

    static int c = 0;

    public void addNewStudent(Optional<Student> student) throws NoSuchElementException {
        student.ifPresentOrElse(std -> {
            studentMap.put(std, std);
            studentList.add(std);
        }, () -> {
            throw new NoSuchElementException("Студент не может быть null");
        });
    }

    public void deleteStudent(Student student) {
        var studentOpt = Optional.ofNullable(student);
        studentOpt.ifPresent(std -> {
            studentMap.remove(std);
            studentList.remove(std);
        });
    }

    public Student findStudent(Student student) {
        return studentMap.get(student);
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
