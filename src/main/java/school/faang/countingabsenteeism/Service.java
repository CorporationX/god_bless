package school.faang.countingabsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

    public List<Student> studentList = new ArrayList<>();

    public Map<Pair, List<Student>> mapStudent(List<Student> students) {
        Map<Pair, List<Student>> studentMap = new HashMap<>();
        for (Student student : students) {
            Pair key = new Pair(student.getFaculty() + student.getYear());
            studentMap.putIfAbsent(key, new ArrayList<>());

        }
        return studentMap;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(String name, String faculty, int year) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (s.getName().equals(name) && s.getFaculty().equals(faculty) && (s.getYear() == year)) {
                studentList.remove(i);
                i--;
            }
        }
    }

    public List<Student> searchStudent(String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }

    public Map<Pair, List<Student>> groupStudentByFacultyAndYear() {
        Map<Pair, List<Student>> groupedStudent = new HashMap<>();
        for (Student student : studentList) {
            Pair key = new Pair(student.getFaculty() + "-" + student.getYear());
            groupedStudent.putIfAbsent(key, new ArrayList<>());
            groupedStudent.get(key).add(student);
        }
        return groupedStudent;
    }

    public void printGroupedStudent() {
        Map<Pair, List<Student>> groupStudents = groupStudentByFacultyAndYear();
        for (Map.Entry< Pair, List<Student>> entry : groupStudents.entrySet()) {
            System.out.println("Key" + entry.getKey() + " -> Students: " + entry.getValue());
        }
    }
}
