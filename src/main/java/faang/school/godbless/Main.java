package faang.school.godbless;

import java.util.*;

public class Main {
    static List<Student> listStudents = new ArrayList<>();

    public static void mainStart() {
        Scanner in = new Scanner(System.in);
        Student student1 = new Student("Ivan", "information technologies", 2);
        Student student2 = new Student("Petr", "information technologies", 2);
        Student student4 = new Student("Artem", "Biology", 2);
        Student student3 = new Student("Aleksandr", "information technologies", 1);

        addition(student1);
        addition(student2);
        addition(student3);
        addition(student4);

        removeStudent("Aleksandr", "information technologies", 1);


        Map<GroupInUniversity, List<Student>> groupStudents = createGroupStudent(listStudents);

        searchAllStudentInGroups("information technologies", 2);
        printAllGroupsStudent(groupStudents);

    }

    private static void addition(Student student) {
        listStudents.add(student);
    }

    private static void removeStudent(String name, String faculty, int year) {
        listStudents.remove(new Student(name, faculty, year));
    }

    private static Map<GroupInUniversity, List<Student>> createGroupStudent(List<Student> listStudents) {
        Map<GroupInUniversity, List<Student>> groups = new HashMap<>();

        listStudents.forEach((f) -> {
            GroupInUniversity newGroupStudents = new GroupInUniversity(f.getFaculty(), f.getYear());
            List<Student> updateListStudent = groups.get(newGroupStudents);
            if (updateListStudent != null) {
                updateListStudent.add(f);
                groups.put(newGroupStudents, updateListStudent);


            } else {
                List<Student> updateGroupListStudent = new ArrayList<>();
                updateGroupListStudent.add(f);
                groups.put(newGroupStudents, updateGroupListStudent);
            }
            ;
        });
        return groups;
    }

    private static List<Student> searchAllStudentInGroups(String faculty, int year) {
        List<Student> studentsOfTheRequestedGroup = new ArrayList<>();
        listStudents.forEach((s) -> {
            if (s.getFaculty() == faculty && s.getYear() == year) {
                studentsOfTheRequestedGroup.add(s);
            }
        });
        return studentsOfTheRequestedGroup;
    }

    private static void printAllGroupsStudent(Map<GroupInUniversity, List<Student>> groupStudent) {
        groupStudent.forEach((group, listStudent) -> {
            System.out.println("In a group with faculty " + group.getFaculty() + " and course number " +
                    +group.getYear() + " Matching list of students:");

        });
    }
}
