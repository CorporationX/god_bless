package BJS2_8199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student vitalia = new Student("Vitalij", "VU", 2003);
        Student veronika = new Student("Veronika", "KTU", 2011);
        Student leo = new Student("Leo", "VGTU", 2019);
        Student pavel = new Student("Pavel", "VGTU", 2019);

        List<Student> studentList = new ArrayList<>();
        studentList.add(vitalia);
        studentList.add(veronika);
        studentList.add(leo);
        studentList.add(pavel);

        Map<String, List<Student>> listStudents;
        listStudents = addStudentList(studentList);
        deleteStudent(listStudents, vitalia);

        searchFaculty(listStudents);
        showStudents(listStudents);

    }

    public static Map<String, List<Student>> addStudentList(List<Student> students) {
        Map<String, List<Student>> universities = new HashMap<>();

        for (Student student : students) {
            List<Student> studentsList = new ArrayList<>();
            if (universities.containsKey(student.faculty() + " " + student.year())) {
                System.out.println(universities.get(student.faculty() + " " + student.year()));
                List<Student> line = universities.get(student.faculty() + " " + student.year());
                studentsList.addAll(line);
                universities.put(student.faculty() + " " + student.year(), studentsList);
            }
            studentsList.add(student);
            universities.put(student.faculty() + " " + student.year(), studentsList);
        }
        return universities;
    }

    public static void deleteStudent(Map<String, List<Student>> university, Student student) {
        university.remove(student.faculty() + " " + student.year());
    }

    public static void searchFaculty(Map<String, List<Student>> university) {
        for (Map.Entry<String, List<Student>> facultyAndYear : university.entrySet()) {
            System.out.println(facultyAndYear.getValue().get(0).name());
        }
    }

    public static void showStudents(Map<String, List<Student>> allStudents) {
        for (Map.Entry<String, List<Student>> showStudentList : allStudents.entrySet()) {
            System.out.println(showStudentList.getKey() + " " + showStudentList.getValue());
        }
    }
}
