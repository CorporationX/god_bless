package school.faang.sprint1.task_45267.services;

import school.faang.sprint1.task_45267.entityes.Student;
import school.faang.sprint1.task_45267.entityes.Subject;
import school.faang.sprint1.task_45267.repositoryes.StudentRepository;
import school.faang.sprint1.task_45267.repositoryes.SubjectRepository;

import java.util.Map;
import java.util.Set;

public class MainService {
    StudentRepository studentRepository = new StudentRepository();
    SubjectRepository subjectRepository = new SubjectRepository();

    public void addStudentWithSubject(Student student, Map<Subject, Integer> subjects) {
        studentRepository.addStudent(student, subjects);
        subjectRepository.addSubject(student, subjects);
    }

    public boolean joinStudentAndSubject(Student student, Subject subject, Integer grade) {
        return studentRepository.addSubjectToStudent(student, subject, grade)
                && subjectRepository.addStudentToSubject(student, subject);
    }

    public boolean removeStudent(Student student) {
        Set<Subject> subjects = studentRepository.removeStudent(student);
        return subjectRepository.removeAllSubjectsByStudent(student, subjects);
    }

    public boolean removeStudentFromSubject(Student student, Subject subject) {
        return subjectRepository.removeStudentFromSubject(student, subject)
                && studentRepository.removeSubjectFromStudent(student, subject);

    }

    public void printAllStudentsAndSubjects() {
        subjectRepository.printAllSubjects();
        System.out.println("******");
        studentRepository.printAllStudents();
    }

}
