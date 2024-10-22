package StudentFaculte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Faculte, List<Student>> mapFaculte = new HashMap<>();
    private static List<Student> studentList = new ArrayList<>();
    private static Map<Student, Integer> mapStudentIndex = new HashMap<>();

    public static void main(String[] args) {
        Faculte phisicsOne = new Faculte("Phisics", 1);
        Faculte byologyToo = new Faculte("Byology", 2);
        Faculte byologyThre = new Faculte("Byology", 3);
        Faculte economicOne = new Faculte("Economic", 1);
        Faculte economicThree = new Faculte("Economic", 3);

        Student kolya = new Student("Kolya", phisicsOne);
        Student sasha = new Student("Sasha", byologyToo);
        Student olya = new Student("Olya", byologyToo);
        Student sveta = new Student("Sveta", byologyThre);
        Student max = new Student("Max", economicOne);
        Student serg = new Student("Serg", economicThree);

        addStudent(kolya);
        addStudent(sasha);
        addStudent(olya);
        addStudent(sveta);
        addStudent(max);
        addStudent(serg);
        mapFaculte = createMap(studentList);

        findStudent("Byology", 2);
        printStudentsGropFromFaculte();
        printList();
        removeStudent(sveta);
        removeStudent(sasha);
        System.out.println();
        printList();

    }

    public static Map<Faculte, List<Student>> createMap(List<Student> students) {
        for (Student student : students) {
            if (mapFaculte.containsKey(student.getFaculte())) {
                mapFaculte.get(student.getFaculte()).add(student);
            } else {
                List<Student> group = new ArrayList<>();
                group.add(student);
                mapFaculte.put(student.getFaculte(), group);

            }
        }
        return mapFaculte;
    }

    public static void addStudent(Student student) {
        studentList.add(student);
        int index = studentList.size() - 1;
        mapStudentIndex.put(student, index);
    }

    public static void removeStudent(Student student) {
        int index = mapStudentIndex.get(student);
        studentList.set(index, studentList.get(studentList.size() - 1));
        mapStudentIndex.put(studentList.get(studentList.size() - 1), index);
        studentList.remove(studentList.size() - 1);
        mapStudentIndex.remove(mapStudentIndex.get(student));
    }

    public static void findStudent(String nameFaculte, int year) {
        List<Student> listStudent = mapFaculte.get(new Faculte(nameFaculte, year));
        if (listStudent == null) {
            System.out.println("No students found in this faculty");
            return;
        }
        listStudent.forEach(studentNew -> System.out.println(studentNew.getName()));
    }

    private static void printStudentsGropFromFaculte() {
        for (Map.Entry<Faculte, List<Student>> entry : mapFaculte.entrySet()) {
            System.out.println("Faculte: " + entry.getKey() + "Students:" + entry.getValue());
        }
    }

    public static void printList() {
        for (Student studentNew : studentList) {
            System.out.println(studentNew);
        }
    }
}



