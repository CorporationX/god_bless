package school.faang.university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        addStudent(students, new Student("Student1", "Faculty 1", 2023));
        addStudent(students, new Student("Student11", "Faculty 1", 2023));
        addStudent(students, new Student("Student2", "Faculty 2", 2023));
        addStudent(students, new Student("Student31", "Faculty 1", 2024));
        addStudent(students, new Student("Student32", "Faculty 1", 2024));
        addStudent(students, new Student("Student33", "Faculty 1", 2024));
        addStudent(students, new Student("Student4", "Faculty 2", 2024));
        addStudent(students, new Student("Student44", "Faculty 2", 2024));

        listAllStudents(students);

        Map<FacultyYearDistribution, List<Student>> facultyYearDistributionListMap = groupStudentsByFacultyAndYear(students);
        listStudentsGroupedByFacultyAndYear(facultyYearDistributionListMap);

        System.out.println("\nDELETE ACTION");
        removeStudent(students, "Student32", "Faculty 1", 2024);
        System.out.println("List of student after DELETE action");
        listAllStudents(students);

        findStudentByFacultyAndYear(facultyYearDistributionListMap, "Faculty 1", 2023);
        findStudentByFacultyAndYear(facultyYearDistributionListMap, "Faculty 2", 2024);
        findStudentByFacultyAndYear(facultyYearDistributionListMap, "Faculty 3", 2024);
    }

    //    добавление нового студента в список
    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    //    удаление студента из списка по его имени, факультету и курсу
    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (students.remove(student)) {
            System.out.println("\n" + student + " has been DELETED");
        }
    }

    //    поиск всех студентов определённого факультета и курса
    public static void findStudentByFacultyAndYear(Map<FacultyYearDistribution, List<Student>> distributionMap, String faculty, int year) {
        FacultyYearDistribution facultyAndYear = new FacultyYearDistribution(faculty, year);
        String message = "\nNo students found for this Faculty and Year";
        if (distributionMap.containsKey(facultyAndYear)) {
            message = "\nFaculty: " + facultyAndYear.faculty() + " Year: " + facultyAndYear.year() + " Students: " + distributionMap.get(facultyAndYear).toString();
        }
        System.out.println(message);
    }

    //    вывод списка всех студентов сгруппированных по факультетам и курсам
    public static void listStudentsGroupedByFacultyAndYear(Map<FacultyYearDistribution, List<Student>> distributionMap) {
        System.out.println("\nDISTRIBUTION BY FACULTY AND YEAR LIST:");
        System.out.printf("| %-15s | %-15s | %-150s |%n", "Faculty:", "Year:", "Student:");
        for (FacultyYearDistribution facultyAndYear : distributionMap.keySet()) {
            System.out.printf("| %-15s | %-15s | %-150s |%n", facultyAndYear.faculty(), facultyAndYear.year(), distributionMap.get(facultyAndYear));
        }
    }

    //    метод, который будет принимать список студентов и возвращать HashMap с ключом, состоящим из пары faculty и year, и значением — списком студентов, соответствующих данному факультету и курсу
    public static Map<FacultyYearDistribution, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<FacultyYearDistribution, List<Student>> studentsDistributionMap = new HashMap<>();

        for (Student student : students) {
            FacultyYearDistribution key = new FacultyYearDistribution(student.faculty(), student.year());
            studentsDistributionMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return studentsDistributionMap;
    }

    private static void listAllStudents(List<Student> students) {
        System.out.println("\nSTUDENTS LIST:");
        System.out.printf("| %-15s | %-15s | %-15s |%n", "Student:", "Faculty:", "Year:");
        for (Student student : students) {
            System.out.printf("| %-15s | %-15s | %-15s |%n", student.name(), student.faculty(), student.year());
        }
    }
}
