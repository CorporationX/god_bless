package double_Cache;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Validator {

    public void checkGrade(Integer grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("оценка не может быть меньше 2ух и не больше 5 включительно!");
        }
    }

    public void checkSaveMapMap(Student student, Subject subject, Map<Student, Map<Subject, Integer>> studentMapMap) {
        if (!studentMapMap.containsKey(student) || !studentMapMap.get(student).containsKey(subject)) {
            throw new IllegalStateException("Не удалось добавить оценку");
        }
    }

    public void checkStudentIsBlank(Student student) {
        if (!StringUtils.hasText(student.getName())) {
            throw new IllegalArgumentException("У студенто должно быть имя!");
        }
    }

    public void checkMapIsEmpty(Map<Student, Map<Subject, Integer>> studentMapMap) {
        if (studentMapMap.isEmpty()) {
            throw new IllegalStateException("Нельзя удалить из пустого списка!");
        }
    }

    public void checkRemoveMapStudents(Student student, Map<Student, Map<Subject, Integer>> studentMapMap) {
        if (studentMapMap.containsKey(student)) {
            throw new IllegalStateException("Ошибка удаления!");
        }
    }

    public void checkAddMapSubject(Subject subject, Student student, Map<Subject, List<Student>> subjectListMap) {
        if (!subjectListMap.get(subject).contains(student)) {
            throw new IllegalStateException("Ошибка: список студентов не добавился!");
        }
    }

    public void checkListStudentsIsEmpty(List<Student> studentList) {
        if (studentList.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым!");
        }
    }

    public void checkSubjectNameIsBlank(Subject subject) {
        if (!StringUtils.hasText(subject.getName())) {
            throw new IllegalArgumentException("У предмета должно быть название!");
        }
    }

    public void checkSaveMapSubject(Subject subject, Map<Subject, List<Student>> subjectListMap, int sizeBefore) {
        if (sizeBefore >= subjectListMap.get(subject).size()) {
            throw new IllegalStateException("Ошибка, список студентов не добавлен!");
        }
    }

    public void checkMapSubjectIsEmpty(Map<Subject, List<Student>> subjectListMap) {
        if (subjectListMap.isEmpty()) {
            throw new IllegalArgumentException("Нельзя удалить из пустого списка!");
        }
    }

    public void checkMapKeySubject(Subject subject, Map<Subject, List<Student>> subjectListMap) {
        if (!subjectListMap.containsKey(subject)) {
            throw new IllegalArgumentException("Такого предмета нет в списке!");
        }
    }
}
