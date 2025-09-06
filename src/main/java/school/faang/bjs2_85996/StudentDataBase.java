package school.faang.bjs2_85996;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDataBase {
    List<Student> listStudent = new ArrayList<>();
    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewStudent(String name, Map<Subject, Integer> mapRatings) {

        Student student = new Student(name);
        studentSubjects.put(student, mapRatings);
        listStudent.add(student);

        for (Map.Entry<Subject, Integer> entry : mapRatings.entrySet()) {
            Subject subject = entry.getKey();
            subjectStudents.computeIfAbsent(subject, arr -> new ArrayList<>()).add(student);
        }
    }

    public void addNewSubjectForStudent(String nameSub, String nameStudent, int rating) {

        Student student = listStudent.stream()
                .filter(st -> st.getName().equals(nameStudent))
                .findFirst()
                .orElse(null);
        Map<Subject, Integer> mapSubjectWithRatings = studentSubjects.get(student);
        Subject subject = new Subject(nameSub);
        mapSubjectWithRatings.put(subject, rating);

        subjectStudents.computeIfAbsent(subject, arr -> new ArrayList<>()).add(student);
    }

    public void removeStudent(String nameStudent) {

        Student student = listStudent.stream()
                .filter(st -> st.getName().equals(nameStudent))
                .findFirst()
                .orElse(null);
        studentSubjects.remove(student);

        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i).getName().equals(student.getName())) {
                    entry.getValue().remove(i);
                }
            }
        }
    }

    public void printAllStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentSubjects.entrySet()) {
            System.out.println(studentMapEntry);
        }
    }

    public void addNewSubject(String name, Map<Student, Integer> listStudent) {
        Subject subject = new Subject(name);

        subjectStudents.put(subject, listStudent.keySet().stream().toList());

        for (Map.Entry<Student, Integer> entry : listStudent.entrySet()) {
            Student student = entry.getKey();
            studentSubjects.computeIfAbsent(student, map -> new HashMap<>()).put(subject, entry.getValue());
        }
    }

    public void addStudentForSubject(Subject subject, Student student, int rating) {
        subjectStudents.computeIfAbsent(subject, arr -> new ArrayList<>()).add(student);

        Map<Subject, Integer> mapStudent = studentSubjects.get(student);
        mapStudent.put(subject, rating);
    }

    public void deleteStudent(Student student, Subject subject) {
        List<Student> listStudent = subjectStudents.get(subject);
        listStudent.remove(student);
        subjectStudents.put(subject, listStudent);

        Map<Subject, Integer> mapSubject = studentSubjects.get(student);
        mapSubject.remove(subject);
        studentSubjects.put(student, mapSubject);
    }

    public void printAllSubject() {
        System.out.println(subjectStudents);
    }
}
