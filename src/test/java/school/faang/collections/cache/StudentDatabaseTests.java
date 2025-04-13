package school.faang.collections.cache;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.collection.cache.Student;
import school.faang.collection.cache.StudentDatabase;
import school.faang.collection.cache.Subject;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class StudentDatabaseTests {


    @Test
    public void removeNotExistingStudentThrowsNoSuchElementException() {
        StudentDatabase database = new StudentDatabase();
        Student studentToDelete = new Student("Kirill");

        Assertions.assertThatThrownBy(() -> database.removeStudent(studentToDelete))
                .as("can't remove student that not in DB")
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void removeNotExistingSubjectThrowsNoSuchElementException() {
        Student student = new Student("Kirill");
        Subject subject = new Subject("Geometry");
        Subject subjectToDelete = new Subject("Algebra");
        StudentDatabase database = new StudentDatabase()
                .addNewSubjectToStudent(student, subject, 5);

        Assertions.assertThatThrownBy(() -> database.removeStudentFromSubject(subjectToDelete, student))
                .as("can't remove from subject that not in DB")
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void addedStudentContainsInSubjectList() {
        Student student = new Student("Kirill");
        Subject subject = new Subject("Geometry");
        StudentDatabase database = new StudentDatabase()
                .addNewSubjectToStudent(student, subject, 5);

        List<Student> checkData = List.of(student);

        Assertions.assertThat(database.getSubjectStudents().get(subject))
                .as("subject students list not contain added student")
                .isEqualTo(checkData);
    }

    @Test
    public void addedSubjectContainsInStudentDiary() {
        Student fisrtStudent = new Student("Kirill");
        Student secondStudent = new Student("John");
        Subject subject = new Subject("Geometry");
        var checkData = Map.of(
                fisrtStudent, 5,
                secondStudent, 4
        );

        StudentDatabase database = new StudentDatabase()
                .addSubjectStudents(subject, checkData);

        checkData.forEach((student, rating) -> {
            Assertions.assertThat(
                            database.getStudentSubjects().get(student).keySet()
                    ).as("student do not have added subject")
                    .contains(subject);

            Assertions.assertThat(
                            database.getStudentSubjects().get(student).get(subject)
                    ).as("subject rating not added")
                    .isEqualTo(rating);
        });
    }
}
