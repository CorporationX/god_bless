package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Student student1 = new Student("student1","faculty1", 2023);
        Student student2 = new Student("student2","faculty2", 2024);
        Student student3 = new Student("student3","faculty1", 2023);
        Student student4 = new Student("student4","faculty1", 2023);

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        printAll();

        removeStudent(student3);
        printAll();

//        find("faculty1", 2023, students);

        HashMap<FacultyAndYear, List<Student>> resultGroupStudent = groupStudents(students);
        find("faculty1", 2023, resultGroupStudent);

    }
    private static void addStudent(Student student){
        students.add(student);
    }

    private static void removeStudent(Student student){
        students.remove(student);
    }

    private static void printAll(){
        students.forEach(student -> {
            System.out.println(student.getName() + " ," + student.getFaculty() + " ," + student.getYear());
        });
    }

    private static void find(String faculty, int year,
                             HashMap<FacultyAndYear, List<Student>> resultGroupStudent){
        if(resultGroupStudent.isEmpty()){
            return;
        }

        List<Student> findStudent = resultGroupStudent.get(new FacultyAndYear(faculty, year));

        System.out.println("List student: ");
        findStudent.forEach(student -> {
            System.out.println(student.getName());
        });
    }

    private static HashMap<FacultyAndYear, List<Student>> groupStudents(List<Student> students){
        HashMap<FacultyAndYear, List<Student>> resultStudents = new HashMap<>();

        for(Student student : students){
            FacultyAndYear facultyAndYear = new FacultyAndYear(student.getFaculty(), student.getYear());
            List<Student> studentsList = resultStudents.get(facultyAndYear);

            if(studentsList != null){
                studentsList.add(student);
                resultStudents.put(facultyAndYear, studentsList);
                continue;
            }

            studentsList = new ArrayList<>();
            studentsList.add(student);

            resultStudents.put(facultyAndYear, studentsList);
        }
        return resultStudents;
    }
}