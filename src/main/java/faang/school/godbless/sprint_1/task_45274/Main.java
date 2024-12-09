package faang.school.godbless.sprint_1.task_45274;

public class Main {
    private static final StudentDatabase STUDENT_DATABASE = new StudentDatabase();

    public static final Student STUDENT_1 = new Student(1, "Olga");
    public static final Student STUDENT_2 = new Student(2, "Nikolay");
    public static final Student STUDENT_3 = new Student(3, "Irina");

    public static final Subject SUBJECT_1 = new Subject(1, "English");
    public static final Subject SUBJECT_2 = new Subject(3, "Literature");

    public static void main(String[] args) {
        STUDENT_DATABASE.addingNewStudentAndHisSubjectsWithGrades(STUDENT_1, SUBJECT_1, 3);
        STUDENT_DATABASE.addingNewStudentAndHisSubjectsWithGrades(STUDENT_2, SUBJECT_2, 5);
        STUDENT_DATABASE.addingNewStudentAndHisSubjectsWithGrades(STUDENT_3, SUBJECT_2, 4);

        STUDENT_DATABASE.displayListOfAllStudentsAndTheirGradesInSubjects();
        System.out.println("---------------------------");
        STUDENT_DATABASE.displayListAllSubjectsAndStudentsStudyingThem();
    }
}
