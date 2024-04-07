package faang.school.godbless.countingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Liza", "Math", 3));
        studentList.add(new Student("Maria", "Math", 3));
        studentList.add(new Student("Peter", "Design", 1));
        studentList.add(new Student("Dmitry", "Computer science", 4));
        studentList.add(new Student("Michael", "Computer science", 4));

        Student student1 = new Student("David", "Design", 1);
        Student student2 = new Student("Polina", "Math", 4);
        Student student3 = new Student("Kristina", "Math", 4);
        Student student4 = new Student("Vasya", "Design", 2);

        Map<String, List<Student>> studentMap = groupByFacultyAndYear(studentList);

        addNewStudentInMap(studentMap, student1);
        addNewStudentInMap(studentMap, student2);
        addNewStudentInMap(studentMap, student3);
        addNewStudentInMap(studentMap, student4);


        removeStudentFromMap(studentMap, "Kristina", "Math", 4);
        removeStudentFromMap(studentMap, "Masha", "Math", 3);

        for (Map.Entry<String, List<Student>> entry : studentMap.entrySet()) {
            System.out.println("Факультет, курс: " + entry.getKey() + ":");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }

        findAllStudentOnFacultyAndCourse(studentMap, "Math", 4);
    }

    private static String createPairOfFacultyAndYear(String faculty, int year) {
        return faculty + ", " + year;
    }

    private static Map<String, List<Student>> groupByFacultyAndYear(List<Student> studentList) {
        Map<String, List<Student>> mapFacultyAndYear = new HashMap<>();
        for (Student student : studentList) {
            String facultyAndYear = createPairOfFacultyAndYear(student.getFaculty(), student.getYear());
            if (!mapFacultyAndYear.containsKey(facultyAndYear)) {
                mapFacultyAndYear.put(facultyAndYear, new ArrayList<>());
            }
            mapFacultyAndYear.get(facultyAndYear).add(student);
        }
        return mapFacultyAndYear;
    }

    private static void addNewStudentInMap(Map<String, List<Student>> studentMap, Student newStudent) {
        String facultyAndYear = createPairOfFacultyAndYear(newStudent.getFaculty(), newStudent.getYear());
        if (studentMap.containsKey(facultyAndYear)) {
            studentMap.get(facultyAndYear).add(newStudent);
        } else {
            studentMap.put(facultyAndYear, new ArrayList<>());
            studentMap.get(facultyAndYear).add(newStudent);
        }
    }

    private static void removeStudentFromMap(Map<String, List<Student>> studentMap, String name, String faculty, int year) {
        String facultyAndYear = createPairOfFacultyAndYear(faculty, year);
        if (studentMap.containsKey(facultyAndYear)) {
            Iterator<Student> iterator = studentMap.get(facultyAndYear).iterator();
            boolean studentFound = false;
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (Objects.equals(student.getName(), name)) {
                    iterator.remove();
                    studentFound = true;
                }
            }
            if (!studentFound) {
                System.out.println("Такого студента нет.");
            }
        } else {
            System.out.println("Такого студента нет.");
        }
    }


    private static void findAllStudentOnFacultyAndCourse(Map<String, List<Student>> studentMap, String faculty, int year) {
        String neededFacultyAndYear = createPairOfFacultyAndYear(faculty, year);
        if (studentMap.containsKey(neededFacultyAndYear)) {
            List<String> namesOfNeededStudents = new ArrayList<>();
            for (Student student : studentMap.get(neededFacultyAndYear)) {
                String nameOfStudent = student.getName();
                namesOfNeededStudents.add(nameOfStudent);
            }
            System.out.println("На " + neededFacultyAndYear + " обучаются студенты " + namesOfNeededStudents);
        } else {
            System.out.println("На таком факультете и годе обучения нет ни одного студента.");
        }
    }
}