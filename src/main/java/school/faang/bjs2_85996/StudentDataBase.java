package school.faang.bjs2_85996;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class StudentDataBase {
    List<Student> listStudent = new ArrayList<>();
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();
    AtomicCounter atomicCounter = new AtomicCounter();

    public void addNewStudent(String name, Map<Subject, Integer> mapRatings) {

        Student student = new Student(atomicCounter.incrementIdStudent(), name);
        studentSubjects.put(student, mapRatings);
        listStudent.add(student);

        for (Subject entry : mapRatings.keySet()) {
            subjectStudents.computeIfAbsent(entry, arr -> new ArrayList<>()).add(student);
        }
    }

    public void addNewSubjectForStudent(String nameSub, int idStudent, int rating) {

        Student student = searchByNameStudent(idStudent).orElseThrow();

        Map<Subject, Integer> mapSubjectWithRatings = studentSubjects.get(student);
        Subject subject = new Subject(nameSub);
        mapSubjectWithRatings.put(subject, rating);
        subjectStudents.computeIfAbsent(subject, arr -> new ArrayList<>()).add(student);
    }

    public void removeStudent(int idStudent) {

        Student student = searchByNameStudent(idStudent).orElseThrow();

        studentSubjects.remove(student);
        if (listStudent.contains(student)) {
            studentSubjects.remove(student);
        }
        Iterator<Map.Entry<Subject, List<Student>>> entryIterator = subjectStudents.entrySet().iterator();

        while (entryIterator.hasNext()) {
            List<Student> removeListStudent = entryIterator.next().getValue();
            removeListStudent.remove(student);
        }
    }

    public Optional<Student> searchByNameStudent(int idStudent) {
        return listStudent.stream()
                .filter(st -> Objects.equals(st.getId(), idStudent))
                .findFirst();
    }

    public void printAllStudent() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentSubjects.entrySet()) {
            System.out.println(studentMapEntry);
        }
    }

    public void addNewSubject(String nameSub, Map<Integer, Integer> mapStudentWithRating) {
        Subject subject = new Subject(nameSub);
        Map<Student, Integer> students = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : mapStudentWithRating.entrySet()) {
            Student student = searchByNameStudent(entry.getKey()).orElseThrow();
            ;
            students.put(student, entry.getValue());
        }
        subjectStudents.put(subject, students.keySet().stream().toList());

        for (Map.Entry<Student, Integer> entry : students.entrySet()) {
            Student student = entry.getKey();
            studentSubjects.computeIfAbsent(student, map -> new HashMap<>()).put(subject, entry.getValue());
        }
    }

    public void addStudentForSubject(Subject subject, int idStudent, int rating) {

        Student student = searchByNameStudent(idStudent).orElseThrow();
        ;

        if (subjectStudents.get(subject).contains(student)) {
            System.out.println("student have");
        } else {
            subjectStudents.computeIfAbsent(subject, arr -> new ArrayList<>()).add(student);

            Map<Subject, Integer> mapStudent = studentSubjects.get(student);
            mapStudent.put(subject, rating);
        }

    }

    public void deleteStudent(int idStudent, Subject subject) {

        Student student = searchByNameStudent(idStudent).orElseThrow();
        if (!subjectStudents.get(subject).contains(student)) {
            System.out.println("student  haven't!!!!!");
            return;
        }


        List<Student> listStudent = subjectStudents.get(subject);
        listStudent.remove(student);

        Map<Subject, Integer> mapSubject = studentSubjects.get(student);
        mapSubject.remove(subject);
    }

    public void printAllSubject() {
        System.out.println(subjectStudents);
    }
}
