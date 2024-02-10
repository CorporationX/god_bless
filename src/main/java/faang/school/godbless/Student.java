package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    public static Map<String, List<Student>> studentsMap(List<Student> studentList){
        Map<String, List<Student>> studentsGrouped = new HashMap<>();
        for (Student students : studentList){
            String faculty = students.getFaculty();
            int year = students.getYear();
            String need = faculty + " " + year;

            if(!studentsGrouped.containsKey(need)){
                studentsGrouped.put(need, new ArrayList<>());
            }
            studentsGrouped.get(need).add(students);
        }
        return studentsGrouped;
    }

    public String toString(){
        return name;
    }

    public static void main(String args[]){
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student("Mark", "IT", 2);
        Student student2 = new Student("Jennifer", "Medicine", 1);
        Student student3 = new Student("Robert", "Medicine", 1);
        Student student4 = new Student("Erik", "Medicine", 1);
        Student student5 = new Student("Karla", "Juri", 3);
        Student student6 = new Student("Gregory", "Medicine", 4);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);

        addStudent(studentList, "James", "IT", 1);
        showStudents(studentList);

        System.out.println();
        removeStudent(studentList, "Mark", "IT", 2);
        showStudents(studentList);

        System.out.println();
        searchStudent(studentList, "IT", 2);

        searchStudent(studentList, "Medicine", 1);
    }

    public static void addStudent(List<Student> studentList, String name, String faculty, int year){
        Student student = new Student(name, faculty, year);
        studentList.add(student);
    }

    public static void showStudents(List<Student> studentList){
        Map<String, List<Student>> groupedStudents = studentsMap(studentList);
        for(Map.Entry<String, List<Student>> entry: groupedStudents.entrySet()){
            List<Student> students = entry.getValue();
            System.out.print("Группа: " + entry.getKey() + " ");
            for(Student student : students){
                System.out.print(student + " ");
            }
            System.out.println();
        }
    }

    public static void removeStudent(List<Student> studentList, String name, String faculty, int year) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year) {
                iterator.remove();
                System.out.println("Deleted!");
                return;
            }
        }
        System.out.println("Not found :(");
    }

    public static void searchStudent(List<Student> studentList, String faculty, int year){
        Map<String, List<Student>> groupedStudents = studentsMap(studentList);
        String search = faculty + " " + year;
        if (groupedStudents.containsKey(search)) {
            List<Student> students = groupedStudents.get(search);
            System.out.println("Студенты факультета " + faculty + " на " + year + " курсе:");
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("Студенты факультета " + faculty + " на " + year + " курсе не найдены");
        }
    }
}
