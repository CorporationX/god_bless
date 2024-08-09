package faang.school.godbless;


import lombok.Getter;
import java.util.*;

@Getter
import faang.school.godbless.david.User;
import java.util.*;

public class Application {
    private List<Student> students;

    public Application() {
        this.students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(String name, String faculty, int year) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getName().equals(name)
                    && student.getFaculty().equals(faculty)
                    && student.getYear() == year);
            iterator.remove();
            return true;
        }
        return false;
    }

    public List<Student> findStudent(String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if(student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }

    public HashMap<String, List<Student>> groupStudents() {
        HashMap<String, List<Student>> groupStudent = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            if(!groupStudent.containsKey(key)) {
                groupStudent.put(key, new ArrayList<>());
            }
            groupStudent.get(key).add(student);
        }
        return groupStudent;
    }

    public void printGroupStudents() {
        HashMap<String, List<Student>> grouped = groupStudents();
        for (Map.Entry<String, List<Student>> entry : grouped.entrySet()) {
            System.out.println("Faculty-Course: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(" " + student);
            }
        }
    }

    public static void main(String[] args) {
        Application app = new Application();

        app.addStudent(new Student("Bob", "Science", 1));
        app.addStudent(new Student("John", "Science", 2));
        app.addStudent(new Student("David", "Mathematics", 1));
        app.addStudent(new Student("Elena", "Physics", 3));
        app.addStudent(new Student("Konst", "Science", 1));

        System.out.println("The initial list of students:");
        app.printGroupStudents();

        app.removeStudent("Bob", "Science", 2);
        System.out.println("The list after the removed");
        app.printGroupStudents();

        List<Student> infoFirstYear = app.findStudent("Science", 1);
        System.out.println("1st year students of Computer Science:");
        for (Student student : infoFirstYear) {
            System.out.println(student);
        }

        app.addStudent(new Student("David", "Mathematics", 2));
        System.out.println("The list after adding a new student:");
        app.printGroupStudents();
}
