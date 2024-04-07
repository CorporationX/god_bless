package faang.school.godbless.BJS2_4661;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alex", "IT", 2));
        students.add(new Student("Dima", "SiSS", 3));
        students.add(new Student("Jack", "IT", 4));

        HashMap<String, HashMap<Integer, List<Student>>> groupStudents = getListStudentFaculty(students);

        for(Map.Entry<String, HashMap<Integer, List<Student>>> entry : groupStudents.entrySet()) {
            System.out.println("Faculty: " + entry.getKey());
            for(Map.Entry<Integer, List<Student>> innerEntry : entry.getValue().entrySet()) {
                System.out.println("Course: " + innerEntry.getKey());
                for(Student student : innerEntry.getValue()) {
                    System.out.println("  " + student);
                }
            }
        }
    }
    public static HashMap<String, HashMap<Integer, List<Student>>> getListStudentFaculty(List<Student> students) {
        HashMap<String, HashMap<Integer, List<Student>>> mapStudents = new HashMap<>();
        for (Student student : students) {
            String keyFaculty = student.getFaculty();
            int keyYear = student.getYear();
            mapStudents.putIfAbsent(keyFaculty, new HashMap<>());
            mapStudents.get(keyFaculty).putIfAbsent(keyYear, new ArrayList<>());
            mapStudents.get(keyFaculty).get(keyYear).add(student);
        }
        return mapStudents;
    }
}
