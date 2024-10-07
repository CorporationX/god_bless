package school.faang;

import school.faang.fifthTask.Student;
import school.faang.fifthTask.StudentsMapManager;
import school.faang.fifthTask.Subject;
import school.faang.fifthTask.SubjectWithGrade;
import school.faang.firsttask.User;
import school.faang.forthTask.SearchEngine;
import school.faang.forthTask.WebPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        usersGrouping();
        googleSearchEngine();
        doubleCache();
    }

    public static void doubleCache() {
        StudentsMapManager manager = new StudentsMapManager();

        Student student1 = new Student(1, "Ivan");
        Student student2 = new Student(2, "Alex");
        Student student3 = new Student(3, "Andrei");

        Subject subject1 = new Subject(1, "Subject1");
        Subject subject2 = new Subject(2, "Subject2");
        Subject subject3 = new Subject(3, "Subject3");
        Subject subjectNew = new Subject(4, "subjectNew");

        // 1 part
        manager.addNewStudentAndSubjects(
                student1,
                List.of(
                        new SubjectWithGrade(subject1, 5),
                        new SubjectWithGrade(subject2, 9)
                )
        );
        manager.addSubjectForStudent(student1, subject3, 6);
        manager.addSubjectForStudent(student1, subject3, 7);
        manager.addSubjectForStudent(student2, subject1, 7);

        manager.printAllStudentsAndGrades();
        manager.printAllSubjectsAndStudents();
        System.out.println("=======================================");

        // 2 part
        manager.addNewSubjectForStudents(subjectNew, Arrays.asList(student1, student2));
        manager.addNewSubjectForStudents(subject2, Collections.singletonList(student3));
        manager.addStudentToSubject(subjectNew, student3);

        manager.printAllStudentsAndGrades();
        manager.printAllSubjectsAndStudents();

        System.out.println("=======================================");
        manager.removeStudent(student1);
        manager.printAllStudentsAndGrades();
    }

    public static void usersGrouping() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 30, "Company 1", "Address 1"));
        users.add(new User("Alex", 25, "Company 2", "Address 2"));
        users.add(new User("Stepan", 30, "Company 3", "Address 3"));

        Map<Integer, List<User>> grouped = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(" - " + user.getName());
            }
        }
    }

    public static void googleSearchEngine() {
        SearchEngine searchEngine = new SearchEngine();

        WebPage page1 = new WebPage("http://example1.com", "Example Page", "This is an example content with some example words.");
        WebPage page2 = new WebPage("http://example2.org", "Another Example", "Another example content with different words.");
        WebPage page3 = new WebPage("http://example3.org", "Third Example", "Third variant content with different words.");

        searchEngine.indexWebPage(page1);
        searchEngine.indexWebPage(page2);
        searchEngine.indexWebPage(page3);

        System.out.println("Set of indexes: " + searchEngine.getIndex().keySet());

        System.out.println("Search results for 'example':" + searchEngine.search("example").toString());

        for (WebPage page : searchEngine.search("example")) {
            System.out.println(page);
        }

        searchEngine.removeWebPage("http://example1.com");

        System.out.println("\nSearch results for 'example' after removal:");
        for (WebPage page : searchEngine.search("example")) {
            System.out.println(page);
        }
    }
}
