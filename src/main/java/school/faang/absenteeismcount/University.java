package school.faang.absenteeismcount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private final Map<String, List<Student>> groupsList = new HashMap<>();

    public University(List<Student> studentsList) {
        createGroupStudents(studentsList);
    }

    private void createGroupStudents(List<Student> studentsList) {
        for(var student: studentsList) {
            String key = student.faculty() + "-" + student.year();
            groupsList.computeIfAbsent(key,s -> new ArrayList<>()).add(student);
        }
    }

    public void addNewStudent(String name, String faculty, String year) {
        var student = new Student(name, faculty, year);
        String key = student.faculty() + "-" + student.year();

        groupsList.computeIfAbsent(key, s -> new ArrayList<>()).add(student);
    }

    public void deleteStudent(String name, String faculty, String year) {
        String key = faculty + "-" + year;
        groupsList.get(key).removeIf(el -> el.equals(new Student(name, faculty, year)));
    }

    public List<Student> returnStudentsListByFacultyAndYear(String faculty, String year) {
        String key = faculty + "-" + year;

        return groupsList.get(key);
    }

    public void showAllStudents() {
        for(Map.Entry<String, List<Student>> group: groupsList.entrySet()) {
            String[] facultyYearArray = group.getKey().split("-");
            System.out.println("Faculty: " + facultyYearArray[0] + " Year: " + facultyYearArray[1]);

            for(Student student: group.getValue()) {
                System.out.println(student);
            }

            System.out.println("- - - - - - -");
        }

        System.out.println("---END---");
    }
}
