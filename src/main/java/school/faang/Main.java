package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentServices studentServices = new StudentServices();
        List<Student> students = new ArrayList<>(Arrays.asList());
        students.add(new Student("John", "FCTI", 2));
        students.add(new Student("Max", "ILGIS", 1));
        students.add(new Student("Stan", "FCTI", 2));
        students.add(new Student("Amanda", "CRANCH", 4));
        students.add(new Student("Ada", "CRANCH", 1));
        students.add(new Student("Corn", "CRANCH", 1));
        students.add(new Student("Stu", "CRANCH", 1));
        students.add(new Student("Stela", "ILGIS", 6));

        Map<KeyForStudentsMap, List<Student>> studentsMap = studentServices.createStudentMap(students);

        studentServices.gropedList(studentsMap);
        System.out.println("-----------------------------------");

        //Добавление элемента с имеющимся ключом и не имеющимся
        studentServices.addNewStudent(studentsMap, new Student("Victor", "CRANCH",1));
        studentServices.addNewStudent(studentsMap, new Student("Luis", "COBR",5));

        //Удаление единственного студента с потока(вместе с ключом) и удаление студента из списка
        studentServices.deleteStudent(studentsMap, "Amanda", "CRANCH", 4);
        studentServices.deleteStudent(studentsMap, "John","FCTI", 2);

        //Поиск единственного студента и списка студентов
        studentServices.searchStudents(studentsMap,new KeyForStudentsMap(1,"ILGIS"));
        studentServices.searchStudents(studentsMap,new KeyForStudentsMap(1,"CRANCH"));

        System.out.println("-----------------------------------");

        studentServices.gropedList(studentsMap);
    }
}
