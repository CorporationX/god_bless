package double_Cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    public static final Validator validator = new Validator();

    public void AddAssessmentsStudents(Student student, Subject subject, Integer grade, Map<Student, Map<Subject, Integer>> studentMapMap) {
        validator.checkGrade(grade);
        studentMapMap.compute(student, (key, value) -> {
            if (value == null) value = new HashMap<>();
            value.put(subject, grade);
            return value;
        });
        validator.checkSaveMapMap(student, subject, studentMapMap);
        System.out.printf("оценки студента: %s, добавлены", student.getName());
    }

    public void removeStudent(Student student, Map<Student, Map<Subject, Integer>> studentMapMap) {
        validator.checkStudentIsBlank(student);
        validator.checkMapIsEmptry(studentMapMap);

        studentMapMap.remove(student);

        validator.checkRemoveMapStudents(student, studentMapMap);
        System.out.println("информация о студенте: " + student + " удалена");
    }

    public void printAllAssessmentsStudents(Map<Student, Map<Subject, Integer>> studentMapMap) {
        validator.checkMapIsEmptry(studentMapMap);

        studentMapMap.forEach((key, value) -> {
            System.out.println("Студент: " + key.getName());
            value.forEach((key1, value1) ->
                    System.out.println("  Предмет: " + key1.getName() + " Оценка: " + value1));
        });
    }

    public void addSubjectWithStudents(Subject subject, Student student, Map<Subject, List<Student>> subjectListMap) {
        validator.checkStudentIsBlank(student);
        validator.checkSubjectNameIsBlank(subject);
        subjectListMap.compute(subject, (key, value) -> {
            if (value == null) value = new ArrayList<>();
            value.add(student);
            return value;
        });
        validator.CheckAddMapSubject(subject, student, subjectListMap);
        System.out.println("Студент добавлен!");
    }

    public void addSubjectWithListStudents(Subject subject, List<Student> studentList, Map<Subject, List<Student>> subjectListMap) {
        validator.checkSubjectNameIsBlank(subject);
        validator.checkListSudentsIsEmpty(studentList);
        int sizeBefore = subjectListMap.getOrDefault(subject, List.of()).size();
        subjectListMap.compute(subject, (key, value) -> {
            if (value == null) {
                return new ArrayList<>(studentList);
            }
            value.addAll(studentList);
            return value;
        });
        validator.checkSaveMapSubject(subject, subjectListMap, sizeBefore);
        System.out.println("список студентов добавлен!");
    }

    public void removeStudentFromSubject(Subject subject, Student student, Map<Subject, List<Student>> subjectListMap) {
        validator.checkSubjectNameIsBlank(subject);
        validator.checkStudentIsBlank(student);
        validator.checkMapSubjectIsEmpty(subjectListMap);
        validator.checkMapKeySubject(subject, subjectListMap);
        subjectListMap.get(subject).remove(student);
        System.out.println(subjectListMap);
    }

    public void printAllStudentFromSubject(Map<Subject, List<Student>> subjectListMap) {
        validator.checkMapSubjectIsEmpty(subjectListMap);
        subjectListMap.forEach((key, value) -> {
            System.out.println("Предмет: " + key.getName());
            value.forEach(student -> System.out.println(" Список обучающихся по предмету: " + student.getName()));
        });
    }
}