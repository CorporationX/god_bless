package school.faang.task_57028;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class StudentDatabase {
    public Map<Student, Map<Subject, Integer>> studentSubjects;
    public Map<Subject, List<Student>> subjectStudents;

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.put(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }


    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>()); // Создаем запись для студента, если её нет
        studentSubjects.get(student).put(subject, grade); // Добавляем предмет и оценку
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student); // Добавляем студента к предмету
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student); // Удаляем записи студента
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student); // Удаляем студента из списка предмета
                }
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("Предмет: " + subject.name());
            for (Student student : entry.getValue()) {
                System.out.println("   Студент: " + student.name());
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students)); // Добавляем предмет и список студентов
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null); // Добавляем предмет в записи студента
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student); // Добавляем студента к предмету
        }
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null); // Добавляем предмет в записи студента
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student); // Удаляем студента из списка предмета
        }
        Map<Subject, Integer> grades = studentSubjects.get(student);
        if (grades != null) {
            grades.remove(subject); // Удаляем предмет из записей студента
        }
    }
}