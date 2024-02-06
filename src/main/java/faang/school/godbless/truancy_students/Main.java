package faang.school.godbless.truancy_students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    private static final List<Student> studentList = new ArrayList<>();
    private static final Map<Student, Integer> mapStudent = new HashMap<>();

    public static void main(String[] args) {
        Student kirill = new Student("Kirill", "IT", 3);
        Student oleg = new Student("Oleg", "IT", 2);
        Student andrey = new Student("Andrey", "IT", 1);
        Student denis = new Student("Denis", "IT", 4);
        Student anton = new Student("Anton", "IT", 4);
        Student ilya = new Student("Ilya", "Sport", 2);

        add(kirill);
        add(oleg);
        add(andrey);
        add(denis);
        add(anton);
        info();
        remove(kirill.getName(), kirill.getFaculty(), kirill.getYear());
        info();
        System.out.println(infoFaculty("IT", 3));
        System.out.println(infoFaculty("IT", 4));
        System.out.println(infoFaculty("Sport", 2));
    }

    private static Map<Faculty, List<Student>> university(List<Student> students) {
        HashMap<Faculty, List<Student>> facultyMap = new HashMap<>();
        for (Student student : students) {
            Faculty facultyStudent = new Faculty(student.getFaculty(), student.getYear());
            if (!facultyMap.containsKey(facultyStudent)) {
                facultyMap.put(facultyStudent, new ArrayList<>());
            }
            facultyMap.get(facultyStudent).add(student);
        }
        return facultyMap;
    }

    private static void add(Student student) {
        mapStudent.put(student, mapStudent.size());
        studentList.add(student);
    }

    private static void remove(String name, String faculty, int year) {
        int index = mapStudent.get(new Student(name, faculty, year));
        studentList.remove(index);
    }

    private static void info(){
        System.out.println(university(studentList));
    }
    private static String infoFaculty(String faculty, int year){
        Faculty faculty_university = new Faculty(faculty, year);
        var hashmap_faculty = university(studentList);
        List<Student> stringListStudent = hashmap_faculty.get(faculty_university);
        return stringListStudent == null ? "Нету студентов этого факультета" : stringListStudent.toString();
    }
}