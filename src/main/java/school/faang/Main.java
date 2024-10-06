package school.faang;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList());
        students.add(new Student("John", "FCTI", 2));
        students.add(new Student("Max", "ILGIS", 1));
        students.add(new Student("Stan", "FCTI", 2));
        students.add(new Student("Amanda", "CRANCH", 4));
        students.add(new Student("Ada", "CRANCH", 1));
        students.add(new Student("Corn", "CRANCH", 1));
        students.add(new Student("Stu", "CRANCH", 1));
        students.add(new Student("Stela", "ILGIS", 6));

        Map<KeyForHashMap, List<Student>> studentsMap = createStudentMap(students);

        gropedList(studentsMap);
        System.out.println("-----------------------------------");

        //Добавление элемента с имеющимся ключом и не имеющимся
        addNewStudent(studentsMap, new Student("Victor", "CRANCH",1));
        addNewStudent(studentsMap, new Student("Luis", "COBR",5));

        //Удаление единственного студента с потока(вместе с ключом) и удаление студента из списка
        deleteStudent(studentsMap, "Amanda", "CRANCH", 4);
        deleteStudent(studentsMap, "John","FCTI", 2);

        //Поиск единственного студента и списка студентов
        searchStudents(studentsMap,new KeyForHashMap(1,"ILGIS"));
        searchStudents(studentsMap,new KeyForHashMap(1,"CRANCH"));

        System.out.println("-----------------------------------");

        gropedList(studentsMap);
    }

    public static Map<KeyForHashMap, List<Student>> createStudentMap(List<Student> list) {
        Map<KeyForHashMap, List<Student>> classmates = new HashMap<>();

        for (Student student : list) {
            KeyForHashMap key = new KeyForHashMap(student.getYear(), student.getFaculty());
            if (classmates.containsKey(key) && classmates.get(key) != null) {
                classmates.get(key).add(student);
            } else {
                List<Student> students = new ArrayList<>();
                students.add(student);
                classmates.put(key, students);
            }
        }

        return classmates;
    }

    public static Map<KeyForHashMap, List<Student>> addNewStudent(Map<KeyForHashMap, List<Student>> map, Student student) {
        KeyForHashMap newKey = new KeyForHashMap(student.getYear(), student.getFaculty());
        map.putIfAbsent(newKey, new ArrayList<>());
        map.get(newKey).add(student);
        return map;
    }

    public static void deleteStudent(Map<KeyForHashMap, List<Student>> map, String name, String faculty, int year) {
        KeyForHashMap deleteKey = new KeyForHashMap(year, faculty);
        if (map.containsKey(deleteKey)) {
            List<Student> students = map.get(deleteKey);
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getName().equals(name)) {
                    students.remove(i);
                    i--;
                }
            }

            if (students.isEmpty()){
                map.remove(deleteKey);
            }
        }
    }


    public static void searchStudents(Map<KeyForHashMap, List<Student>> map, KeyForHashMap searchKey) {
        List<Student> students = map.get(searchKey);
        System.out.println(searchKey.getFaculty() + " " + searchKey.getYear() + " :");
        for (Student student : students){
            System.out.print(student.getName() + " ");
        }
        System.out.println();
    }

    public static void gropedList(Map<KeyForHashMap, List<Student>> map) {
        for (Map.Entry<KeyForHashMap, List<Student>> entry : map.entrySet()) {
            System.out.println("Faculty: " + entry.getKey().getFaculty() +
                    " Year: " + entry.getKey().getYear() + " ");
            for (Student student : entry.getValue()) {
                System.out.print(student.getName() + " ");

            }
            System.out.println();
        }

    }
}
