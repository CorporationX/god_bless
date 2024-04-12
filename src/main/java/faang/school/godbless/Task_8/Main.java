package faang.school.godbless.Task_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Vadim", "It", 1));
        studentList.add(new Student("Jessica", "Philosophy", 2));
        studentList.add(new Student("John", "Economics", 3));
        studentList.add(new Student("Mike", "Economics", 3));

        addNewStudent(studentList, new Student("Pamella", "It", 4));

        removeStudentByHisName(studentList, "John", "Economics", 3);

        System.out.println(studentsMethod(studentList));

        System.out.println(searchAllStudentsOfParticularFacultyAndCourse(studentList, "Economics", 3));

    }

    static Map<Map<String, Integer>, List<Student>> studentsMethod(List<Student> studentsList) {

        Map<Map<String, Integer>, List<Student>> studentsMap = new HashMap<>();

        Map<String, Integer> facultyAndYear;

        List<Student> newStudents = null;

        for (int i = 0; i < studentsList.size(); i++) {

            String faculty = studentsList.get(i).getFaculty();
            Integer year = studentsList.get(i).getYear();

            facultyAndYear = new HashMap<>();
            facultyAndYear.put(faculty, year);

            if (!studentsMap.containsKey(facultyAndYear)) {

                newStudents = new ArrayList<>();

                for (Student student : studentsList) {

                    if (faculty.equals(student.getFaculty()) && year.equals(student.getYear())) {
                        newStudents.add(student);
                    }
                }
            }
            studentsMap.put(facultyAndYear, newStudents);
        }
        return studentsMap;
    }

    static void addNewStudent(List<Student> students, Student student) {
        students.add(student);
    }

    static void removeStudentByHisName(List<Student> students, String name, String faculty, Integer year) {
        students.remove(new Student(name, faculty, year));
    }

    static List<Student> searchAllStudentsOfParticularFacultyAndCourse(List<Student> students, String faculty, Integer year) {

        Map<Map<String, Integer>, List<Student>> allStudents = studentsMethod(students);

        Map<String, Integer> studentsByFacultyAndYear = new HashMap<>();

        studentsByFacultyAndYear.put(faculty, year);

        return allStudents.get(studentsByFacultyAndYear);
    }

}
