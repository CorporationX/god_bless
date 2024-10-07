package school.faang.doublecashe;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECT_GRADE = new HashMap<>();
    public static final Map<Subject, List<Student>> SUBJECT_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Service service = new Service();
        Student student1 = new Student(1, "Максим");
        Student student2 = new Student(2, "Маша");
        Student student3 = new Student(3, "Виктория");
        Student student4 = new Student(4, "Даща");
        Subject subject = new Subject(1, "русский язык");
        Subject subject2 = new Subject(2, "английский язык");
        Subject subject3 = new Subject(3, "математика");
        service.addNewSubject(student3, subject, 4);
        service.addNewSubject(student2, subject2, 5);
        service.addNewSubject(student2, subject3, 3);
        System.out.println("Студенты с оценками");
        service.printAllStudent();
        System.out.println("Предметы с оценками");
        service.printListSubjectAndStudent();
        service.removeStudent(student2);
        System.out.println("После удаление ");
        service.printAllStudent();
        service.printListSubjectAndStudent();
    }
}
