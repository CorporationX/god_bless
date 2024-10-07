package Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class University {
    private final Map<String, List<Student>> groupsList = new HashMap<>();

    public University(List<Student> list) {
        groupmap(list);
    }

    public void groupmap(List<Student> students) {
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            groupsList.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
    }

    public void addstudent(Student student) {
        String key = student.getFaculty() + "-" + student.getYear();
        groupsList.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        showAllStudents(groupsList);
        System.out.println("");
    }

    public void delet(Student student) {
        String key = student.getFaculty() + "-" + student.getYear();
        if (groupsList.get(key).removeIf(student1 -> student1.equals(student))) {
            groupsList.remove(key);
        }
        System.out.println("");
        showAllStudents(groupsList);
    }

    public List<Student> searchStudent(String faculty, int year) {
        String key = faculty + "-" + year;
        return groupsList.get(key);
    }

    public void showAllStudents(Map<String, List<Student>> groupsList) {

        for (Map.Entry<String, List<Student>> group : groupsList.entrySet()) {
            Set<String> name = new HashSet<>();
            for(Student student:group.getValue()){
                name.add(student.getName());
            }
            System.out.println("Факультет и курс: " + group.getKey() + " name: " + name );
        }
    }
}