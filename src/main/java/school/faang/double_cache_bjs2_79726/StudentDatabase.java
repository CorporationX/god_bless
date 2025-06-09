package school.faang.double_cache_bjs2_79726;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubject = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(String name, Map<Subject, Integer> subjectsAndMarks) {
        if (name == null || name.isEmpty()) {
            log.warn("Имя не может быть пустым");
            return;
        } else {
            Student student = new Student(name);
            studentSubject.put(student, subjectsAndMarks);

            for (Subject subject : subjectsAndMarks.keySet()) {
                List<Student> students = subjectStudents.getOrDefault(subject, new ArrayList<>());
                students.add(student);
                subjectStudents.put(subject, students);
            }
        }
    }

    public void addSubjectForStudent(String name, Map<Subject, Integer> subAndMark) {
        if (name == null || name.isEmpty()) {
            log.warn("Имя не может быть пустым");
            return;
        } else {
            Student targetStudent = null;
            for (Student student : studentSubject.keySet()) {
                if (student.getName().equals(name)) {
                    targetStudent = student;
                    break;
                }
            }

            if (targetStudent == null) {
                log.warn("Студент {} не найден", name);
                return;
            }

            Map<Subject, Integer> currentSubjects = studentSubject.getOrDefault(targetStudent, new HashMap<>());
            currentSubjects.putAll(subAndMark);
            studentSubject.put(targetStudent, currentSubjects);

            for (Subject subject : subAndMark.keySet()) {
                List<Student> students = subjectStudents.getOrDefault(subject, new ArrayList<>());
                if (!students.contains(targetStudent)) {
                    students.add(targetStudent);
                }
                subjectStudents.put(subject, students);
            }
        }
    }

    public void removeStudent(String name) {
        if (name == null || name.isEmpty()) {
            log.warn("Имя не может быть пустым");
            return;
        } else {
            Student studentToRemove = new Student(name);

            studentSubject.remove(studentToRemove);

            for (List<Student> students : subjectStudents.values()) {
                students.remove(studentToRemove);
            }
        }
    }

    public void printStudentsWithSubjects() {
        if (studentSubject.keySet().isEmpty()) {
            log.info("Студентов нет");
            return;
        } else {
            for (Student student : studentSubject.keySet()) {
                log.info("Студент {}\n", student.getName());
                log.info("Предмет {}\n", studentSubject.get(student));
            }
        }
    }

    public void printSubjectsWithStudents() {
        if (subjectStudents.keySet().isEmpty()) {
            log.info("Предметов нет");
            return;
        } else {
            for (Subject subject : subjectStudents.keySet()) {
                log.info("Предмет {}\n", subject.getName());
                log.info("Студенты {}\n", subjectStudents.get(subject));
            }
        }
    }

    public void addNewSubjectWithStudents(Subject subject, List<Student> students, Integer defaultMark) {
        if (subject == null || students == null || students.isEmpty()) {
            log.warn("Предмет или список студентов не могут быть пустыми");
            return;
        }
        List<Student> existingStudents = subjectStudents.getOrDefault(subject, new ArrayList<>());
        for (Student student : students) {
            if (!existingStudents.contains(student)) {
                existingStudents.add(student);
            }
            Map<Subject, Integer> subjects = studentSubject.get(student);
            if (subjects == null) {
                subjects = new HashMap<>();
            }
            subjects.putIfAbsent(subject, defaultMark);
            studentSubject.put(student, subjects);
        }
        subjectStudents.put(subject, existingStudents);
    }

    public void removeStudentFromSubject(String name, Subject subject) {
        if (name.isEmpty() || subject == null) {
            log.warn("Имя или предмет не может быть пустым");
            return;
        }

        Student targetStudent = null;
        for (Student student : studentSubject.keySet()) {
            if (student.getName().equals(name)) {
                targetStudent = student;
                break;
            }
        }

        if (targetStudent == null) {
            log.warn("Студент {} не найден", name);
            return;
        }

        Map<Subject, Integer> subjects = studentSubject.get(targetStudent);
        if (subjects != null) {
            subjects.remove(subject);
        }

        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(targetStudent);
        }
    }
}