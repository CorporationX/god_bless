package faang.school.godbless.counting_absences;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Student {
    private String name;
    private String faculty;
    private int year;
    private FacultyAndYearPair facultyAndYearPair;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
        this.facultyAndYearPair = new FacultyAndYearPair(faculty, year);
    }

    public static void addStudentToMap(Map<FacultyAndYearPair, List<Student>> studentMap, Student student){
        studentMap.computeIfAbsent(student.facultyAndYearPair, facultyAndYearPairAsKey -> new ArrayList<>());
        studentMap.get(student.facultyAndYearPair).add(student);
    }

    public static void deleteStudentFromMap(Map<FacultyAndYearPair, List<Student>> studentMap,
                                            String name, String faculty, int year){
        Student studentToDelete = new Student(name, faculty, year);

        studentMap.get(studentToDelete.getFacultyAndYearPair()).remove(studentToDelete);
        // Если после удаления студента из факультета -> факультет пустой, то удаляю факультет из map'ы
        if(studentMap.get(studentToDelete.getFacultyAndYearPair()).isEmpty()){
            studentMap.remove(studentToDelete.getFacultyAndYearPair());
        }
    }

    public static List<Student> searchByFaculty(Map<FacultyAndYearPair, List<Student>> studentMap,
                                                String faculty, int year){
        FacultyAndYearPair facultyAndYearPairToReturn = new FacultyAndYearPair(faculty, year);
        return studentMap.get(facultyAndYearPairToReturn);
    }

    public static void showStudentsGropedByFacultyAndYear(Map<FacultyAndYearPair, List<Student>> studentMap){
        for(Map.Entry<FacultyAndYearPair, List<Student>> gropedStudents : studentMap.entrySet()){
            System.out.println("Students in " + gropedStudents.getKey());
            for(Student student :gropedStudents.getValue()){
                System.out.println(student);
            }
            System.out.println("End of List");
        }
    }

    public static Map<FacultyAndYearPair, List<Student>> groupStudentsByFacultyAndYear(List<Student> students){
        Map<FacultyAndYearPair, List<Student>> result = new HashMap<>();

        for(Student student : students){
            addStudentToMap(result, student);
        }

        return result;
    }
}
