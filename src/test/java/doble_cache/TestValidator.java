package doble_cache;

import double_Cache.Student;
import double_Cache.Subject;
import double_Cache.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestValidator {

    private final Validator validator = new Validator();

    Student petr = new Student("Petr");
    Student kate = new Student("Kate");
    Student nina = new Student(null);
    Student oly = new Student(" ");
    Subject subject = new Subject("Math");
    Subject subject1 = new Subject("Eng");
    Subject subjectNull = new Subject(null);
    Map<Subject, List<Student>> subjectListMap = new HashMap<>();
    List<Student> studentList = new ArrayList<>();
    Map<Subject, Integer> subjectIntegerMap = new HashMap<>();
    Map<Student, Map<Subject, Integer>> studentMapMap = new HashMap<>();

    @Test
    public void testCheckGrade() {
        Integer grade1 = 1;
        Integer grade2 = 6;
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkGrade(grade1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkGrade(grade2));
    }

    @Test
    public void testCheckSaveMapMap() {
        addKeyValueMapSubject();
        Assertions.assertThrows(IllegalStateException.class, () -> validator.checkSaveMapMap(nina, subject, studentMapMap));
        Assertions.assertThrows(IllegalStateException.class, () -> validator.checkSaveMapMap(petr, subject1, studentMapMap));
    }

    @Test
    public void testCheckStudentIsBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkStudentIsBlank(nina));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkStudentIsBlank(oly));
    }

    @Test
    public void testCheckMapIsEmpty() {
        studentMapMap.clear();
        Assertions.assertThrows(IllegalStateException.class, () -> validator.checkMapIsEmpty(studentMapMap));
    }

    @Test
    public void testCheckRemoveMapStudents() {
        addKeyValueMapSubject();
        Assertions.assertThrows(IllegalStateException.class, () -> validator.checkRemoveMapStudents(petr, studentMapMap));
    }

    @Test
    public void testCheckAddMapSubject() {
        addKeyValue(nina);
        Assertions.assertThrows(IllegalStateException.class, () -> validator.checkAddMapSubject(subject, kate, subjectListMap));
    }

    @Test
    public void testCheckListStudentsIsEmpty() {
        studentList.clear();
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkListStudentsIsEmpty(studentList));
    }

    @Test
    public void testCheckSubjectNameIsBlank() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkSubjectNameIsBlank(subjectNull));
    }

    @Test
    public void testCheckSaveMapSubject() {
        addKeyValue(kate);
        int size = 5;
        Assertions.assertThrows(IllegalStateException.class, () -> validator.checkSaveMapSubject(subject, subjectListMap, size));
    }

    @Test
    public void testCheckMapSubjectIsEmpty() {
        subjectListMap.clear();
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkMapSubjectIsEmpty(subjectListMap));
    }

    @Test
    public void testCheckMapKeySubject() {
        addKeyValue(nina);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkMapKeySubject(subject1, subjectListMap));
    }

    private void addKeyValueMapSubject() {
        subjectIntegerMap.put(subject, 5);
        studentMapMap.put(petr, subjectIntegerMap);
    }

    private void addKeyValue(Student nina) {
        studentList.add(petr);
        studentList.add(nina);
        subjectListMap.put(subject, studentList);
    }
}