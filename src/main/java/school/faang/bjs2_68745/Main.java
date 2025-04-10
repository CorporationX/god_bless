package school.faang.bjs2_68745;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        database.addStudentDatabaseInfo("Иван", "Алгебра", 5);
        database.addStudentDatabaseInfo("Иван", "Алгебра", 5);
        database.addStudentDatabaseInfo("Иван", "Алгебра", 5);
        database.addStudentDatabaseInfo("Степан", "Алгебра", 5);
        database.addStudentDatabaseInfo("Степан", "Алгебра", 5);
        database.addStudentDatabaseInfo("Степан", "Алгебра", 5);
        database.addStudentDatabaseInfo("Иван", "Алгебра", 5);
        database.printAllStudents();
        database.printAllSubjects();
        database.removeStudent("Степан");
        database.printAllStudents();
    }
}
