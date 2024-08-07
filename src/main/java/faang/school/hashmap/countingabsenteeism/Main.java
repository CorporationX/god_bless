package faang.school.hashmap.countingabsenteeism;

import java.util.*;

public class Main {
    static final Set<Student> setStudent = new HashSet<>();
    static final HashMap<List, List> mapStudent = new HashMap<>();
    public static void main(String[] args) {
        setStudent.add(new Student("Alex", "Biographical", 2));
        setStudent.add(new Student("Oleg", "Сhemical", 1));
        setStudent.add(new Student("Ivan", "Сhemical", 1));
        setStudent.add(new Student("Max", "Physical", 2));
        setStudent.add(new Student("Anna", "Physical", 2));

        for (Map.Entry entry: students(setStudent).entrySet()){
            System.out.println(entry);
        }
        printAllStudentFacultyEndYear("Сhemical",1);
    }

    public static HashMap<List, List> students(Set<Student> studentSet) {
        for (Student student: studentSet){
            ArrayList <String> kay = new ArrayList<>();
            kay.add(student.getFaculty());
            kay.add(String.valueOf(student.getYear()));
            if (!(mapStudent.containsKey(kay))){
                mapStudent.put(kay,new ArrayList<>());
                mapStudent.get(kay).add(student.getName());
            } else {
                mapStudent.get(kay).add(student.getName());
            }
        }
        return mapStudent;
    }
    public static void addNewStudent (Student student){
        setStudent.add(student);
    }
    public static void deleteStudent (Student student){
        setStudent.remove(student);
    }

    public static void printAllStudentFacultyEndYear (String faculty, int year){
        for (Student student: setStudent){
            if (student.getFaculty().equals(faculty) && student.getYear() == year){
                System.out.println(student);
            }
        }
    }
}
