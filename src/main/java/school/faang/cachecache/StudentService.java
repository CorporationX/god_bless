package school.faang.cachecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    public void addStudent(Student student, Map<Student, Map<Subject, Integer>> studentNotes, Map<Subject, Integer> notes){
        studentNotes.putIfAbsent(student, notes);
    }

    public void addSubjectNoteToStudent(Student student, Map<Subject, Integer> notes, Map<Student, Map<Subject, Integer>> studentNotes){
        studentNotes.putIfAbsent(student, new HashMap<>());

        Map<Subject, Integer> currentNotes = studentNotes.get(student);
        currentNotes.putAll(notes);

        studentNotes.put(student, currentNotes);
    }

    public void removeStudent(Student student, Map<Student, Map<Subject, Integer>> studentNotes) {
        studentNotes.remove(student);
    }

    public void printAllStudentsWithGrades(Map<Student, Map<Subject, Integer>> studentNotes) {
        for(Map.Entry<Student, Map<Subject, Integer>> entry : studentNotes.entrySet()){
            System.out.println("Student: " + entry.getKey() + ", and his subjects with notes: " + entry.getValue());
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students, Map<Subject, List<Student>> studentsOfSubject) {
        studentsOfSubject.put(subject, new ArrayList<>(students));
    }

    public void addStudentToSubject(Student student, Subject subject, Map<Subject, List<Student>> studentsOfSubject) {
        studentsOfSubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject, Map<Subject, List<Student>> studentsOfSubject) {
        if (studentsOfSubject.containsKey(subject)) {
            studentsOfSubject.get(subject).remove(student);
        }
    }

    public void printAllSubjectsWithStudents(Map<Subject, List<Student>> studentsOfSubject) {
        for(Map.Entry<Subject, List<Student>> entry : studentsOfSubject.entrySet()){
            System.out.println("Subject: " + entry.getKey() + ", and his subjects: " + entry.getValue());
        }
    }
}
