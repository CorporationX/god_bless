package school.faang.countabsences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String COMPUTER_SCIENCE = "Computer Science";
    private static final String MATH= "Mathematics";
    private static final String PHYSICS = "Physics";
    private static final String BIOLOGY = "Biology";

    public static void main(String[] args) {
        StudentService service = new StudentService();
        List<Student> students = getStudents();

        for (Map.Entry<Group, List<Student>> entry : service.createGroups(students).entrySet()){
            System.out.println("Group: " + entry.getKey().getFaculty() +  ", Students: " + entry.getValue());
        }

        service.addStudent(students,new Student("John Jones", MATH, 1999));

        service.removeStudent(students, new Student("Alice Johnson", COMPUTER_SCIENCE, 1994));

        System.out.println(service.findStudentsByFacultyAndYear(students, new Group(MATH, 1999)));

        System.out.println(students);

    }

    public static List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice Johnson", COMPUTER_SCIENCE, 1994));
        students.add(new Student("Bob Smith", COMPUTER_SCIENCE, 1994));
        students.add(new Student("Catherine Brown", MATH, 1993));
        students.add(new Student("David Wilson", PHYSICS, 1993));
        students.add(new Student("Eva Thompson", BIOLOGY, 1999));


        return students;
    }
}
