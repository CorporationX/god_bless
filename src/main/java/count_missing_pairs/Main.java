package count_missing_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
   public List<Student> students = new ArrayList<>();

   public Map<Map<String, Integer>, List<Student>> groupStudentsByFacultyAndYear(List<Student> listOfStudents) {
       Map<Map<String, Integer>, List<Student>> studentMap = new HashMap<>();

       for (Student student : listOfStudents) {
           Map<String, Integer> key = new HashMap<>();
           String faculty = student.getFaculty();
           int year = student.getYear();
           key.put(faculty,year);

           List<Student> students1 = studentMap.getOrDefault(key, new ArrayList<>());
           students1.add(student);

           studentMap.put(key, students);
       }

       return studentMap;
   }

   public List<Student> searchStudentsByFacultyAndYear(List<Student> students,String faculty, int year) {
       ArrayList<Student> result = new ArrayList<>();

       for (Student student : students) {
           if (student.getFaculty().equals(faculty) && student.getYear() == year) {
               result.add(student);
           }
       }

       return result;
   }

   public void addNewStudent(Student student) {
       students.add(student);
   }

   public void removeStudentBy(String name, String faculty, int year) {
       Student studentToRemove = new Student(name, faculty, year);
       for (Student student : students) {
           if (student.equals(studentToRemove)) {
               students.remove(student);
           } else {
               System.out.println("There is no such student");
           }
       }
   }
}
