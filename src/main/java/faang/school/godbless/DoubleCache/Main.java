package faang.school.godbless.DoubleCache;

import lombok.NonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private Map<Student, Map<Subject, Integer>> studentsAchievementsInSubjects = new HashMap<>();
    private Map<Subject, Set<Student>> subjectsWithStudents = new HashMap<>();
    
    public static void main(String[] args) {
        Main main = new Main();

        Subject math = new Subject(1, "Mathematics");
        Subject science = new Subject(2, "Science");
        Subject history = new Subject(3, "History");

        Student alice = new Student(1, "Alice");
        Student bob = new Student(2, "Bob");

        Map<Subject, Integer> aliceAchievements = new HashMap<>();
        aliceAchievements.put(math, 90);
        aliceAchievements.put(science, 85);

        Map<Subject, Integer> bobAchievements = new HashMap<>();
        bobAchievements.put(math, 75);
        bobAchievements.put(history, 80);

        main.addStudentWithHisAchievementsInSubjects(alice, aliceAchievements);
        main.addStudentWithHisAchievementsInSubjects(bob, bobAchievements);

        System.out.println("List of all students and their achievements:");
        main.listAllStudentsAndTheirAchievements();

        System.out.println("List of all subjects and students studying them:");
        main.listAllSubjectsAndStudents();

        main.deleteStudentWithHisAchievementsInSubjects(alice);

        System.out.println("List of all students and their achievements after removing Alice:");
        main.listAllStudentsAndTheirAchievements();

        System.out.println("List of all subjects and students studying them after removing Alice:");
        main.listAllSubjectsAndStudents();
    }
    public void addStudentWithHisAchievementsInSubjects(@NonNull Student student, @NonNull Map<Subject, Integer> achievementsInSubjects) {
        studentsAchievementsInSubjects.computeIfAbsent(student, key -> new HashMap<>()).putAll(achievementsInSubjects);
        for (Map.Entry<Subject, Integer> entry : achievementsInSubjects.entrySet()) {
            Subject subject = entry.getKey();
            subjectsWithStudents.computeIfAbsent(subject, key -> new HashSet<>()).add(student);
        }
    }


    public void deleteStudentWithHisAchievementsInSubjects(@NonNull Student student) {
        Map<Subject, Integer> achievementsInSubjects = studentsAchievementsInSubjects.get(student);
        studentsAchievementsInSubjects.remove(student);
        for (Map.Entry<Subject, Integer> entry : achievementsInSubjects.entrySet()) {
            Subject subject = entry.getKey();
            subjectsWithStudents.get(subject).remove(student);
        }
    }

    public void listAllStudentsAndTheirAchievements() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentsAchievementsInSubjects.entrySet()) {
            Student student = entry.getKey();
            System.out.println("Student: " + student.getName() + " (ID: " + student.getId() + ")");
            for (Map.Entry<Subject, Integer> achievements : entry.getValue().entrySet()) {
                Subject subject = achievements.getKey();
                Integer grade = achievements.getValue();
                System.out.println("\tSubject: " + subject.getName() + " (ID: " + subject.getId() + ") - Grade: " + grade);
            }
            System.out.println();
        }
    }

    public void listAllSubjectsAndStudents() {
        for (Map.Entry<Subject, Set<Student>> entry : subjectsWithStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("Subject: " + subject.getName() + " (ID: " + subject.getId() + ")");
            for (Student student : entry.getValue()) {
                System.out.println("\tStudent: " + student.getName() + " (ID: " + student.getId() + ")");
            }
            System.out.println();
        }
    }


}
