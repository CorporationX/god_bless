package school.faang.systemForStudentsGrades;

import java.util.*;

public class GradeTracker {
    Map<Student, Map<Subject, Integer>> subjectsByStudents = new HashMap<>();
    Map<Subject, Set<Student>> groupStudentsBySubject = new HashMap<>();


    public void addNewStudent(Student newStudent, Map<Subject, Integer> grades) {
        if(subjectsByStudents.get(newStudent) == null) {
            subjectsByStudents.put(newStudent, grades);

            for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
                groupStudentsBySubject.computeIfAbsent(entry.getKey(),k -> new HashSet<>()).add(newStudent);
            }
        }
    }

    public void addNewSubject(Student student, Subject newSubject, int grade) {
        Map<Subject, Integer> subjects = subjectsByStudents.get(student);

        if(subjects == null) return;

        groupStudentsBySubject.computeIfAbsent(newSubject, k -> new HashSet<>()).add(student);
        subjects.put(newSubject, grade);
    }

    public void deleteStudent(Student student) {
        subjectsByStudents.remove(student);
        for(Map.Entry<Subject, Set<Student>> entry : groupStudentsBySubject.entrySet()) {
            entry.getValue().remove(student);
        }
    }

    public String showStudentsAndSubjectsWithGrade() {
        StringBuilder result = new StringBuilder();

        for(Map.Entry<Student, Map<Subject, Integer>> entry : subjectsByStudents.entrySet()) {
            result.append(entry.getKey().getName());
            result.append(" предметы: ");
            result.append("\n");
            for(Map.Entry<Subject, Integer> subjectWithGrade : entry.getValue().entrySet()) {
                result.append(subjectWithGrade.getKey().getName());
                result.append(" ");
                result.append(subjectWithGrade.getValue());
                result.append("\n");
            }
            result.append("-----------------------");
            result.append("\n");
        }

        return result.toString();
    }

    //только вторая HashMap
    public void addNewSubjectAndListStudents(Subject newSubject, List<Student> students) {
        groupStudentsBySubject.put(newSubject, new HashSet<>(students));
    }

    public void addNewStudentToExistingSubject(Student newStudent, Subject subject) {
        groupStudentsBySubject.getOrDefault(subject, new HashSet<>()).add(newStudent);
    }

    public void removingStudentFromSubject(Student student, Subject subject) {
        groupStudentsBySubject.getOrDefault(subject, new HashSet<>()).remove(student);
    }

    public String showSubjectsAndListStudents() {
        StringBuilder result = new StringBuilder();

        for(Map.Entry<Subject, Set<Student>> entry : groupStudentsBySubject.entrySet()) {
            result.append(entry.getKey().getName());
            result.append(":");
            result.append("\n");
            for(Student student : entry.getValue()) {
                result.append(student.getName());
                result.append("\n");
            }
            result.append("-----------------------");
            result.append("\n");
        }
        return result.toString();
    }
}
