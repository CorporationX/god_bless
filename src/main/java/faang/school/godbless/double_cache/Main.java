package faang.school.godbless.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static private Map<Student, Map<Subject, Integer>> studentSubjectMap = new HashMap<>();
    static private Map<Subject, List<Student>> subjectStudentMap = new HashMap<>();
    public static void main(String[] args) {
        Student max = new Student(1, "Max");
        Student nick = new Student(2, "Nick");
        Subject math = new Subject(1, "Математика");
        Subject physics = new Subject(2, "Физика");
        Subject english = new Subject(3, "Английский");
        Subject biology = new Subject(4, "Биология");
        Map<Subject, Integer> subjectsMax = new HashMap<>();
        subjectsMax.put(math, 90);
        subjectsMax.put(physics, 85);
        Map<Subject, Integer> subjectsNick = new HashMap<>();
        subjectsNick.put(english, 88);
        subjectsNick.put(biology, 82);
        addStudent(studentSubjectMap, max, subjectsMax);
        addStudent(studentSubjectMap, nick, subjectsNick);
        removeStudentWithSubjects(studentSubjectMap, nick);
        addSubjectWithGradeForStudent(studentSubjectMap, max, english, 87);
        printAllStudentsWithGrades(studentSubjectMap);
        System.out.println("====================>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("====================>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("====================>>>>>>>>>>>>>>>>>>>>>>>>>");
        addSubjectWithStudents(subjectStudentMap, math, List.of(max));
        addSubjectWithStudents(subjectStudentMap, physics, List.of(max));
        addSubjectWithStudents(subjectStudentMap, english, List.of(nick));
        addSubjectWithStudents(subjectStudentMap, biology, List.of(nick));
        printSubjectStudentsMap(subjectStudentMap);
        removeStudentFromSubject(subjectStudentMap, math, max);
        removeStudentFromSubject(subjectStudentMap, biology, nick);
        addStudentToSubject(subjectStudentMap, math, nick);
        addStudentToSubject(subjectStudentMap, biology, nick);
        printSubjectStudentsMap(subjectStudentMap);
    }

    private static void addStudent(Map<Student, Map<Subject, Integer>> studentSubjectMap,
                                   Student student, Map<Subject, Integer> subjects){
        if (!studentSubjectMap.containsKey(student)){
            studentSubjectMap.put(student, subjects);
            System.out.println("Студент " + student.getName() + " добавлен");
        }
        else {
            System.out.println("Студент " + student.getName() + " уже есть в списке");
        }
    }

    private static void addSubjectWithGradeForStudent(Map<Student, Map<Subject,
            Integer>> studentSubjectMap, Student student, Subject subject, int grade) {
        Map<Subject, Integer> subjectsMap = studentSubjectMap.get(student);
        if (subjectsMap == null) {
            subjectsMap = new HashMap<>();
        }
        subjectsMap.put(subject, grade);
        studentSubjectMap.put(student, subjectsMap);
    }

    private static void removeStudentWithSubjects(Map<Student, Map<Subject, Integer>> studentSubjectMap,
                                                  Student student) {
        if (studentSubjectMap.containsKey(student)){
            studentSubjectMap.remove(student);
            System.out.println("Студент " + student.getName() + " удалён");
        }
        else {
            System.out.println("Студента " + student.getName() + " нет в списке");
        }
    }

    private static void printAllStudentsWithGrades(Map<Student, Map<Subject, Integer>> studentSubjectMap) {
        for (Student student : studentSubjectMap.keySet()) {
            System.out.println("id студента: " + student.getId() + ", имя: " + student.getName());
            Map<Subject, Integer> subjectsMap = studentSubjectMap.get(student);
            for (Subject subject : subjectsMap.keySet()) {
                System.out.println("Предмет: " + subject.getName() + ", Оценка: " + subjectsMap.get(subject));
            }
            System.out.println();
        }
    }

    private static void addSubjectWithStudents(Map<Subject, List<Student>> map, Subject subject, List<Student> students) {
        if (!map.containsKey(subject)){
            map.put(subject, students);
        }
        else {
            System.out.println("Предмета " + subject.getName() + " не найдено");
        }
    }

    private static void addStudentToSubject(Map<Subject, List<Student>> map, Subject subject, Student student) {
        List<Student> students = map.getOrDefault(subject, new ArrayList<>());
        students.add(student);
        map.put(subject, students);
        System.out.println("Студент " + student.getName() + " добавлен к " + subject.getName());
    }

    private static void removeStudentFromSubject(Map<Subject, List<Student>> map, Subject subject, Student student) {
        List<Student> students = map.get(subject);
        if (students != null) {
            List<Student> updatedStudents = new ArrayList<>(students);
            updatedStudents.remove(student);
            if (updatedStudents.isEmpty()) {
                map.remove(subject);
            } else {
                map.put(subject, updatedStudents);
            }
            System.out.println("Студент " + student.getName() + " удалён с " + subject.getName());
        }
    }

    private static void printSubjectStudentsMap(Map<Subject, List<Student>> map) {
        for (Map.Entry<Subject, List<Student>> entry : map.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("Предмет: " + subject.getName());
            System.out.println("Студенты:");
            for (Student student : students) {
                System.out.println(student.getName());
            }
            System.out.println();
        }
    }
}

