import hashmap.group.Id;
import hashmap.group.Main;
import hashmap.group.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {
    private List<Student> studentsList;
    private Map<Id, List<Student>> studentsMap;
    private Map<Student, Integer> studentsListIndex;

    @BeforeEach
    public void setUp() {
        studentsList = new ArrayList<>();
        studentsList.add(new Student("Vitya", "CS", 1));
        studentsList.add(new Student("Jana", "CS", 1));
        studentsList.add(new Student("Kolya", "Fizmat", 2));
        studentsList.add(new Student("Anya", "CS", 2));
        studentsListIndex = new HashMap<>();
        Main.fillIndex(studentsList, studentsListIndex);
        studentsMap = Main.fillMap(studentsList);
    }

    @Test
    @DisplayName("Test fillIndex method with valid list")
    void testHashMap_fillIndex() {
        studentsListIndex = new HashMap<>();

        Main.fillIndex(studentsList, studentsListIndex);

        assertEquals(studentsList.size(), studentsListIndex.size());
    }

    @Test
    @DisplayName("Test fillIndex method with empty list")
    void testHashMap_fillIndexWithEmptyList() {
        studentsListIndex = new HashMap<>();

        Main.fillIndex(new ArrayList<>(), studentsListIndex);

        assertTrue(studentsListIndex.isEmpty());
    }

    @Test
    @DisplayName("Test fillIndex method with null arguments")
    void testHashMap_fillIndexWithNullArguments() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> Main.fillIndex(null, studentsListIndex)),
                () -> assertThrows(NullPointerException.class, () -> Main.fillIndex(studentsList, null))
        );
    }

    @Test
    @DisplayName("Test fillMap method with valid list of students")
    void testHashMap_fillMap() {
        Map<Id, List<Student>> result = Main.fillMap(studentsList);
        Id id1 = new Id("CS", 1);
        Id id2 = new Id("Fizmat", 2);
        Id id3 = new Id("CS", 2);
        assertAll(
                () -> assertEquals(3, result.size()),
                () -> assertTrue(result.containsKey(id1)),
                () -> assertTrue(result.containsKey(id2)),
                () -> assertTrue(result.containsKey(id3)),
                () -> assertEquals(2, result.get(id1).size()),
                () -> assertEquals(1, result.get(id2).size()),
                () -> assertEquals(1, result.get(id3).size())
        );
    }

    @Test
    @DisplayName("Test fillMap method with empty list of students")
    void testHashMap_fillMapWithEmptyList() {
        Map<Id, List<Student>> result = Main.fillMap(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test fillMap method with null list of students")
    void testHashMap_fillMapWithNullList() {
        assertThrows(NullPointerException.class, () -> Main.fillMap(null));
    }

    @Test
    @DisplayName("Test addStudent method with valid arguments")
    void testHashMap_addStudent() {
        Student testStudent = new Student("Test", "Test", 1);
        Id id = new Id(testStudent.getFaculty(), testStudent.getYear());

        Main.addStudent(studentsList, studentsMap, studentsListIndex, testStudent);

        assertAll(
                () -> assertTrue(studentsList.contains(testStudent)),
                () -> assertTrue(studentsMap.get(id).contains(testStudent)),
                () -> assertTrue(studentsListIndex.containsKey(testStudent))
        );
    }

    @Test
    @DisplayName("Test addStudent method with already added Student")
    void testHashMap_addAlreadyAddedStudent() {
        Student testStudent = new Student("Vitya", "CS", 1);
        Id id = new Id(testStudent.getFaculty(), testStudent.getYear());
        int expectedListSize = studentsList.size();
        int expectedMapValueSize = studentsMap.get(id).size();
        int expectedIndexSize = studentsListIndex.size();

        Main.addStudent(studentsList, studentsMap, studentsListIndex, testStudent);

        assertAll(
                () -> assertEquals(expectedListSize, studentsList.size()),
                () -> assertEquals(expectedMapValueSize, studentsMap.get(id).size()),
                () -> assertEquals(expectedIndexSize, studentsListIndex.size())
        );
    }

    @Test
    @DisplayName("Test addStudent method with null arguments")
    void testHashMap_addStudentWithNullArguments() {
        Student testStudent = new Student("Test", "Test", 1);

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> Main.addStudent(
                        null, studentsMap, studentsListIndex, testStudent)),
                () -> assertThrows(NullPointerException.class, () -> Main.addStudent(
                        studentsList, null, studentsListIndex, testStudent)),
                () -> assertThrows(NullPointerException.class, () -> Main.addStudent(
                        studentsList, studentsMap, null, testStudent)),
                () -> assertThrows(NullPointerException.class, () -> Main.addStudent(
                        studentsList, studentsMap, studentsListIndex, null))
        );
    }

    @Test
    @DisplayName("Test removeStudent method with valid arguments")
    void testHashMap_removeStudent() {
        Student testStudent = new Student("Vitya", "CS", 1);
        Id id = new Id(testStudent.getFaculty(), testStudent.getYear());

        Main.removeStudent(
                studentsList, studentsMap, studentsListIndex,
                testStudent.getName(), testStudent.getFaculty(), testStudent.getYear()
        );

        assertAll(
                () -> assertFalse(studentsList.contains(testStudent)),
                () -> assertFalse(studentsMap.get(id).contains(testStudent)),
                () -> assertFalse(studentsListIndex.containsKey(testStudent))
        );
    }

    @Test
    @DisplayName("Test removeStudent method with non existing student")
    void testHashMap_removeNotExistingStudent() {
        Student testStudent = new Student("test", "test", 1);
        Id id = new Id(testStudent.getFaculty(), testStudent.getYear());
        int expectedListSize = studentsList.size();
        int expectedIndexSize = studentsListIndex.size();
        int expectedValueSize = -1;
        if (studentsMap.get(id) != null) {
            expectedValueSize = studentsMap.get(id).size();
        }

        Main.removeStudent(
                studentsList, studentsMap, studentsListIndex,
                testStudent.getName(), testStudent.getFaculty(), testStudent.getYear()
        );

        assertAll(
                () -> assertEquals(expectedListSize, studentsList.size()),
                () -> assertEquals(expectedIndexSize, studentsListIndex.size())
        );
        if (studentsMap.get(id) != null) {
            assertEquals(expectedValueSize, studentsMap.get(id).size());
        }
    }

    @Test
    @DisplayName("Test removeStudent method with null arguments")
    void testHashMap_removeStudentWithNullArguments() {
        Student testStudent = new Student("test", "test", 1);
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> Main.removeStudent(
                        null, studentsMap, studentsListIndex,
                        testStudent.getName(), testStudent.getFaculty(), testStudent.getYear()
                )),
                () -> assertThrows(NullPointerException.class, () -> Main.removeStudent(
                        studentsList, null, studentsListIndex,
                        testStudent.getName(), testStudent.getFaculty(), testStudent.getYear()
                )),
                () -> assertThrows(NullPointerException.class, () -> Main.removeStudent(
                        studentsList, studentsMap, null,
                        testStudent.getName(), testStudent.getFaculty(), testStudent.getYear()
                )),
                () -> assertThrows(NullPointerException.class, () -> Main.removeStudent(
                        studentsList, studentsMap, studentsListIndex,
                        null, testStudent.getFaculty(), testStudent.getYear()
                )),
                () -> assertThrows(NullPointerException.class, () -> Main.removeStudent(
                        studentsList, studentsMap, studentsListIndex,
                        testStudent.getName(), null, testStudent.getYear()
                ))
        );
    }

    @Test
    @DisplayName("Test searchSameFacultyAndYearStudents method with valid arguments")
    void testHashMap_searchGroupStudents() {
        Id id = new Id("CS", 1);

        List<Student> result = Main.searchSameFacultyAndYearStudents(studentsMap, id.getFaculty(), id.getYear());

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(2, result.size())
        );
    }

    @Test
    @DisplayName("Test searchSameFacultyAndYearStudents method with not existing group")
    void testHashMap_searchNotExistingGroupStudents() {
        Id id = new Id("Bio", 3);

        List<Student> result = Main.searchSameFacultyAndYearStudents(studentsMap, id.getFaculty(), id.getYear());

        assertNull(result);
    }

    @Test
    @DisplayName("Test searchSameFacultyAndYearStudents method with null Arguments")
    void testHashMap_searchGroupStudentsWithNullArguments() {
        Id id = new Id("CS", 1);

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> Main.searchSameFacultyAndYearStudents(
                        null, id.getFaculty(), id.getYear()
                )),
                () -> assertThrows(NullPointerException.class, () -> Main.searchSameFacultyAndYearStudents(
                        studentsMap, null, id.getYear()
                ))
        );
    }

    @Test
    @DisplayName("Test printAllStudentsByGroup method")
    void testHashMap_printMap() {
        assertDoesNotThrow(() -> Main.printAllStudentsByGroup(studentsMap));
    }

    @Test
    @DisplayName("Test printAllStudentsByGroup method with null map")
    void testHashMap_printNullMap() {
        assertThrows(NullPointerException.class, () -> Main.printAllStudentsByGroup(null));
    }
}
