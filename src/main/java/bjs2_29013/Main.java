package bjs2_29013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Map<Student, Integer> studentIndices = new HashMap<>();

        addStudent(students, studentIndices, new Student("Jack", "Computer Science", 3));
        addStudent(students, studentIndices, new Student("Jane", "Economy", 2));
        addStudent(students, studentIndices, new Student("Jess", "Computer Science", 3));
        addStudent(students, studentIndices, new Student("Jacob", "Economy", 2));
        addStudent(students, studentIndices, new Student("Jonathon", "Psychology", 4));

        removeStudent(students, studentIndices, new Student("Jack", "Computer Science", 3));

        Map<AcademicProgram, List<Student>> groupedStudents = groupStudents(students);

        System.out.println(searchAcademicProgramStudents(groupedStudents,
                new AcademicProgram("Economy", 2)));
        System.out.println();

        printAllGroupedStudents(groupedStudents);
    }

    public static Map<AcademicProgram, List<Student>> groupStudents(List<Student> students) {
        Map<AcademicProgram, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : students) {
            groupedStudents.computeIfAbsent(new AcademicProgram(student.getFaculty(), student.getYear()),
                    k -> new ArrayList<Student>()).add(student);
        }

        return groupedStudents;
    }

    public static void addStudent(List<Student> students,
                                  Map<Student, Integer> studentIndices,
                                  Student student) {
        studentIndices.put(student, students.size());
        students.add(student);
    }

    public static void removeStudent(List<Student> students,
                                     Map<Student, Integer> studentIndices,
                                     Student student) {
        int studentIndex = studentIndices.get(student);
        int lastStudentIndex = students.size() - 1;

        Collections.swap(students, studentIndex, lastStudentIndex);
        students.remove(lastStudentIndex);
        studentIndices.remove(student);

        if (!students.isEmpty() && studentIndex != lastStudentIndex) {
            studentIndices.put(students.get(studentIndex), studentIndex);
        }
    }

    public static List<Student> searchAcademicProgramStudents(Map<AcademicProgram, List<Student>> groupedStudents,
                                                              AcademicProgram academicProgram) {
        return groupedStudents.get(academicProgram);
    }

    public static void printAllGroupedStudents(Map<AcademicProgram, List<Student>> groupedStudents) {
        for (var entry : groupedStudents.entrySet()) {
            System.out.printf("Academic program: %s -> Students: %s\n", entry.getKey(), entry.getValue());
        }
    }
}

