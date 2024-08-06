package faang.school.godbless.task.count.student.absences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {
    private Map<Student, Student> studentMap;
    private List<Student> studentList;

    public StudentManager(Map<Student, Student> stringStudentMap, List<Student> studentList) {
        this.studentMap = stringStudentMap;
        this.studentList = studentList;
    }

    public void addNewStudent(Student student) {
        if (student != null) {
            studentMap.put(student, student);
            studentList.add(student);
        }
    }

    public void deleteStudent(Student student) {
        if (student != null) {
            studentMap.remove(student);
            studentList.remove(student);
        }
    }

    public Student findStudent(Student student) {
        return student != null ?
                studentMap.get(student) :
                null;
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
        Map<FacultyYear, List<Student>> sortedStudentMap = new HashMap<>();
        students.forEach(student -> {
            sortedStudentMap.computeIfAbsent(
                    new FacultyYear(student.getFaculty(), student.getYear()), k -> new ArrayList<>()).add(student);
        });
        return sortedStudentMap;
    }
}
