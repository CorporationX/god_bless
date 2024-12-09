package faang.school.godbless.sprint_1.task_45274;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {

    private final StudentService studentService = new StudentService();

    /**
     * Список предметов и оценок каждого студента
     */
    private final Map<Student, Map<Subject, Integer>> listOfSubjectsAndGradesForEachStudent
            = studentService.getListOfSubjectsAndGradesForEachStudent();

    /**
     * Студенты, изучающие каждый предмет
     */
    private final Map<Subject, List<Student>> listOfStudentsStudyingEachSubject
            = studentService.getListOfStudentsStudyingEachSubject();

    /**
     * Добавляет нового студента и его предмет с оценками
     *
     * @param student студент
     * @param subject предмет
     * @param grade   оценка
     */
    public void addingNewStudentAndHisSubjectsWithGrades(Student student, Subject subject, int grade) {
        //Если студент существует, то ничего не происходит
        if (!listOfSubjectsAndGradesForEachStudent.containsKey(student)) {
            Map<Subject, Integer> studentSubjectsAndGrades = new HashMap<>();
            studentSubjectsAndGrades.put(subject, grade);
            listOfSubjectsAndGradesForEachStudent.put(student, studentSubjectsAndGrades);

            listOfStudentsStudyingEachSubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    /**
     * Добавляет новый предмет для существующего студента с оценкой
     *
     * @param student студент
     * @param subject предмет, который изучает студент
     * @param grade   оценка по предмету, который изучает студент
     */
    public void addingNewSubjectForAnExistingStudentWithGrade(Student student, Subject subject, int grade) {
        //Если студента не существует и предмет существует, то ничего не происходит
        if (listOfSubjectsAndGradesForEachStudent.containsKey(student)
                && !listOfStudentsStudyingEachSubject.containsKey(subject)) {

            listOfSubjectsAndGradesForEachStudent.get(student).put(subject, grade);

            List<Student> students = new ArrayList<>();
            students.add(student);
            listOfStudentsStudyingEachSubject.put(subject, students);
        }
    }

    /**
     * Удаляет студента и его предметы
     *
     * @param removedStudent удаляемый студент
     */
    public void deletingStudentAndHisSubjects(Student removedStudent) {
        //Если студента не существует, ничего не происходит
        if (listOfSubjectsAndGradesForEachStudent.containsKey(removedStudent)) {
            Map<Subject, Integer> deletedStudentSubjectsAndGrades
                    = listOfSubjectsAndGradesForEachStudent.remove(removedStudent);

            for (Subject deletedStudentSubject : deletedStudentSubjectsAndGrades.keySet()) {
                //Если предмета не существует, ничего не происходит
                if (listOfStudentsStudyingEachSubject.containsKey(deletedStudentSubject)) {
                    listOfStudentsStudyingEachSubject.get(deletedStudentSubject).remove(removedStudent);
                }
            }
        }
    }

    /**
     * Выводит список всех студентов и их оценки по предметам
     */
    public void displayListOfAllStudentsAndTheirGradesInSubjects() {
        for (Map.Entry<Student, Map<Subject, Integer>> student : listOfSubjectsAndGradesForEachStudent.entrySet()) {
            for (Map.Entry<Subject, Integer> studentSubjectAndGrade : student.getValue().entrySet()) {
                System.out.println("Student — " + student.getKey() + "; subject — " + studentSubjectAndGrade.getKey()
                        + "; grade — " + studentSubjectAndGrade.getValue() + ".");
            }
        }
    }

    /**
     * Добавляет новый предмет и список студентов, изучающих его
     *
     * @param subject  новый предмет
     * @param students список студентов, изучающих новый предмет
     */
    public void addingNewSubjectAndListOfStudentsStudyingIt(Subject subject, List<Student> students) {
        //Если предмет существует, ничего не происходит
        if (!listOfStudentsStudyingEachSubject.containsKey(subject)) {
            listOfStudentsStudyingEachSubject.put(subject, students);

            for (Student student : students) {
                listOfSubjectsAndGradesForEachStudent.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
            }
        }
    }

    /**
     * Добавляет студента к существующему предмету
     *
     * @param student         студент
     * @param existingSubject существующий предмет
     */
    public void addingStudentToAnExistingSubject(Student student, Subject existingSubject) {
        //Если предмета не существует, ничего не происходит
        if (listOfStudentsStudyingEachSubject.containsKey(existingSubject)) {
            List<Student> students = listOfStudentsStudyingEachSubject.get(existingSubject);
            if (!students.contains(student)) {
                //Если предмет не содержит студента, добавляет его
                students.add(student);
            }

            Map<Subject, Integer> studentSubjectsAndGrades;
            if (listOfSubjectsAndGradesForEachStudent.containsKey(student)) {
                //Если студент существует, проверяет, изучает ли он передаваемый предмет.
                //Если нет, добавляет ему предмет без оценки
                studentSubjectsAndGrades = listOfSubjectsAndGradesForEachStudent.get(student);
                if (!studentSubjectsAndGrades.containsKey(existingSubject)) {
                    studentSubjectsAndGrades.put(existingSubject, null);
                    listOfSubjectsAndGradesForEachStudent.put(student, studentSubjectsAndGrades);
                }
            } else {
                //Если студента не существует, добавляет его и добавляет ему предмет без оценки
                studentSubjectsAndGrades = new HashMap<>();
                studentSubjectsAndGrades.put(existingSubject, null);
                listOfSubjectsAndGradesForEachStudent.put(student, studentSubjectsAndGrades);
            }
        }
    }

    /**
     * Удаляет студента из предмета
     *
     * @param student студент
     * @param subject предмет
     */
    public void deletingStudentFromSubject(Student student, Subject subject) {
        //Если студента и предмета не существует, ничего не происходит
        if (listOfSubjectsAndGradesForEachStudent.containsKey(student)
                && listOfStudentsStudyingEachSubject.containsKey(subject)) {

            listOfSubjectsAndGradesForEachStudent.get(student).remove(subject);
            listOfStudentsStudyingEachSubject.get(subject).remove(student);
        }
    }

    /**
     * Выводит список всех предметов и студентов, изучающих их
     */
    public void displayListAllSubjectsAndStudentsStudyingThem() {
        for (Map.Entry<Subject, List<Student>> subjectAndStudentsStudyingIt
                : listOfStudentsStudyingEachSubject.entrySet()) {

            System.out.println("Subject — " + subjectAndStudentsStudyingIt.getKey()
                    + "; students — " + subjectAndStudentsStudyingIt.getValue() + ".");
        }
    }
}
