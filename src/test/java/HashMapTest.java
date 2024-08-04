import hashmap.group.Id;
import hashmap.group.Main;
import hashmap.group.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {
    private List<Student> students;

    @BeforeEach
    public void setUp() {
        students = new ArrayList<>();
        students.add(new Student("John Doe", "Faculty1", 2020));
        students.add(new Student("Jane Doe", "Faculty1", 2020));
        students.add(new Student("Alice", "Faculty2", 2021));
        students.add(new Student("Bob", "Faculty1", 2021));
    }

    @Test
    @DisplayName("Test fillMap method with valid list of students")
    public void testFillMap_ValidList() {
        Map<Id, List<Student>> result = Main.fillMap(students);

        assertEquals(3, result.size());

        Id id1 = new Id("Faculty1", 2020);
        Id id2 = new Id("Faculty2", 2021);
        Id id3 = new Id("Faculty1", 2021);

        assertTrue(result.containsKey(id1));
        assertTrue(result.containsKey(id2));
        assertTrue(result.containsKey(id3));

        assertEquals(2, result.get(id1).size());
        assertEquals(1, result.get(id2).size());
        assertEquals(1, result.get(id3).size());
    }

    @Test
    @DisplayName("Test fillMap method with empty list of students")
    public void testFillMap_EmptyList() {
        Map<Id, List<Student>> result = Main.fillMap(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test fillMap method with null list of students")
    public void testFillMap_NullList() {
        assertThrows(NullPointerException.class, Main.fillMap(null));
    }

    private void assertThrows(Class<NullPointerException> nullPointerExceptionClass, Object o) {
    }

    @Test
    @DisplayName("Test fillMap method with students having the same faculty and year")
    public void testFillMap_SameFacultyAndYear() {
        students.add(new Student("Charlie", "Faculty1", 2020));

        Map<Id, List<Student>> result = Main.fillMap(students);

        assertEquals(3, result.size());

        Id id1 = new Id("Faculty1", 2020);
        assertTrue(result.containsKey(id1));
        assertEquals(3, result.get(id1).size());
    }
}
