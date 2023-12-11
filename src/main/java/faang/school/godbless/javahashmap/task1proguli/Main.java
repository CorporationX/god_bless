package faang.school.godbless.javahashmap.task1proguli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static Map<Map.Entry<String, Integer>, List<Student>> mapStudents = new HashMap<>();

    public static void main(String... args) {
        initStudents();
        mapStudents();
        infoMapStudents();

        addStudent(new Student("Frank", "Biology", 3));
        infoMapStudents();

        removeStudent("zgzgfg", "zdgzg", 100);
        removeStudent("Frank", "Biology",3);
        infoMapStudents();

        infoStudent("zdrfhdth", 2666);
        infoStudent("Chemistry", 2);
        infoMapStudents();

    }
    public  static void initStudents() {
        Student student1 = new Student("Alice", "Physics", 4);
        Student student2 = new Student("Bob", "Chemistry", 2);
        Student student3 = new Student("Charlie", "Mathematics", 3);
        Student student4 = new Student("David", "Physics", 4);
        Student student5 = new Student("Eva", "Chemistry", 2);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        System.out.println("Студенты добавлены\n");
    }

    public static Map<Map.Entry<String, Integer>, List<Student>> mapStudents() {

        for (Student student: students) {
            Map.Entry<String, Integer> entryKey = Map.entry(student.getFaculty(), student.getYear());

            if (!mapStudents.containsKey(entryKey)) {
                mapStudents.put(entryKey, new ArrayList<>());
            }

            mapStudents.get(entryKey).add(student);
        }

        System.out.println("Создан группированный список студентов по факультетам и курсам\n");
        return mapStudents;
    }

    public static void addStudent(Student student) {
        Map.Entry<String, Integer> entryKey = Map.entry(student.getFaculty(), student.getYear());

        if (!mapStudents.containsKey(entryKey)) {
            mapStudents.put(entryKey, new ArrayList<>());
        }

        mapStudents.get(entryKey).add(student);

        System.out.println("Добавлен новый студент  [ Iмя: " + student.getName() + "  Факультет: " + student.getFaculty()
                + "  Курс: " + student.getYear() + " ]\n");
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student student= new Student(name, faculty, year);
        Map.Entry<String, Integer> entryKey = Map.entry(faculty, year);

        if (!mapStudents.containsKey(entryKey)) {
            System.out.println("Удаление невозможно, нет такого студента  [ Iмя: " + student.getName() + "  Факультет: " + student.getFaculty()
                    + "  Курс: " + student.getYear() + " ]\n");
            return;
        }

        if (mapStudents.get(entryKey).contains(student)) {
            mapStudents.remove(entryKey);
            System.out.println("Удален студент  [ Iмя: " + student.getName() + "  Факультет: " + student.getFaculty()
                    + "  Курс: " + student.getYear() + " ]\n");
        } else {
            System.out.println("Удаление невозможно, нет такого студента  [ Iмя: " + student.getName() + "  Факультет: " + student.getFaculty()
                    + "  Курс: " + student.getYear() + " ]\n");
        }
    }

    public static void infoStudent(String faculty, int year) {
        Map.Entry<String, Integer> entryKey = Map.entry(faculty, year);

        if (!mapStudents.containsKey(entryKey)) {
            System.out.println("Iнформация не полученв, нет таких студентов  [ Факультет: " + faculty
                    + "  Курс: " + year + " ]\n");
            return;
        }

        System.out.println("Студенты [ Факультет: " + faculty + "   Курс: " + year + " ]");
        System.out.println("---------------------------------------------");

        int count = 0;
        for (Student student: mapStudents.get(entryKey)) {
            count++;
            System.out.println(count + ". [ Iмя: " + student.getName() + "  Факультет: " + student.getFaculty()
                    + "  Курс: " + student.getYear() + " ]");
        }

        System.out.println("---------------------------------------------\n");
    }

    public static void infoMapStudents() {
        System.out.println(" // INFO информация о всех студентах // ******************************************");

        for (Map.Entry<String, Integer> entryKey: mapStudents.keySet()) {
            infoStudent(entryKey.getKey(), entryKey.getValue());
        }

        System.out.println("************************************************************************************\n");
    }
}
