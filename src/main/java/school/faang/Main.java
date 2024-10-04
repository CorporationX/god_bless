package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    List<Student> listStudents;

    public Main() {
        listStudents = new ArrayList<>();
    }

    public HashMap<Key, List<Student>> listToHashMap(List<Student> list) {
        HashMap<Key, List<Student>> stMap = new HashMap<>();
        list.forEach(student ->
                stMap.computeIfAbsent(new Key(student.getFaculty(), student.getYear()),
                        st -> new ArrayList<>()).add(student));
        return stMap;
    }

    public Boolean addStudent(Student student) {
        return listStudents.add(student);
    }

    public Boolean removeStudent(String name, String faculty, Integer year) {
        Student removeStudent = new Student(name, faculty, year);
        return listStudents.remove(removeStudent);
    }

    public List<Student> findStudentsByCourseAndFaculty(String faculty, Integer year) {
        return listToHashMap(listStudents).get(new Key(faculty, year));
    }

    public void printStudentsByCourseAndFaculty() {
        listToHashMap(listStudents)
                .forEach((key, value) -> {
                    System.out.println("List of students for faculty: "
                            + key.getFaculty() + " and course: " + key.getYear());
                    value.forEach(System.out::println);
                });
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.listStudents.add(new Student("Alex", "MehMat", 2011));
        main.listStudents.add(new Student("Olya", "Literature", 1999));
        main.listStudents.add(new Student("Anna", "Literature", 1999));
        main.listStudents.add(new Student("Kirill", "MehMat", 1999));
        main.listStudents.add(new Student("Egor", "MehMat", 1999));
        main.listStudents.add(new Student("Anton", "MehMat", 2002));

        main.printStudentsByCourseAndFaculty();

        System.out.println(main.findStudentsByCourseAndFaculty("MehMat", 1999));

        if (main.addStudent(new Student("Egor", "Literature", 1999))) {
            System.out.println("Students added");
        }
        else {
            System.out.println("Students was not add");
        }
    }
}
