package faang.school.godbless.sprint_1.task_45274;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.sprint_1.task_45274.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDatabaseTest {

    private static final StudentDatabase STUDENT_DATABASE = new StudentDatabase();

    @BeforeAll
    static void init() {
        STUDENT_DATABASE.addingNewStudentAndHisSubjectsWithGrades(STUDENT_1, SUBJECT_1, 3);
        STUDENT_DATABASE.addingNewStudentAndHisSubjectsWithGrades(STUDENT_2, SUBJECT_3, 5);
    }

    /**
     * Добавляет нового студента и его предмет с оценками
     */
    @Test
    void testAddingNewStudentAndHisSubjectsWithGrades() {
        //Этот студент добавиться не должен, так как он уже существует
        STUDENT_DATABASE.addingNewStudentAndHisSubjectsWithGrades(STUDENT_2, SUBJECT_4, 5);

        assertEquals(STUDENTS_MAP, STUDENT_DATABASE.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(SUBJECTS_MAP, STUDENT_DATABASE.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Добавляет новый предмет для существующего студента с оценкой
     */
    @Test
    void testAddingNewSubjectForAnExistingStudentWithGrade() {
        STUDENTS_MAP.get(STUDENT_1).put(SUBJECT_2, 4);
        STUDENTS_MAP.get(STUDENT_2).put(SUBJECT_5, 3);
        SUBJECTS_MAP.put(SUBJECT_2, new ArrayList<>() {{
                add(STUDENT_1);
                }
        });
        SUBJECTS_MAP.put(SUBJECT_5, new ArrayList<>() {{
                add(STUDENT_2);
                }
        });

        STUDENT_DATABASE.addingNewSubjectForAnExistingStudentWithGrade(STUDENT_1, SUBJECT_2, 4);
        STUDENT_DATABASE.addingNewSubjectForAnExistingStudentWithGrade(STUDENT_2, SUBJECT_5, 3);
        STUDENT_DATABASE.addingNewSubjectForAnExistingStudentWithGrade(STUDENT_3, SUBJECT_4, 5);

        assertEquals(STUDENTS_MAP, STUDENT_DATABASE.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(SUBJECTS_MAP, STUDENT_DATABASE.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Добавляет студента к существующему предмету
     */
    @Test
    void testAddingStudentToAnExistingSubject() {
        //Этот студент добавиться не должен, так как он уже существует
        STUDENT_DATABASE.addingStudentToAnExistingSubject(STUDENT_1, SUBJECT_1);
        STUDENT_DATABASE.addingStudentToAnExistingSubject(STUDENT_4, SUBJECT_1);

        Map<Subject, Integer> studentSubjectsAndGrades = new HashMap<>();
        studentSubjectsAndGrades.put(SUBJECT_1, null);
        STUDENTS_MAP.put(STUDENT_4, studentSubjectsAndGrades);
        SUBJECTS_MAP.get(SUBJECT_1).add(STUDENT_4);

        assertEquals(STUDENTS_MAP, STUDENT_DATABASE.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(SUBJECTS_MAP, STUDENT_DATABASE.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Удаляет студента и его предметы
     */
    @Test
    void deletingStudentAndHisSubjects() {
        STUDENT_DATABASE.deletingStudentAndHisSubjects(STUDENT_2);

        Map<Subject, Integer> studentSubjectsAndGrades = STUDENTS_MAP.remove(STUDENT_2);
        for (Subject subject : studentSubjectsAndGrades.keySet()) {
            SUBJECTS_MAP.get(subject).remove(STUDENT_2);
        }

        assertEquals(STUDENTS_MAP, STUDENT_DATABASE.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(SUBJECTS_MAP, STUDENT_DATABASE.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Добавляет новый предмет и список студентов, изучающих его
     */
    @Test
    void testAddingNewSubjectAndListOfStudentsStudyingIt() {
        List<Student> students = new ArrayList<>();
        students.add(STUDENT_4);
        students.add(STUDENT_5);
        STUDENT_DATABASE.addingNewSubjectAndListOfStudentsStudyingIt(SUBJECT_6, students);

        Map<Subject, Integer> studentsNewSubjectAndGrade = new HashMap<>();
        studentsNewSubjectAndGrade.put(SUBJECT_6, null);
        STUDENTS_MAP.put(STUDENT_4, studentsNewSubjectAndGrade);
        STUDENTS_MAP.put(STUDENT_5, studentsNewSubjectAndGrade);

        SUBJECTS_MAP.put(SUBJECT_6, students);

        assertEquals(STUDENTS_MAP, STUDENT_DATABASE.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(SUBJECTS_MAP, STUDENT_DATABASE.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Удаляет студента из предмета
     */
    @Test
    void testDeletingStudentFromSubject() {
        STUDENT_DATABASE.deletingStudentFromSubject(STUDENT_1, SUBJECT_1);

        STUDENTS_MAP.get(STUDENT_1).remove(SUBJECT_1);
        SUBJECTS_MAP.get(SUBJECT_1).remove(STUDENT_1);

        assertEquals(STUDENTS_MAP, STUDENT_DATABASE.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(SUBJECTS_MAP, STUDENT_DATABASE.getListOfStudentsStudyingEachSubject());
    }
}