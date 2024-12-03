package school.faang.task_45214.util;

import school.faang.task_45214.model.Student;
import school.faang.task_45214.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    HashMap<Student, Map<Subject, Integer>> students;
    HashMap<Subject, List<Student>> subjects;

    public StudentDatabase(HashMap<Student, Map<Subject, Integer>> students, HashMap<Subject, List<Student>> subjects) {
        this.students = students;
        this.subjects = subjects;
    }

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        students.put(student, subjects);
        for (Subject subject : subjects.keySet()) {
            this.subjects.putIfAbsent(subject, new ArrayList<>());
            this.subjects.get(subject).add(student);
        }
    }

    public void addSubjectWithStudent(Student student, Subject subjectNew, Integer score) {
        Map<Subject, Integer> grades = this.students.get(student);
        if (grades != null) {
            grades.put(subjectNew, score);
            subjects.putIfAbsent(subjectNew, new ArrayList<>());
            subjects.get(subjectNew).add(student);
        }
    }

    public void deleteStudentWithSubjects(Student student) {
        Map<Subject, Integer> grades = this.students.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> studentsFromSubjects = this.subjects.get(subject);
                if (studentsFromSubjects != null) {
                    studentsFromSubjects.remove(student);
                }
            }
        }
    }
}
