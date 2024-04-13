package faang.school.godbless.Task_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Vadim", "IT", 1));
        studentList.add(new Student("Jessica", "Philosophy", 2));
        studentList.add(new Student("John", "Economics", 3));
        studentList.add(new Student("Mike", "Economics", 4));

        System.out.println(studentList);

        addNewStudent(studentList, new Student("Pamella", "IT", 1));

        System.out.println(studentList);

        removeStudentByHisName(studentList, "John", "Economics", 3);

        System.out.println(studentList);

        System.out.println(studentsMethod(studentList));

        searchAllStudentsOfParticularFacultyAndCourse(studentList, "Economics", 4);

    }

    static Map<Subject, List<Student>> studentsMethod(List<Student> studentsList) {

        Map<Subject, List<Student>> studentsMap = new HashMap<>();

        List<Student> newStudents = null;

        for (int i = 0; i < studentsList.size(); i++) {

            Subject subject = new Subject(studentsList.get(i).getYear(), studentsList.get(i).getFaculty());

            if (!studentsMap.containsKey(subject)) {

                newStudents = new ArrayList<>();

                for (Student student : studentsList) {

                    if (subject.getFaculty().equals(student.getFaculty()) && subject.getYear().equals(student.getYear())) {
                        newStudents.add(student);
                    }
                }
            }
            studentsMap.put(subject, newStudents);
        }
        return studentsMap;
    }

    static void addNewStudent(List<Student> students, Student student) {
        if (student != null) {
            students.add(student);
        }
    }


    static void removeStudentByHisName(List<Student> students, String name, String faculty, Integer year) {
        students.remove(new Student(name, faculty, year));
    }

    static void searchAllStudentsOfParticularFacultyAndCourse(List<Student> students, String faculty, Integer year) {

        Map<Subject, List<Student>> allStudents = studentsMethod(students);
        Subject yearAndFaculty = new Subject(year, faculty);

        if (allStudents.containsKey(yearAndFaculty)) {
            System.out.println(allStudents.get(yearAndFaculty));
        } else {
            System.out.println("There are no students from such faculty and year");
        }
    }
}
