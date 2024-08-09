package faang.school.godbless.absent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final List<Student> studentsList = new ArrayList<>();

    public Main() {
        studentsList.add(new Student("name1","faculty1","2001"));
        studentsList.add(new Student("name2","faculty1","2001"));
        studentsList.add(new Student("name3","faculty2","2002"));
        studentsList.add(new Student("name4","faculty2","2002"));
        studentsList.add(new Student("name5","faculty2","2002"));
        studentsList.add(new Student("name6","faculty3","2003"));
        studentsList.add(new Student("name7","faculty3","2003"));
        studentsList.add(new Student("name8","faculty3","2003"));
        studentsList.add(new Student("name9","faculty3","2003"));
    }

    public Map<String, List<Student>> groupStudents() {
        Map<String, List<Student>> resultMap = new HashMap<>();

        for (Student student : studentsList) {
            String mapKey = student.getFaculty() + "@" + student.getYear();

            if (!resultMap.containsKey(mapKey)) {
                resultMap.put(mapKey, new ArrayList<>());
            }

            resultMap.get(mapKey).add(student);
        }

        return resultMap;
    }

    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public void delStudent(String name, String faculty, String year) {
        studentsList.remove(new Student(name, faculty, year));
    }

    public boolean checkStudentExist(String name, String faculty, String year) {
        return studentsList.contains(new Student(name, faculty, year));
    }

    public int studentsQuantity() {
        return studentsList.size();
    }

    public List<Student> searchStudents(String faculty, String year) {
        return groupStudents().get(faculty + "@" + year);
    }
}
