package faang.school.godbless.countingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        addNewStudentInList(studentList, student1);
        addNewStudentInList(studentList, student2);
        addNewStudentInList(studentList, student3);

        removeStudentFromList(studentList, "Kristina", "Math", 4);
        removeStudentFromList(studentList, "Masha", "Math", 3);

        findAllStudentOnFacultyAndCourse(studentList, "Math", 3);

        Map<String, List<Student>> studentMap = listOfStudentsOnFacultyAndCourse(studentList);
        for (Map.Entry<String, List<Student>> entry : studentMap.entrySet()) {
            System.out.println("Факультет, курс: " + entry.getKey() + ":");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }

    public static Map<String, List<Student>> listOfStudentsOnFacultyAndCourse(List<Student> studentList) {
        Map<String, List<Student>> mapFacultyAndYear = new HashMap<>();
        for (Student student : studentList) {
            String facultyAndYear = student.getFaculty() + ", " + student.getYear();
            if (!mapFacultyAndYear.containsKey(facultyAndYear)) {
                mapFacultyAndYear.put(facultyAndYear, new ArrayList<>());
            }
            mapFacultyAndYear.get(facultyAndYear).add(student);
        }
        return mapFacultyAndYear;
    }

    public static void addNewStudentInList(List<Student> studentList, Student newStudent) {
        studentList.add(newStudent);
    }

    public static void removeStudentFromList(List<Student> studentList, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (studentList.contains(student)) {
            studentList.remove(student);
        } else {
            System.out.println("Такого студента нет.");
        }
    }

    public static void findAllStudentOnFacultyAndCourse(List<Student> studentList, String faculty, int year) {
        Map<String, List<Student>> mapOfFacultyYearAndStudents = listOfStudentsOnFacultyAndCourse(studentList);
        String neededFacultyAndYear = faculty + ", " + year;
        if (mapOfFacultyYearAndStudents.containsKey(neededFacultyAndYear)) {
            List<String> namesOfNeededStudents = new ArrayList<>();
            for (Student student : mapOfFacultyYearAndStudents.get(neededFacultyAndYear)) {
                String nameOfStudent = student.getName();
                namesOfNeededStudents.add(nameOfStudent);
            }
            System.out.println("На " + neededFacultyAndYear + " обучаются студенты "
                    + namesOfNeededStudents);
        } else {
            System.out.println("На таком факультете и годе обучения нет ни одного студента.");
        }
    }
}