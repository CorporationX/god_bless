package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Ron", "Grifindor", 1);
        Student student2 = new Student("Germiona", "Grifindor", 1);
        Student student3 = new Student("Drako", "Slizerin", 1);
        Student student4 = new Student("Chel", "Kogtevran", 1);
        Student student5 = new Student("Chel1", "Kogtevran", 2);
        Student student6 = new Student("Chel2", "Pefenduy", 1);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        for(Map.Entry<String, List<Student>> entry : Student.findTargetStudents(students).entrySet()){
            System.out.println("Faculty: " + entry.getKey());
            System.out.println("Students:");
            for (Student student : entry.getValue()){
                System.out.println("---" + student.name);
            }
            System.out.println();
        }
    }
}
