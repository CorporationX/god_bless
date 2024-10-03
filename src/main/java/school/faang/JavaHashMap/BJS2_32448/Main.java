package school.faang.JavaHashMap.BJS2_32448;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> students = new ArrayList<>();
    static Map<String, List<Student>> groupedStudents;

    public static void main(String[] args) {
        students.add(new Student("Ivan", "Факультет компьютерных наук", 1));
        students.add(new Student("Мария", "Факультет инженерии", 2));
        students.add(new Student("Алексей", "Факультет экономики", 3));
        students.add(new Student("Светлана", "Факультет гуманитарных наук", 1));
        students.add(new Student("Дмитрий", "Факультет компьютерных наук", 2));
        students.add(new Student("Елена", "Факультет инженерии", 3));
        students.add(new Student("Анна", "Факультет экономики", 1));
        students.add(new Student("Николай", "Факультет гуманитарных наук", 2));
        students.add(new Student("Ольга", "Факультет компьютерных наук", 1));
        students.add(new Student("Сергей", "Факультет инженерии", 3));
        students.add(new Student("Кирилл", "Факультет экономики", 2));
        students.add(new Student("Татьяна", "Факультет гуманитарных наук", 1));
        students.add(new Student("Анастасия", "Факультет компьютерных наук", 1));
        students.add(new Student("Павел", "Факультет инженерии", 2));
        students.add(new Student("Евгений", "Факультет экономики", 3));

        addStudent(new Student("Dimoooooon", "Фильмография", 1));
        addStudent(new Student("Saneeeeeek", "Фильмография", 1));

        groupedStudents = groupingByFacultyAndCourse(students);
        allSpisokStudents();

        removeStudent(new Student("Dimoooooon", "Фильмография", 1));
        removeStudent(new Student("Saneeeeeek", "Фильмография", 1));

        allSpisokStudents();

        searchStudents("Факультет инженерии",3);
        searchStudents("Факультет инженерии",2);

    }

    public static Map<String, List<Student>> groupingByFacultyAndCourse(List<Student> students) {
        Map<String, List<Student>> groupingStudents = new HashMap<>();
        for(Student student : students){
            String key = student.getFaculty() + " - " + student.getYear() + " курс ";
            groupingStudents.putIfAbsent(key, new ArrayList<>());
            groupingStudents.get(key).add(student);
        }
        return groupingStudents;
    }

    public static void addStudent(Student student){
        students.add(student);
    }

    public static void removeStudent(Student student){
        students.remove(student);
    }

    public static void searchStudents(String faculty, int course){
        for(Student student : students){
            if(student.getFaculty().equals(faculty) && student.getYear() == course){
                System.out.println(" Факультет " + student.getFaculty() +
                                   "\n Курс " + student.getYear() +
                                   "\n Студент " + student.getName());
            }
        }
    }

    public static void allSpisokStudents(){
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

