package faang.school.godbless.BJS2_19538;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    List<Student> students;
    Map<String, List<Student>> expectedGroupedStudents = Map.of(
            "Engineering-2018", List.of(
                    new Student("Jack", "Engineering", 2018),
                    new Student("Dillon", "Engineering", 2018),
                    new Student("Robert", "Engineering", 2018)
            ),
            "Science-2019", List.of(
                    new Student("Anna", "Science", 2019),
                    new Student("Alice", "Science", 2019),
                    new Student("Sara", "Science", 2019)
            ),
            "IT-2020", List.of(
                    new Student("Ada", "IT", 2020),
                    new Student("Bob", "IT", 2020),
                    new Student("Jane", "IT", 2020),
                    new Student("Jill", "IT", 2020)
            ));

    @BeforeEach
    void setUp() {
        students = new ArrayList<>(List.copyOf(Application.getStudents()));
    }

    @Test
    void getStudents() {
        var result = Application.groupStudentsByFacultyAndYear(students);
        assertThat(result).isEqualTo(expectedGroupedStudents);
    }

    @Test
    void addStudent() {
        var student = new Student("Mia", "Medicine", 2021);
        Application.addStudent(students, student);
        assertThat(students).contains(student);
        assertThat(students).hasSize(11);
    }


    @Test
    void findStudentsByFacultyAndYear() {
        var result = Application.findStudentsByFacultyAndYear(students, "IT", 2020);
        var expected = List.of(
                new Student("Ada", "IT", 2020),
                new Student("Bob", "IT", 2020),
                new Student("Jane", "IT", 2020),
                new Student("Jill", "IT", 2020)
        );

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void delete() {
        Application.delete("Ada", "IT", 2020, students);
        assertThat(students).doesNotContain(new Student("Ada", "IT", 2020));
        assertThat(students).hasSize(9);
    }
}