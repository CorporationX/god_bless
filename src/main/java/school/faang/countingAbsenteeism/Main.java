package school.faang.countingAbsenteeism;

public class Main {
  public static void main(String[] args) {

    StudentsService institute = new StudentsService();

    institute.addNewStudent("Nikita", "FITKB", 4);
    institute.addNewStudent("Katia", "FITKB", 4);
    institute.addNewStudent("Maria", "FITKB", 4);
    institute.addNewStudent("Timur", "FITKB", 4);

    institute.addNewStudent("Maxim", "QWE", 3);
    institute.addNewStudent("Alex", "QWE", 3);
    institute.addNewStudent("Tuc", "QWE", 3);
    institute.addNewStudent("Volt", "QWE", 3);

    institute.addNewStudent("Monster", "ZXC", 3);
    institute.addNewStudent("Gorilla", "ZXC", 3);
    institute.addNewStudent("Burn", "ZXC", 3);
    institute.addNewStudent("RedBul", "ZXC", 3);

    System.out.println("show \"QWE\"::\"3\" \n" + institute.showStudentsByFacultyAndYear("QWE", 3));
    System.out.println("show all students \n" + institute.showAllStudentsByFacultyAndYear());

    institute.removeStudent("Tuc", "QWE", 3);

    System.out.println("show all students \n" + institute.showAllStudentsByFacultyAndYear());
    System.out.println("show \"QWE\"::\"3\" \n" + institute.showStudentsByFacultyAndYear("QWE", 3));

  }
}
