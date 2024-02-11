package faang.school.godbless.proguly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static Map<Pair<String, Integer>, List<Student>> sortedStudents = new HashMap<>();

    public static void main(String[] args) {
        // Заполняем список данными о студентах
        students.add( new Student( "Ivanov Ivan", "Computer Science", 2 ) );
        students.add( new Student( "Petrov Petr", "Computer Science", 2 ) );
        students.add( new Student( "Sinitsyn Alex", "Mathematics", 1 ) );
        students.add( new Student( "Nikolaev Nikolay", "History", 4 ) );
        students.add( new Student( "Egorov Egor", "History", 4 ) );
        sortedStudents = sortStudent( students );
        printStudents();

        addNewStudent( new Student( "Nazarov Andrey", "Mathematics", 1 ) );
        removeStudentByNameFacultyAndYear( "Ivanov Ivan", "Computer Science", 2 );
        removeStudentByNameFacultyAndYear( "Petrov Petr", "Computer Science", 2 );
        System.out.println( "/////////////////////////////////////////////////////////////////" );
        System.out.println( "Students in List after removal:" );
        System.out.println( students );
        System.out.println( findStudentsByFacultyAndYear( "History", 4 ) );//ok

    }

    public static Map<Pair<String, Integer>, List<Student>> sortStudent(List<Student> students) {

        for (Student student : students) {
            Pair<String, Integer> pair = new Pair<>( student.getFaculty(), student.getYear() );
            if (!sortedStudents.containsKey( pair )) {
                sortedStudents.put( pair, new ArrayList<>() );
            }
            sortedStudents.get( pair ).add( student );
        }

        return sortedStudents;
    }

    // вывод списка всех студентов сгруппированных по факультетам и курсам в виде значения hashmap
    public static void printStudents() {
        for (Map.Entry<Pair<String, Integer>, List<Student>> entry : sortedStudents.entrySet()) {
            System.out.println( "Common faculty and year students: " );
            System.out.println( entry.getValue() );
            System.out.println( "*****************************************************************" );
        }
    }

    // Метод для добавления студента в список
    public static void addNewStudent(Student s) {
        students.add( s );
    }

    // Метод для удаления студента из списка по его имени, факультету и курсу
    public static void removeStudentByNameFacultyAndYear(String name, String faculty, int year) {
        boolean removed = students.remove( new Student( name, faculty, year ) );
        if(!removed){
            System.out.println("No such student exist in the list");
        }
    }

    // Метод для поиска всех студентов определенного факультета и курса
    public static List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        List<Student> studentsFound = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals( faculty ) && student.getYear() == year) {
                studentsFound.add( student );
            }
        }
        return studentsFound;
    }

}

class Pair<String, Integer> {
    private String faculty;
    private Integer year;

    public Pair(String faculty, Integer year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getYear() {
        return year;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Pair<String, Integer> p = (Pair<String, Integer>) o;
        return p.getFaculty().equals( faculty ) && p.year.equals( year );
    }

    public int hashCode() {
        return Objects.hash( faculty, year );
    }

    @Override
    public java.lang.String toString() {
        return "Pair{" +
                "faculty=" + faculty +
                ", year=" + year +
                '}';
    }
}