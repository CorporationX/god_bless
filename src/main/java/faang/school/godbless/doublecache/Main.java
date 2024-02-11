package faang.school.godbless.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Student, Map<Subject, Integer>> studentsMarksBySubjects = new HashMap<>();
    static Map<Subject, List<Student>> studentByEachSubject = new HashMap<>();
    public static void main(String[] args) {

    }
    public static void addNewStudent(Student student, Map<Subject, Integer> marks){
        studentsMarksBySubjects.put(student, marks);
    }
    public static void addNewSubjectForExistingStudent(Student student, Subject subject, Integer mark){
        studentsMarksBySubjects.get(student).put(subject, mark);
    }
    public static void deleteStudent(Student student){
        studentsMarksBySubjects.remove(student);
    }
    public static void listStudentsAndMarks(){
        System.out.println(studentByEachSubject);
    }
    public static void addSubjectAndStudents(Subject subject, List<Student> students){
        studentByEachSubject.put(subject, students);
    }
    public static void addStudentToSubject(Subject subject, Student student){
        studentByEachSubject.get(subject).add(student);
    }
    public static void deleteStudentFromSubject(Subject subject , Student student){
        studentByEachSubject.get(subject).remove(student);
    }
    public static void listStudentsAndSubjects(){
        System.out.println(studentByEachSubject);
    }

}
//добавление нового студента и его предметов с оценками;
// добавление нового предмета для существующего студента с оценкой;
// удаление студента и его предметов с оценками;
// вывод списка всех студентов и их оценок по предметам.


//Реализуйте методы для работы со второй HashMap: добавление нового предмета и списка студентов, изучающих его;
// добавление студента к существующему предмету;
// удаление студента из предмета;
// вывод списка всех предметов и студентов, изучающих их.

