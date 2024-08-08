package faang.school.godbless.uni;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniTest {
    private Uni uni;

    @Test
    void shouldShowGroupedStudents() {
        uni = new Uni();
        uni.addStudent("a", "art", 2020);
        uni.addStudent("b", "art", 2020);
        uni.addStudent("c", "art", 2021);
        uni.addStudent("d", "cs", 2020);
        Map<String, List<Student>> expected =
                Map.of("art-2020",
                        List.of(new Student("a", "art", 2020),
                                new Student("b", "art", 2020)),
                        "art-2021",
                        List.of(new Student("c", "art", 2021)),
                        "cs-2020",
                        List.of(new Student("d", "cs", 2020)));
        assertEquals(expected, uni.groupedStudents());
        ;
    }

    @Test
    void shouldSearchByYearAndFaculty() {
        uni = new Uni();
        uni.addStudent("a", "art", 2020);
        uni.addStudent("b", "art", 2020);
        uni.addStudent("c", "art", 2021);
        uni.addStudent("d", "cs", 2020);
        List<Student> expected = List.of(new Student("a", "art", 2020), new Student("b", "art", 2020));
        assertEquals(expected, uni.search("art", 2020));
        assertNull(uni.search("physics", 2020));
    }
}