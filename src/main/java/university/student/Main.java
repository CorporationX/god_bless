package university.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        studentList.add(new Student("Денис Игнатенко", "Программирование и анализ данных", 1));
        studentList.add(new Student("Федор Грибков", "Программирование и анализ данных", 1));
        studentList.add(new Student("Максим Абакумов", "Проектный менеджмент в IT", 1));
        studentList.add(new Student("Михаил Ифанов", "Компьютерные технологии", 1));
        studentList.add(new Student("Григорий Печкуров", "Компьютерные технологии", 2));
        studentList.add(new Student("Игорь Суздальцев", "Проектный менеджмент в IT", 1));

        Map<String, Map<Integer, List<Student>>> groupedStudents = groupStudentsByGradeAndYear(studentList);
        printAllStudents(groupedStudents);

        addStudent(new Student("Анна Смолина", "Инженерное дело", 3));
        addStudent(new Student("Анна Смолина", "Инженерное дело", 3));
        printAllStudents(groupStudentsByGradeAndYear(studentList));

        removeStudent("Григорий Печкуров", "Компьютерные технологии", 2);
        removeStudent("Герасим", "Животноводство", 2);
        printAllStudents(groupStudentsByGradeAndYear(studentList));

        findStudentsByGradeAndYear("Проектный менеджмент в IT", 1, groupedStudents);
        findStudentsByGradeAndYear("Проектный менеджмент в IT", 3, groupedStudents);
    }

    public static Map<String, Map<Integer, List<Student>>> groupStudentsByGradeAndYear(List<Student> students) {
        Map<String, Map<Integer, List<Student>>> groupedMap = new HashMap<>();

        for (Student student : students) {
            groupedMap
                    .computeIfAbsent(student.getGrade(), key -> new HashMap<>())
                    .computeIfAbsent(student.getYear(), key -> new ArrayList<>())
                    .add(student);
        }

        return groupedMap;
    }

    public static void addStudent(Student student) {
        if (studentList.contains(student)) {
            System.out.println("Студент " + student + " уже существует в списке");
        } else {
            studentList.add(student);
            System.out.println("\nСтудент добавлен: " + student);
        }
    }

    public static void removeStudent(String name, String grade, int year) {
        boolean isRemoved = studentList.removeIf(student ->
                student.getName().equals(name) &&
                        student.getGrade().equals(grade) &&
                        student.getYear() == year);

        if (isRemoved) {
            System.out.println("\nИз списка исключен студент: " + name + ", который учился на факультете: " +
                    grade + " на " + year + " курсе.");
        } else {
            System.out.println("\nСтудент с именем `" + name + "` факультета: " +
                    grade + ", учащийся на " + year + " курсе не найден.");

        }
    }

    public static void findStudentsByGradeAndYear(String grade,
                                                  int year,
                                                  Map<String, Map<Integer, List<Student>>> groupedMap) {
        if (groupedMap.containsKey(grade) && groupedMap.get(grade).containsKey(year)) {
            List<Student> students = groupedMap.get(grade).get(year);
            System.out.println("Студенты факультета " + grade + ", учащиеся на курсе " + year + ": " + students);

        } else {
            System.out.println("Запрошенных студентов на факультете `" + grade + "` учащихся на " + year + " курсе нет");
        }
    }

    public static void printAllStudents(Map<String, Map<Integer, List<Student>>> groupedStudents) {
        System.out.println("\nВыводим список студентов, сгруппированных по факультетам и курсам:");
        for (Map.Entry<String, Map<Integer, List<Student>>> facultyEntry : groupedStudents.entrySet()) {
            String faculty = facultyEntry.getKey();
            System.out.println("\nФакультет: " + faculty);

            Map<Integer, List<Student>> yearMap = facultyEntry.getValue();
            for (Map.Entry<Integer, List<Student>> yearEntry : yearMap.entrySet()) {
                Integer year = yearEntry.getKey();
                List<Student> studentList = yearEntry.getValue();

                System.out.println("Курс: " + year);
                for (Student student : studentList) {
                    System.out.println("-> " + student);
                }
            }
        }
    }
}
