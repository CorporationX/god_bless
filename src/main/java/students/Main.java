package students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> listStud = new ArrayList<>(List.of(
                new Student("Vadim", "Cybernate", 5),
                new Student("Anna", "Finance", 4),
                new Student("Serge", "Cybernate", 5),
                new Student("Lex", "Finance", 1)
        ));

        System.out.println(sortStud(listStud));
        addStud(listStud, "New", "New", 2024);
        addStud(listStud, "New", "New", 2024);
        System.out.println(listStud);

        removeStud(listStud, "New", "New", 2024);
        System.out.println(listStud);
        searchStud(listStud, "Cybernate", 5);
        printSortedStud(listStud);
    }

    public static Map<String, List<Student>> sortStud(List<Student> studList) {

        Map<String, List<Student>> sortedStud = new HashMap<>();

        for (Student stud : studList) {
            String key = stud.getFaculty() + " - " + stud.getYear();
            sortedStud.putIfAbsent(key, new ArrayList<>());
            sortedStud.get(key).add(stud);
        }
        return sortedStud;
    }

    public static void addStud(List<Student> studList, String name, String faculty, int year) {
        studList.add(new Student(name, faculty, year));
    }

    public static void removeStud(List<Student> studList, String name, String faculty, int year) {

        Iterator<Student> studentIterator = studList.iterator();
        while (studentIterator.hasNext()) {
            Student nextStudent = studentIterator.next();
            if (nextStudent.getName().equals(name) &&
                    nextStudent.getFaculty().equals(faculty)
                    && (nextStudent.getYear() == year)) {
                studentIterator.remove();
            }
        }
//        studList.removeIf(nextStudent -> nextStudent.getName().equals(name) &
//                nextStudent.getFaculty().equals(faculty)
//                & (nextStudent.getYear() == year));
    }

    public static void searchStud(List<Student> studList, String faculty, int year) {
        Map<String, List<Student>> sortList = sortStud(studList);
        String key = faculty + " - " + year;
        System.out.println("\n" + "List of Students for faculty - '" + faculty + "' and year - " + year);
        for (Map.Entry str : sortList.entrySet()) {
            if (str.getKey().equals(key)) {
                System.out.println(str.getValue());
            }
        }
    }

    public static void printSortedStud(List<Student> studList) {
        System.out.println("\n" + "All students sorted by faculty and year:");
        for (Map.Entry entry : sortStud(studList).entrySet()) {
            System.out.println(entry);
        }
    }
}