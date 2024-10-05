package school.faang.countabsences;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static private Map<University, List<Student>> mainMap = new HashMap<>();
    static private University university = new University("Филология", 3);
    public static void main(String[] args) {

       List<Student> students = new ArrayList<>();
       students.add(new Student("Den","Филология", 3));
       students.add(new Student("Gibert", "Менеджмент", 1));
       students.add(new Student("Mary","Финансы", 2));
       students.add(new Student("Jane","Филология", 3));
       students.add(new Student("Bob","Менеджмент", 1));
       students.add(new Student("Werk", "IT", 2));
       students.add(new Student("Jaik","Филология", 2));

       List<Student> firstStudent = new ArrayList<>();
       firstStudent.add(new Student("Masha", "Филология", 3));
       mainMap.put(university, firstStudent);

       // 3 пункт задачи
       addStudentSameFaculty(students);
       System.out.println(mainMap);

       addNewStudent("Sasha", "Engnering", 3);
       System.out.println(mainMap);

       // удаление
       deleteStudent("Den","Филология", 3);
       System.out.println(mainMap);

       // добавление
       addNewStudent("Gibert", "Менеджмент", 1);
       addNewStudent("Mary","Финансы", 2);
       addNewStudent("Bob","Менеджмент", 1);
       addNewStudent("Werk", "Финансы", 2);
       addNewStudent("Jaik","Филология", 2);

       // поиск
       System.out.println(" ");
       System.out.println("Поиск: факлуьтет-Филилогия, курс-3 ");
       searchSameStudents("Филология", 3);

       // сортировка
       System.out.println(" ");
       System.out.println("Сортировка");
       sortStudents();

    }

    static public Map<University, List<Student>> addStudentSameFaculty(List<Student> students) {
        List<Student> filteredList = mainMap.get(university);;
        for (Map.Entry<University, List<Student>> entry : mainMap.entrySet()) {
            for (Student student : students) {
                if (entry.getKey().getFaculty().equals(student.getFaculty()) && entry.getKey().getYear().equals(student.getYear())) {;
                    filteredList.add(new Student(student.getName(), student.getFaculty(), student.getYear()));
                }
            }
        }
        mainMap.put(university, filteredList);
        return mainMap;
    }

    static public Map<University, List<Student>> addNewStudent(String name, String faculty, Integer year) {
        List<Student> newListStudents = mainMap.get(university);
        newListStudents.add(new Student(name, faculty, year));
        mainMap.put(university, newListStudents);
        return mainMap;
    }

    static public Map<University, List<Student>> deleteStudent(String name, String faculty, Integer year) {
        List<Student> listFromMap = mainMap.get(university);
        listFromMap.remove(new Student(name, faculty, year));
        mainMap.put(university, listFromMap);
        return mainMap;
    }

    static public void sortStudents() {
        List<Student> listFromMap = mainMap.get(university);
        listFromMap.sort(Comparator.comparing(Student::getFaculty).thenComparing(Student::getYear));
        for (Student student : listFromMap) {
            System.out.println(student);
        }
    }

    static public void searchSameStudents(String faculty, Integer year) {
        List<Student> listFromMap = mainMap.get(university);
        for (Student student : listFromMap) {
            if (faculty.equals(student.getFaculty()) && year.equals(student.getYear())) {
                System.out.println(student);
            }
        }
    }

}
