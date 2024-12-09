package school.faang.task_45235;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentAndSubject(new Student(1, "Кирилл"), new Subject(1, "История"), 4);
        studentDatabase.addStudentAndSubject(new Student(1, "Кирилл"), new Subject(2, "Литература"), 3);
        studentDatabase.addStudentAndSubject(new Student(1, "Кирилл"), new Subject(3, "Геометрия"), 4);
        studentDatabase.addStudentAndSubject(new Student(1, "Кирилл"), new Subject(4, "Алгебра"), 5);
        studentDatabase.addStudentAndSubject(new Student(1, "Кирилл"), new Subject(5, "Физика"), 3);
        studentDatabase.addStudentAndSubject(new Student(2, "Дмитрий"), new Subject(1, "История"), 5);
        studentDatabase.addStudentAndSubject(new Student(2, "Дмитрий"), new Subject(1, "литература"), 5);
        studentDatabase.addStudentAndSubject(new Student(2, "Дмитрий"), new Subject(1, "Геометрия"), 3);
        studentDatabase.addStudentAndSubject(new Student(2, "Дмитрий"), new Subject(1, "Алгебра"), 3);

        studentDatabase.addSubject(new Student(2, "Дмитрий"), new Subject(5, "Физика"), 3);

        studentDatabase.removeStudent(new Student(1, "Кирилл"));

        studentDatabase.printStudent();

        studentDatabase.addSubjectStudent(new Subject(1, "Информатика"), new Student(3, "Валерий"));
        studentDatabase.addSubjectStudent(new Subject(2, "Биология"), new Student(3, "Валерий"));
        studentDatabase.addSubjectStudent(new Subject(3, "Обществознание"), new Student(3, "Валерий"));
        studentDatabase.addSubjectStudent(new Subject(2, "Биология"), new Student(4, "Ольга"));

        studentDatabase.addStudent(new Subject(2, "Биология"), new Student(5, "Евгений"));

        studentDatabase.removeStudentSubject(new Student(3, "Валерий"));

        studentDatabase.printStudentSubject();

    }
}
