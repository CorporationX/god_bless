package faang.school.godbless.E_diary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class E_diaryTest {

    @ParameterizedTest
    @MethodSource("getArguments")
    void testGetAverageGrade(List<Student> students) {
        Map<String, Double> averageGrades = Map.of("Math", 4.75, "Chemistry", 4.25);
        assertEquals(averageGrades, E_diary.getAverageGrade(students));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void getFinalGrade(List<Student> students) {
        Map<String, Integer> averageGrades = Map.of("Math", 5, "Chemistry", 4);
        assertEquals(averageGrades, E_diary.getFinalGrade(students, "A", "B"));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void getTheMostStrongCourse(List<Student> students) {
        assertEquals("Chemistry", E_diary.getTheMostStrongCourse(students));
    }

    static Stream<Arguments> getArguments() {
        List<Integer> gradesChem = List.of(4, 5, 3, 5);
        List<Integer> gradesMath = List.of(4, 5, 5, 5);
        Map<String, List<Integer>> courses = Map.of("Math", gradesMath, "Chemistry", gradesChem);
        List<Student> students = List.of(new Student("A", "B", courses),
                new Student("C", "D", courses));
        return Stream.of(Arguments.of(students));
    }
}