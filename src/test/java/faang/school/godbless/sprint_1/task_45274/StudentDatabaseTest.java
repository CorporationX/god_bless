package faang.school.godbless.sprint_1.task_45274;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.sprint_1.task_45274.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDatabaseTest {

    private final StudentDatabase studentDatabase = new StudentDatabase();

    private final Map<Student, Map<Subject, Integer>> studentsMap = new HashMap<>();

    private final Map<Subject, List<Student>> subjectsMap = new HashMap<>();

    @BeforeEach
    void init() {
        studentDatabase.addingNewStudentAndHisSubjectsWithGrades(STUDENT_1, SUBJECT_1, 3);
        studentDatabase.addingNewStudentAndHisSubjectsWithGrades(STUDENT_2, SUBJECT_3, 5);

        studentsMap.put(STUDENT_1, new HashMap<>() {{
                put(SUBJECT_1, 3);
            }
        });
        studentsMap.put(STUDENT_2, new HashMap<>() {{
                put(SUBJECT_3, 5);
            }
        });

        subjectsMap.put(SUBJECT_1, new ArrayList<>() {{
                add(STUDENT_1);
            }
        });
        subjectsMap.put(SUBJECT_3, new ArrayList<>() {{
                add(STUDENT_2);
            }
        });
    }

    /**
     * Добавляет нового студента и его предмет с оценками
     */
    @Test
    void testAddingNewStudentAndHisSubjectsWithGrades() {
        //Этот студент добавиться не должен, так как он уже существует
        studentDatabase.addingNewStudentAndHisSubjectsWithGrades(STUDENT_2, SUBJECT_4, 5);

        assertEquals(studentsMap, studentDatabase.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(subjectsMap, studentDatabase.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Добавляет новый предмет для существующего студента с оценкой
     */
    @Test
    void testAddingNewSubjectForAnExistingStudentWithGrade() {
        studentsMap.get(STUDENT_1).put(SUBJECT_2, 4);
        studentsMap.get(STUDENT_2).put(SUBJECT_5, 3);
        subjectsMap.put(SUBJECT_2, new ArrayList<>() {{
                add(STUDENT_1);
                }
        });
        subjectsMap.put(SUBJECT_5, new ArrayList<>() {{
                add(STUDENT_2);
                }
        });

        studentDatabase.addingNewSubjectForAnExistingStudentWithGrade(STUDENT_1, SUBJECT_2, 4);
        studentDatabase.addingNewSubjectForAnExistingStudentWithGrade(STUDENT_2, SUBJECT_5, 3);
        studentDatabase.addingNewSubjectForAnExistingStudentWithGrade(STUDENT_3, SUBJECT_4, 5);

        assertEquals(studentsMap, studentDatabase.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(subjectsMap, studentDatabase.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Добавляет студента к существующему предмету
     */
    @Test
    void testAddingStudentToAnExistingSubject() {
        //Этот студент добавиться не должен, так как он уже существует
        studentDatabase.addingStudentToAnExistingSubject(STUDENT_1, SUBJECT_1);
        studentDatabase.addingStudentToAnExistingSubject(STUDENT_4, SUBJECT_1);

        Map<Subject, Integer> studentSubjectsAndGrades = new HashMap<>();
        studentSubjectsAndGrades.put(SUBJECT_1, null);
        studentsMap.put(STUDENT_4, studentSubjectsAndGrades);
        subjectsMap.get(SUBJECT_1).add(STUDENT_4);

        assertEquals(studentsMap, studentDatabase.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(subjectsMap, studentDatabase.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Удаляет студента и его предметы
     */
    @Test
    void deletingStudentAndHisSubjects() {
        studentDatabase.deletingStudentAndHisSubjects(STUDENT_2);

        Map<Subject, Integer> studentSubjectsAndGrades = studentsMap.remove(STUDENT_2);
        for (Subject subject : studentSubjectsAndGrades.keySet()) {
            subjectsMap.get(subject).remove(STUDENT_2);
        }

        assertEquals(studentsMap, studentDatabase.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(subjectsMap, studentDatabase.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Добавляет новый предмет и список студентов, изучающих его
     */
    @Test
    void testAddingNewSubjectAndListOfStudentsStudyingIt() {
        List<Student> students = new ArrayList<>();
        students.add(STUDENT_4);
        students.add(STUDENT_5);
        studentDatabase.addingNewSubjectAndListOfStudentsStudyingIt(SUBJECT_6, students);

        Map<Subject, Integer> studentsNewSubjectAndGrade = new HashMap<>();
        studentsNewSubjectAndGrade.put(SUBJECT_6, null);
        studentsMap.put(STUDENT_4, studentsNewSubjectAndGrade);
        studentsMap.put(STUDENT_5, studentsNewSubjectAndGrade);

        subjectsMap.put(SUBJECT_6, students);

        assertEquals(studentsMap, studentDatabase.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(subjectsMap, studentDatabase.getListOfStudentsStudyingEachSubject());
    }

    /**
     * Удаляет студента из предмета
     */
    @Test
    void testDeletingStudentFromSubject() {
        studentDatabase.deletingStudentFromSubject(STUDENT_1, SUBJECT_1);

        studentsMap.get(STUDENT_1).remove(SUBJECT_1);
        subjectsMap.get(SUBJECT_1).remove(STUDENT_1);

        assertEquals(studentsMap, studentDatabase.getListOfSubjectsAndGradesForEachStudent());
        assertEquals(subjectsMap, studentDatabase.getListOfStudentsStudyingEachSubject());
    }
}