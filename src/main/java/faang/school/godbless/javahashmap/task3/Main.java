package faang.school.godbless.javahashmap.task3;

import java.util.*;

public class Main {

    private static Map<FacultyInfo, List<Student>> facultyMap = new HashMap<>();

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(new Student("Иван", "ИТ", 2),
                new Student("Мария", "ИТ", 3),
                new Student("Ольга","Экономика", 4),
                new Student("Екатерина", "Юриспруденция", 1),
                new Student("Анна", "ИТ", 1),
                new Student("Алексей", "ИТ", 1),
                new Student("Дмитрий", "Экономика", 2),
                new Student("Сергей", "Юриспруденция", 1),
                new Student("Максим", "Экономика", 3));

        facultyMap = groupStudents(students);
        addStudent(new Student("Максим", "Экономика", 3));
        removeStudent(new Student("Алексей", "ИТ", 1));
        System.out.println(searchForStudentsByFaculty(new FacultyInfo("Юриспруденция", 1)));
        printAllStudentByFacultyAndYear();
    }

    public static void printAllStudentByFacultyAndYear() {
        for (Map.Entry<FacultyInfo, List<Student>> entry : facultyMap.entrySet()) {
            System.out.println("Факультет " + entry.getKey().getFaculty() +
                    " Курс " + entry.getKey().getYear());
            System.out.println("Студенты:");
            System.out.println(entry.getValue());
            System.out.println();
        }
    }

    public static void addStudent(Student student) {
        addingStudentToTheMapByFaculty(new FacultyInfo(student.getFaculty(), student.getYear()),
                    student, facultyMap);

    }

    public static void removeStudent(Student student) {
        List<Student> students = facultyMap.get(new FacultyInfo(student.getFaculty(), student.getYear()));
        if (students != null) {
            Iterator<Student> iterator = students.iterator();
            while (iterator.hasNext()) {
                Student currentStudent = iterator.next();
                if (currentStudent.equals(student)) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    public static List<Student> searchForStudentsByFaculty(FacultyInfo facultyInfo) {
        return facultyMap.get(facultyInfo);
    }

    public static HashMap<FacultyInfo, List<Student>> groupStudents(List<Student> students) {
        HashMap<FacultyInfo, List<Student>> facultyMap = new HashMap<>();
        for (Student student : students) {
            addingStudentToTheMapByFaculty(new FacultyInfo(student.getFaculty(),
                    student.getYear()), student, facultyMap);
        }
        return facultyMap;
    }

    private static void addingStudentToTheMapByFaculty(FacultyInfo facultyInfo, Student student,
                                                   Map<FacultyInfo, List<Student>> facultyMap) {
        if (facultyMap.containsKey(facultyInfo)) {
            facultyMap.get(facultyInfo).add(student);
        } else {
            facultyMap.put(facultyInfo, new ArrayList<>(Arrays.asList(student)));
        }
    }
}