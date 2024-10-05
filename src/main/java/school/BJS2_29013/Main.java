package school.BJS2_29013;

import java.util.*;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student student1 = new Student("Вася", "Физ-тех", 4);
        Student student2 = new Student("Петя", "Юрка", 3);
        Student student3 = new Student("Гриша", "Физ-тех", 4);
        Student student4 = new Student("Миша", "Математика", 2);
        Student student5 = new Student("Арсений", "Физ-тех", 4);
        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        addStudent(student5);
        printResult(groupStudent(students));
        System.out.println("-----------------------------------------");
        System.out.println(Arrays.asList(getStudents("Физ-тех", 4, groupStudent(students))));
        System.out.println("-----------------------------------------");
        removeStudent("Арсений", "Физ-тех", 4);
        System.out.println(Arrays.asList(getStudents("Физ-тех", 4, groupStudent(students))));

    }

//метод, который принимает список студентов и возвращает HashMap с ключом состоящим из пары faculty и year
    private static Map<MapKey, List<Student>> groupStudent(List<Student> students) {
        Map<MapKey, List<Student>> mappa = new HashMap<>();
        MapKey mapKey;
        for (Student student : students) {
            mapKey = new MapKey();
            mapKey.setFacultat(student.getFacultat());
            mapKey.setYear(student.getYear());
            mappa.computeIfAbsent(mapKey, k -> new ArrayList<>()).add(student);
        }
        return mappa;
    }

//добавление нового студента в список
    private static void addStudent(Student student) {
        students.add(student);
    }

//удаление студента из списка по его имени, факультету и курсу
    private static void removeStudent(String name, String facultat, int year) {
        students.removeIf(student -> Objects.equals(student.getFacultat(), facultat)
                && Objects.equals(student.getYear(), year)
                && Objects.equals(student.getName(), name));
    }

//вывод списка всех студентов сгруппированных по факультетам и курсам
    private static void printResult(Map<MapKey, List<Student>> mappa) {
        for (Map.Entry<MapKey, List<Student>> entry : mappa.entrySet()) {
            System.out.printf("Для факультета %s и курса номер %d список студентов: ", entry.getKey().getFacultat(), entry.getKey().getYear());
            System.out.println();
            System.out.println(entry.getValue());
        }
    }

//поиск всех студентов определённого факультета и курса
    private static List<Student> getStudents(String facultat, int year, Map<MapKey, List<Student>> mappa) {
        for (MapKey mapKey : mappa.keySet()) {
            if (Objects.equals(mapKey.getFacultat(), facultat) && Objects.equals(mapKey.getYear(), year)) {
                return mappa.get(mapKey);
            }
        }
        return null;
    }

}