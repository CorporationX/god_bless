package faang.school.godbless;

import java.util.*;

public class Main {
    static List<Student> listStudents = new ArrayList<>();

    public void mainStart() {
        Scanner in = new Scanner(System.in);
        Student student1 = new Student("Ivan", "information technologies", 2);
        Student student2 = new Student("Petr", "information technologies", 4);
        Student student4 = new Student("Artem", "Biology", 2);
        Student student3 = new Student("Aleksandr", "information technologies", 1);

        addition(student1);

        Map<GroupInUniversity, List<Student>> groupStudents = createGroupStudent(listStudents);

    }

    private static void addition(Student student) {
        listStudents.add(student);
    }

    private static void removeStudent(String name, String faculty, int year) {
        listStudents.remove(new Student(name, faculty, year));
    }

    private Map<GroupInUniversity, List<Student>> createGroupStudent(List<Student> listStudents) {
        Map<GroupInUniversity, List<Student>> groups = new HashMap<>();

        listStudents.forEach((f) -> {
            GroupInUniversity newGroupStudents = new GroupInUniversity(f.getFaculty(), f.getYear());
            if (groups.isEmpty()) {

                List<Student> listOfGroupStudents = List.of(f);
                groups.put(newGroupStudents, listOfGroupStudents);
            } else {

                List<Student> updateListStudent = groups.get(newGroupStudents);
                updateListStudent.add(f);
                groups.put(newGroupStudents, updateListStudent);

            }
            ;
        });
        return groups;
    }

    private List<Student> searchAllStudentInGroups(String faculty, int year) {
        List<Student> studentsOfTheRequestedGroup = new ArrayList<>();
        listStudents.forEach((s) -> {
            if (s.getFaculty() == faculty && s.getYear() == year) {
                studentsOfTheRequestedGroup.add(s);
            }
        });
        return studentsOfTheRequestedGroup;
    }

    private void printAllGroupsStudent(Map<GroupInUniversity, List<Student>> groupStudent) {
        groupStudent.forEach((group,listStudent)->{
            System.out.println("In a group with faculty "+ group.getFaculty()+ " and course number"+
                    + group.getYear()+ " Matching list of students:");

        });
    }
}
