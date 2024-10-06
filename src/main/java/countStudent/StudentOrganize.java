package countStudent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentOrganize {

    private final Map<String, Map<Integer, List<Student>>> facultatyMap = new HashMap<>();

    public Map<String, Map<Integer, List<Student>>> organizeStudent(List<Student> students) {
        for (Student student : students) {
            addStudentToFacultyYear(student);
        }
        return facultatyMap;
    }

    public List<Student> addStudent(Student student) {
        int year = student.getYear();
        String faculty = student.getFaculty();

        addStudentToFacultyYear(student);

        return facultatyMap.get(faculty).get(year);
    }

    public void addStudentToFacultyYear(Student student) {
        int year = student.getYear();
        String faculty = student.getFaculty();

        Map<Integer, List<Student>> courseMap = facultatyMap.computeIfAbsent(faculty, key -> new HashMap<>());
        List<Student> studentList = courseMap.computeIfAbsent(year, key -> new ArrayList<>());
        studentList.add(student);
    }

    public void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);

        if (facultatyMap.containsKey(faculty) && facultatyMap.get(faculty).containsKey(year)) {
            List<Student> studentList = facultatyMap.get(faculty).get(year);
            studentList.remove(student);
        } else {
            throw new IllegalArgumentException("Невозможно удалить. Студента с таким именем и факультетом не существует");
        }
    }

    public List<Student> findAllStudent(String faculty, int year) {
        return facultatyMap.get(faculty).get(year);
    }

    public void printMap() {
        for (Map.Entry<String, Map<Integer, List<Student>>> foreignEntry : facultatyMap.entrySet()) {
            String faculty = foreignEntry.getKey();
            for (Map.Entry<Integer, List<Student>> interiorEntry : foreignEntry.getValue().entrySet()) {
                int year = interiorEntry.getKey();
                List<Student> studentList = interiorEntry.getValue();

                System.out.println("Факультет: " + faculty + "\tКурс : " + year + "\tСписок студентов: " + studentList);
            }
        }
    }
}
