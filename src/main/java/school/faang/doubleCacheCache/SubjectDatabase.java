package school.faang.doubleCacheCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SubjectDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(String name, Map<Subject, Integer> subjectWithGrades) {
        Student student = new Student(name);

        studentSubjects.put(student, subjectWithGrades);

        for (Subject subject : subjectWithGrades.keySet()) {
            if (subjectStudents.containsKey(subject)) {
                List<Student> students = subjectStudents.get(subject);
                students.add(student);
            } else {
                List<Student> students = new ArrayList<>();
                students.add(student);
                subjectStudents.put(subject, students);
            }
        }
    }

    public void addSubject(String studentName, Integer grade, String subjectName) {
        for (Student student : studentSubjects.keySet()) {
            if (Objects.equals(student.getName(), studentName)) {
                Subject subject = new Subject(subjectName);

                Map<Subject, Integer> subjects = studentSubjects.get(student);
                subjects.put(subject, grade);

                if (subjectStudents.containsKey(subject)) {
                    List<Student> students = subjectStudents.get(subject);
                    students.add(student);
                } else {
                    List<Student> students = new ArrayList<>();
                    students.add(student);
                    subjectStudents.put(subject, students);
                }
            }
        }
    }

    public void deleteStudent(String name, String subjectName) {
        for (Student student : studentSubjects.keySet()) {
            if (Objects.equals(student.getName(), name)) {
                Subject newSubject =  new Subject(subjectName);
                Map<Subject, Integer> subjects = studentSubjects.get(student);
                subjects.remove(newSubject);
                if (subjectStudents.containsKey(newSubject)) {
                    List<Student> students = subjectStudents.get(newSubject);
                    subjects.remove(newSubject);
                }
                break;
            }
        }
    }

    public void printAllStudentsAndGrades() {
        for (Student student : studentSubjects.keySet()) {
            System.out.println("Student: " + student.getName());

            Map<Subject, Integer> subjects = studentSubjects.get(student);
            for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
                System.out.println("  Subject: " + entry.getKey().getName() + ", Grade: " + entry.getValue());
            }

            System.out.println();
        }
    }

    // 5th section
    public void addNewSubjectWithStudents(String subjectName, List<Student> students) {
        Subject newSubject = new Subject(subjectName);

        subjectStudents.put(newSubject, new ArrayList<>(students));

        for (Student student : students) {
            Map<Subject, Integer> subjects = studentSubjects.computeIfAbsent(student, s -> new HashMap<>());
            subjects.putIfAbsent(newSubject, 0);
        }
    }

    public void addStudentToSubject(String subjectName, Student student) {
        Subject subject = new Subject(subjectName);

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);

        if (studentSubjects.containsKey(student)) {
            Map<Subject, Integer> subjects = studentSubjects.get(student);
            subjects.put(subject, 0);
        } else {
            Map<Subject, Integer> subjects = new HashMap<>();
            subjects.put(subject, 0);
            studentSubjects.put(student, subjects);
        }
    }


    public void removeStudentFromSubject(String subjectName, String studentName) {
        Subject subject = new Subject(subjectName);

        if (subjectStudents.containsKey(subject)) {
            List<Student> students = subjectStudents.get(subject);
            students.removeIf(student -> student.getName().equals(studentName));

            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }
        }
        

        for (Student student : studentSubjects.keySet()) {
            if (Objects.equals(student.getName(), studentName)) {
                Map<Subject, Integer> subjects = studentSubjects.get(student);
                subjects.remove(subject);
                break;
            }
        }
    }


    public void printAllSubjectsAndStudents() {
        for (Subject subject : subjectStudents.keySet()) {
            System.out.println("Subject: " + subject.getName());

            List<Student> students = subjectStudents.get(subject);
            for (Student student : students) {
                System.out.println("Student: " + student.getName());
            }

            System.out.println();
        }
    }



}
