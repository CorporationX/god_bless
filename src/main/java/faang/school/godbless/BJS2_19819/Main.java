package faang.school.godbless.BJS2_19819;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<User, List<Query>> userQueries = new HashMap<>();
//        userQueries.put(new User("John Doe", Arrays.asList("asdfasdf","asdfg34","sdf92"));
        System.out.println(LocalDateTime.now());
        new ArrayList<>(){{add(new Query(1,"content", LocalDateTime.now()));
        add(new Query(2,"content", LocalDateTime.now()));
        add(new Query(3,"content", LocalDateTime.now()));}};
    }

    public static void addUserQueries(User user, List<Query> queries) {

    }

    public static void addQueryCurrUser(User user, Query query) {

    }

    public static void removeUser(User user) {

    }

    public static void printAllUsers() {

    }

//    public static void addNewStudentAndSubjects(Student student, Map<Subject, Integer> subjectsAndGrades) {
//        studentsAndGrades.computeIfAbsent(student, k -> subjectsAndGrades);
//        for (Subject subject : subjectsAndGrades.keySet()) {
//            subjectsAndStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
//        }
//    }

}
