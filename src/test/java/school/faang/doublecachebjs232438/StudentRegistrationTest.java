package school.faang.doublecachebjs232438;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class StudentRegistrationTest {

    StudentRegistration studentRegistrationEmpty;
    StudentRegistration studentRegistrationKseniya;
    StudentRegistration studentRegistration;
    List<Student> studentsLongList;
    List<Student> studentsShortList;
    List<Subject> subjectsList;

    @BeforeEach
    void init() {

        studentRegistrationEmpty = new StudentRegistration();
        studentRegistrationKseniya = new StudentRegistration();
        studentRegistration = new StudentRegistration();

        studentsLongList = List.of(
                new Student(10, "Alex"),
                new Student(11, "Nick"),
                new Student(12, "Pete"),
                new Student(14, "Kseniya"),
                new Student(15, "Jeni")
        );

        studentsShortList = List.of(
                new Student(10, "Alex"),
                new Student(11, "Nick"),
                new Student(12, "Pete")
        );

        subjectsList = List.of(
                new Subject(1, "Math"),
                new Subject(2, "Music"),
                new Subject(3, "History")
        );

        studentRegistration.addSubjectWithStudents(subjectsList.get(0), studentsLongList);

        studentRegistrationKseniya.addSubjectWithStudents(subjectsList.get(1), studentsLongList);

        var subjects = Map.of(
                subjectsList.get(1), 4
        );
        studentRegistrationKseniya.addStudent(studentsLongList.get(3), subjects);
    }

    @Test
    void addStudentWithoutSubjectAdded() {

        var jeni = studentsLongList.get(4);
        var math = subjectsList.get(0);
        var music = subjectsList.get(1);
        var history = subjectsList.get(2);

        var subjects = Map.of(
                math, 4,
                music, 3,
                history, 5
        );

        studentRegistration.addStudent(jeni, subjects);
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(subjects, studentRegistration.getStudentsMap().get(jeni)),
                () -> Assertions.assertTrue(studentRegistration.getSubjectsMap().get(math).contains(jeni)),
                () -> Assertions.assertNull(studentRegistration.getSubjectsMap().get(music)),
                () -> Assertions.assertNull(studentRegistration.getSubjectsMap().get(history))
        );
        Assertions.assertNotEquals(subjects, studentRegistration.getStudentsMap().get(jeni));
    }

    @Test
    void addStudentWithSubjectAdded() {

        var jeni = studentsLongList.get(4);
        var math = subjectsList.get(0);
        var music = subjectsList.get(1);
        var history = subjectsList.get(2);

        var subjects = Map.of(
                math, 4,
                music, 3,
                history, 5
        );

        studentRegistration.addSubjectWithStudents(music, new ArrayList<>());
        studentRegistration.addSubjectWithStudents(history, new ArrayList<>());

        studentRegistration.addStudent(jeni, subjects);

        Assertions.assertAll(
                () -> Assertions.assertEquals(subjects, studentRegistration.getStudentsMap().get(jeni)),
                () -> Assertions.assertTrue(studentRegistration.getSubjectsMap().get(math).contains(jeni)),
                () -> Assertions.assertNotNull(studentRegistration.getSubjectsMap().get(music)),
                () -> Assertions.assertNotNull(studentRegistration.getSubjectsMap().get(history)),
                () -> Assertions.assertTrue(studentRegistration.getSubjectsMap().get(music).contains(jeni)),
                () -> Assertions.assertTrue(studentRegistration.getSubjectsMap().get(history).contains(jeni))
        );
    }

    @Test
    void addSubjectForExistStudentWithoutSubjectAdded() {

        var jeni = studentsLongList.get(4);
        var history = subjectsList.get(2);
        var rating = 5;
        studentRegistration.addSubjectForExistStudent(jeni, history, rating);
        Assertions.assertAll(
                () -> Assertions.assertNull(studentRegistration.getStudentsMap().get(jeni)),
                () -> Assertions.assertNull(studentRegistration.getSubjectsMap().get(history))
        );
    }

    @Test
    void addSubjectForExistStudentWithSubjectAdded() {

        var alex = studentsLongList.get(0);
        var math = subjectsList.get(2);
        var history = subjectsList.get(2);
        var rating = 5;

        var subjects = Map.of(
                math, 5
        );

        studentRegistration.addSubjectWithStudents(history, new ArrayList<>());
        studentRegistration.addStudent(alex, subjects);
        studentRegistration.addSubjectForExistStudent(alex, history, rating);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(studentRegistration.getSubjectsMap().get(history)),
                () -> Assertions.assertTrue(studentRegistration.getSubjectsMap().get(history).contains(alex))
        );
    }

    @Test
    void removeStudent() {

        var kseniya = studentsLongList.get(3);
        studentRegistrationKseniya.removeStudent(kseniya);
        Assertions.assertNull(studentRegistrationKseniya.getStudentsMap().get(kseniya));
    }

    @Test
    void addSubjectWithStudents() {

        var math = subjectsList.get(0);
        studentRegistrationEmpty.addSubjectWithStudents(math, studentsShortList);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, studentRegistrationEmpty.getSubjectsMap().size()),
                () -> Assertions.assertEquals(3, studentRegistrationEmpty.getSubjectsMap().get(math).size()),
                () -> Assertions.assertEquals(studentsShortList.get(0), studentRegistrationEmpty.getSubjectsMap().get(math).get(0)),
                () -> Assertions.assertEquals(studentsShortList.get(1), studentRegistrationEmpty.getSubjectsMap().get(math).get(1)),
                () -> Assertions.assertEquals(studentsShortList.get(2), studentRegistrationEmpty.getSubjectsMap().get(math).get(2))
        );
    }

    @Test
    void pushStudentsToSubjects() {

        var math = subjectsList.get(0);
        studentRegistration.pushStudentsToSubjects(studentsLongList.get(3), math);
        Assertions.assertTrue(studentRegistration.getSubjectsMap().get(math).contains(studentsLongList.get(3)));
    }

    @Test
    void extractStudentsFromSubjectsNotDeleted() {

        var kseniya = studentsLongList.get(3);
        var music = subjectsList.get(1);

        studentRegistrationKseniya.extractStudentsFromSubjects(kseniya, music);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(studentRegistrationKseniya.getStudentsMap().get(kseniya)),
                () -> Assertions.assertNotNull(studentRegistrationKseniya.getSubjectsMap().get(music))
        );
    }

    @Test
    void extractStudentsFromSubjectsDeleted() {

        var kseniya = studentsLongList.get(3);
        var music = subjectsList.get(1);

        studentRegistrationKseniya.removeStudent(kseniya);
        studentRegistrationKseniya.extractStudentsFromSubjects(kseniya, music);
        Assertions.assertAll(
                () -> Assertions.assertNull(studentRegistrationKseniya.getStudentsMap().get(kseniya)),
                () -> Assertions.assertFalse(studentRegistrationKseniya.getSubjectsMap().get(music).contains(kseniya))
        );
    }
}