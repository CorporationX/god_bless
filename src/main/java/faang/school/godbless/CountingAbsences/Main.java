package faang.school.godbless.CountingAbsences;

import java.util.ArrayList;
import java.util.List;


public class Main {
    List <Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Main main = new Main();
        Student student1 = new Student("Josh", "History", 1537);
        Student student2 = new Student("Ann", "History", 1537);
        Student student3 = new Student("Travis", "Math", 8457);
        Student student4 = new Student("Joshua", "Computer Science", 8402);

        main.add(student1);
        main.add(student2);
        main.add(student3);
        main.add(student4);

        main.get("History", 1537);

        main.remove("Travis", "Math", 8457);

        main.printAll();
    }

    public void add(Student student){
        students.add(student);
    }

    public void get(String faculty, int year){
        List<Student> matchedStudents = new ArrayList<>();
        for (Student student : students) {
            if(student.getFaculty().equals(faculty) && student.getYear() == year){
                matchedStudents.add(student);
            }
        }
        for (Student student : matchedStudents) {
            System.out.println("Name: " + student.getName());
            System.out.println("Faculty: " + student.getFaculty());
            System.out.println("Year: " + student.getYear() + "\n");
        }
    }
    public void remove(String name, String faculty, int year){
        students.removeIf(s -> s.getName().equals(name) && s.getFaculty().equals(faculty) && s.getYear() == year);
    }

    public void printAll(){
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Faculty: " + student.getFaculty());
            System.out.println("Yier: " + student.getYear() + "\n");
        }
    }
}
