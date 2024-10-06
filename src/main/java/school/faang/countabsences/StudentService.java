package school.faang.countabsences;

import java.util.*;

public class StudentService {

    public Map<Group, List<Student>> createGroups(List<Student> students){
        Map<Group, List<Student>> groups = new HashMap<>();

        for(Student s : students){
            Group group = new Group(s.getFaculty(), s.getYear());
            groups.putIfAbsent(group, new ArrayList<>());
            groups.get(group).add(s);
        }

        return groups;
    }

    public void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public void removeStudent(List<Student> students, Student student) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student currentStudent = iterator.next();
            if (Objects.equals(currentStudent.getName(), student.getName()) &&
                    Objects.equals(currentStudent.getFaculty(), student.getFaculty()) &&
                    Objects.equals(currentStudent.getYear(), student.getYear())) {

                iterator.remove();

                break;
            }
        }
    }

    public List<Student> findStudentsByFacultyAndYear(List<Student> students, Group group) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(group.getFaculty()) && student.getYear().equals(group.getYear())) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

}
