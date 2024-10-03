package school.faang.countingAbsenteeism;

import java.util.*;

public class Institute {

    LinkedList<Student> students = new LinkedList<>();

    private Map<FacultyInfo, List<Student>> listToMap(List<Student> students) {
        Map<FacultyInfo, List<Student>> map = new HashMap<>();

        for (Student student : students) {
            if (map.containsKey(new FacultyInfo(student.getFaculty(), student.getYear()))) {
                map.get(new FacultyInfo(student.getFaculty(), student.getYear())).add(student);
            } else {
                map.put(new FacultyInfo(student.getFaculty(), student.getYear()), new ArrayList<>());
                map.get(new FacultyInfo(student.getFaculty(), student.getYear())).add(student);
            }
        }
        return map;
    }

    public void addNewStudent(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public void removeStudent(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public String showStudentsByFacultyAndYear(String faculty, int year) {
        Map<FacultyInfo, List<Student>> map = listToMap(students);

        StringBuilder sb = new StringBuilder();
        sb.append(faculty);
        sb.append("::");
        sb.append(year);
        sb.append(" -> ");
        sb.append("\n");
        for (Student student : map.get(new FacultyInfo(faculty, year))) {
            sb.append(student.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public String showAllStudentsByFacultyAndYear() {
        Map<FacultyInfo, List<Student>> map = listToMap(students);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<FacultyInfo, List<Student>> entry : map.entrySet()) {

            sb.append(showStudentsByFacultyAndYear(entry.getKey().getFaculty(), entry.getKey().getYear()));
            sb.append("\n");

        }

        return sb.toString();
    }


}

