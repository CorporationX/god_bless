package faang.school.godbless.BJS2_8349;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private List<Student> studentList = new ArrayList<>();
    private InputValidation inputValidation = new InputValidation();

    public Main() {
        studentList.add(new Student("stud1", "IT", 2));
        studentList.add(new Student("stud2", "Art", 1));
        studentList.add(new Student("stud3", "Sport", 4));
        studentList.add(new Student("stud4", "Art", 1));
        studentList.add(new Student("stud5", "IT", 2));
    }


    public void addNewStudent(String name, String faculty, int year) {
        inputValidation.checkInputValueStudent(name, faculty, year);

        Student newStudent = createStudent(name, faculty, year);
        inputValidation.checkExistStudentInList(newStudent, studentList);

        studentList.add(newStudent);

    }

    //удаление студента из списка по его имени, факультету и курсу;
    public void deleteStudent(String name, String faculty, int year) {
        inputValidation.checkInputValueStudent(name, faculty, year);

        Student newStudent = createStudent(name, faculty, year);
        inputValidation.checkExistStudentInList(newStudent, studentList);

        studentList.add(newStudent);

    }

    public HashMap<String, List<Student>> findAllStudentsByCourse(List<Student> students) {
        inputValidation.checkInputListOfStudentsIsNull(students);

        HashMap<String, List<Student>> finalListOfStudents = new HashMap<>();

        for (Student student : students) {
            finalListOfStudents.computeIfAbsent(student.getFaculty() + student.getYear(), k -> new ArrayList<>()).add(student);
        }

        return finalListOfStudents;
    }

    private Student createStudent(String name, String faculty, int year) {
        return new Student(name, faculty, year);
    }

    private void printMap(HashMap<String, List<Student>> students) {
        students.forEach((k, v) -> System.out.println("Факультет и год: " + k + "\n" + "Студент: " + v));
    }
}
