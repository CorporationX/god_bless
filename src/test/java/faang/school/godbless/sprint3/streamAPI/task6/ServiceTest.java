package faang.school.godbless.sprint3.streamAPI.task6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    private final Service service = new Service();

    @ParameterizedTest
    @MethodSource("providerStudents")
    void avgGradeSubject(List<Student> students) {
        Map<String, Double> expected = Map.of(
                "Химия", 2.75,
                "Математика", 3.25
        );

        Map<String, Double> actual = service.avgGradeSubject(students);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("providerStudents")
    void avgGradeSubjectForStudent(List<Student> students) {
        Map<String, Integer> expected = Map.of(
                "Химия", 3,
                "Математика", 2
        );

        Map<String, Integer> actual = service.avgGradeSubjectForStudent(students, "Иван", "Иванов");

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("providerStudents")
    void findHurdStudent(List<Student> students) {
        String expected = "Химия";

        String actual = service.findHardSubject(students);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> providerStudents() {
        List<Student> students = List.of(
                new Student("Иван", "Иванов", Map.of(
                        "Химия", List.of(2, 3, 2, 4),
                        "Математика", List.of(2, 2, 2, 3)
                )),
                new Student("Петя", "Петров", Map.of(
                        "Химия", List.of(3, 3, 2, 3),
                        "Математика", List.of(5, 5, 3, 4)
                ))
        );
        return Stream.of(Arguments.of(students));
    }
}