package org.example.model.doubleCash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Student, Map<Subject, Integer>> studentsGradeBySubjects = new HashMap<>();
    public static Map<Subject, List<Student>> studentsListForSubject = new HashMap<>();

    public static Map<Student, Map<Subject, Integer>> addStudentAndGradeFofSubjects(Student student, Map<Subject, Integer> subjectGrades){
        Main.studentsGradeBySubjects.put(student, subjectGrades);
        for(Map.Entry<Subject, Integer> subjectGrade: subjectGrades.entrySet()){
            studentsListForSubject.computeIfAbsent(subjectGrade.getKey(), subject -> new ArrayList<Student>()).add(student);
        }

        Map<Student, Map<Subject, Integer>> addedStudentWithSubjectGrades = new HashMap<>();
        addedStudentWithSubjectGrades.put(student, subjectGrades);
        return addedStudentWithSubjectGrades;
    }

    public static void addNewSubjectForStudent(Student student, Subject subject){
        studentsGradeBySubjects.computeIfAbsent(student, currentStudent -> new HashMap<Subject, Integer>());
        studentsListForSubject.computeIfAbsent(subject, newSubject -> new ArrayList<Student>()).add(student);
    }

    public static void deleteStudentWithGradesBySubjects(Student student){
        Map<Subject, Integer> deletedStudentSubjectsWithGrade = studentsGradeBySubjects.remove(student);
        for(Subject subject: deletedStudentSubjectsWithGrade.keySet()){
            studentsListForSubject.computeIfPresent(subject, (s, students) -> {
                students.remove(student);
                return students;
            });
        }
    }

    public static void getAllSubjectsWithStudentsAndGrades(){
        for(Map.Entry<Subject, List<Student>> studentsBySubject: studentsListForSubject.entrySet()){
            var currentSubject = studentsBySubject.getKey();
            System.out.println(currentSubject.getName() + ": \n" +
                    "students: \n");
            studentsBySubject.getValue().forEach(student -> {
                System.out.println(student.getName() + " grade: " + studentsGradeBySubjects.get(student).get(currentSubject));
            });
        }
    }
}
