package faang.school.godbless.tuancy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {

        add("Kirill", "IT", 4);
        add("Vanya", "Economy", 3);
        add("Alex", "Economy", 3);
        add("Dmitri", "Economy", 3);
        add("Misha", "Science", 2);
        add("Petya", "Medicine", 1);
        add("Vanya", "IT", 4);

        searchStudentByFacultyAndYear("Economy", 3);

    }
    public static void add(String name, String faculty, int year){
        students.add(new Student (name, faculty, year));
    }
    public static HashMap<StudentInfo, List<Student>> groupByFacultyAndYear(List<Student> someStudents){
        HashMap<StudentInfo, List<Student>> groupsOfStudent = new HashMap<>();

        for (Student student : someStudents){
            StudentInfo newInfo = new StudentInfo(student.getFaculty(), student.getYear());
            if (groupsOfStudent.containsKey(newInfo)){
                groupsOfStudent.get(newInfo).add(student);
            }else{
                List<Student> groupOfStudents = new ArrayList<>();
                groupOfStudents.add(student);
                groupsOfStudent.put(newInfo, groupOfStudents);
            }
        }
        return groupsOfStudent;
    }
    public static void remove(String name, String faculty, int year){
        Student student = new Student(name, faculty, year);
        students.remove(student);
    }
    public static void searchStudentByFacultyAndYear(String faculty, int year){
        StudentInfo inputInfo = new StudentInfo(faculty, year);
        System.out.println(groupByFacultyAndYear(students).get(inputInfo));
    }
    public static void listAllStudentsByFacultyAndYear(){
        System.out.println(groupByFacultyAndYear(students));

    }




    //I do not need to create a new class to add a new student to the List, as it is already exists in Collection methods

}
