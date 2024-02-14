package faang.school.godbless;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String... args) {
        Student student = new Student("Test1", "IST", 1l);
        Student student2 = new Student("Test2", "IST", 2l);
        Student student3 = new Student("Test3", "IST", 3l);
        Student student4 = new Student("Test4", "IVT", 1l);
        Student student5 = new Student("Test5", "IVT", 2l);
        Student student6 = new Student("Test6", "IVT", 3l);
        Student student7 = new Student("Test7", "IST", 1l);

        student.addNewStudentList(student);
        student.addNewStudentList(student2);
        student.addNewStudentList(student3);
        student.addNewStudentList(student4);
        student.addNewStudentList(student5);
        student.addNewStudentList(student6);
        student.addNewStudentList(student7);

        student.helpDeleteStudent("Test1", "IST", 1L);

        List<Student> list = student.findStudent("IST", null);
        List<Student> list2 = student.sortedStudent("IST", null);
        HashMap<String, List<Student>> map = student.groupStudent(list2);
        System.out.println(student.getStudents());

    }

//    static final HashMap<String, List<Student>> getStudentMap(List<Student> students){
//        HashMap<String, List<Student>> mapStudent  = new HashMap<>();
//        List<Student> studentList = new ArrayList<>();
//        for(Student s : students){
//
//
//            mapStudent.put(s.getFaculty()+s.getYear(), studentList.add(s));
//        }
//
//
//        return null;
//    }


}
