package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
class Student {
    private String name;
    private String faculty;
    private int year;

    @Override
    public String toString() {
        return "Name: " + name + ", Faculty: " + faculty + ", Year: " + year;
    }

}

class Main {
    private List<Student> students;

    public Main() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deliteStudent(String name, String faculty, int year) {
        List<Student> deliteStudent = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name) &&
                    student.getFaculty().equals(faculty) &&
                    student.getYear() == year) {
                deliteStudent.add(student);
            }
        }
        students.removeAll(deliteStudent);
    }

    public List<Student> searchStudent(String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }


    public Map<String, List<Student>> groupedStudentsByFacultyAndYear() {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + student.getYear();
            List group = groupedStudents.get(key);
            if (group == null) {
                group = new ArrayList<>();
                groupedStudents.put(key, group);
            }
            group.add(student);
        }
        return groupedStudents;
    }

    public static void main(String[] args) {
        Main mains = new Main();

        mains.addStudent(new Student("John", "Computer Science", 2));
        mains.addStudent(new Student("Emily", "Mathematics", 1));
        mains.addStudent(new Student("Michael", "Physics", 1));
        mains.addStudent(new Student("Sophia", "Chemistry", 2));
        mains.addStudent(new Student("William", "Biology", 2));
        mains.addStudent(new Student("Olivia", "Computer Science", 1));
        mains.addStudent(new Student("James", "Mathematics", 2));
        mains.addStudent(new Student("Ava", "Physics", 1));
        mains.addStudent(new Student("Benjamin", "Chemistry", 1));
        mains.addStudent(new Student("Mia", "Biology", 2));

        mains.deliteStudent("John", "Computer Science", 2);

        List<Student> searchingStudent = mains.searchStudent("Mathematics", 2);
        System.out.println("Search Result:");
        for (Student student : searchingStudent) {
            System.out.println(student);
        }
        System.out.println();

        Map<String, List<Student>> groupedStudents = mains.groupedStudentsByFacultyAndYear();
        System.out.println("Grouped students:");
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }
    }


}



