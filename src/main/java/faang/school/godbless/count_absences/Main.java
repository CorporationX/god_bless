package faang.school.godbless.count_absences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final Student STUDENT1
            = new Student("игорь", "информатика", 2001);
    private static final Student STUDENT2
            = new Student("Василий", "информатика", 2001);
    private static final Student STUDENT3
            = new Student("иван", "информатика", 2001);
    private static final Student STUDENT4
            = new Student("Григорий", "информатика", 2002);
    private static final Student STUDENT5
            = new Student("Евгений", "информатика", 2002);
    private static final Student STUDENT6
            = new Student("Николай", "информатика", 2002);
    private static final Student STUDENT7
            = new Student("Сергей", "Кибернетика", 2001);
    private static final Student STUDENT8
            = new Student("Никита", "Кибернетика", 2001);
    private static final Student STUDENT9
            = new Student("Семён", "Кибернетика", 2002);
    private static final Student STUDENT10
            = new Student("Александр", "Кибернетика", 2002);
    private static final ArrayList<Student> students
            = new ArrayList<>(List.of(STUDENT1, STUDENT2, STUDENT3,
            STUDENT4, STUDENT5, STUDENT6, STUDENT7, STUDENT8, STUDENT9, STUDENT10));

    public static void main(String[] args) {
        HashMap<Key, ArrayList<Student>> hashMap
                = Student.groupStudentsByFacultyAndYear(students);
        System.out.println(hashMap);
        System.out.println();
        Student.findStudentsByFacultyAndYear("Кибернетика", 2001, hashMap);

    }
}
