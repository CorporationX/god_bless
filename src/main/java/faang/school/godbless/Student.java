package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Student {
    private String name;
    private String faculty;
    private Long year;
    private List<Student> students = new ArrayList<>();

    public Student(String name, String faculty, Long year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public void addNewStudentList(Student student) {
        students.add(student);
//        return students;
    }

    public void helpDeleteStudent(String name, String faculty, Long year) {
        for (Student s : students) {
            if (s.name.equals(name) && s.faculty.equals(faculty) && s.year.equals(year)) {
                helpDeleteStudent(s);
                break;
            }

        }
    }

    public void helpDeleteStudent(Student student) {
        students.remove(student);
    }

    // Возможно перемудрил, могу написать через for
    public List<Student> findStudent(String faculty, Long year) {
        List<Student> studentList = new ArrayList<>();
        if (faculty == null) {
            studentList = students.stream()
                    .filter(a -> a.year.equals(year))
                    .collect(Collectors.toList());
            return studentList;
        }
        if (year == null) {
            studentList = students.stream()
                    .filter(a -> a.faculty.equals(faculty))
                    .collect(Collectors.toList());
            return studentList;
        } else {
            studentList = students.stream()
                    .filter(a -> a.year.equals(year))
                    .filter(a -> a.faculty.equals(faculty))
                    .collect(Collectors.toList());
            return studentList;
        }
    }

    public List<Student> sortedStudent(String faculty, Long year) {
        List<Student> studentList = new ArrayList<>();
        if (faculty == null) {
            studentList = students.stream()
                    .sorted(Comparator.comparingLong(Student::getYear))
                    .collect(Collectors.toList());
            return studentList;
        }
        if (year == null) {
            studentList = students.stream()
                    .sorted(Comparator.comparing(Student::getFaculty))
                    .collect(Collectors.toList());
            return studentList;
        } else {
            studentList = students.stream()
                    .sorted(Comparator.comparing(Student::getFaculty))
                    .sorted(Comparator.comparingLong(Student::getYear))
                    .collect(Collectors.toList());
            return studentList;
        }
    }

    // ну тут капец как сложно, если есть вариант проще, то напиши пожалуйста(хочу знать)
    public HashMap<String, List<Student>> groupStudent(List<Student> studentsList) {
        HashMap<String, List<Student>> studentGroupMap = new HashMap<>();
        for(Student s: studentsList){
                if (studentGroupMap.containsKey((s.faculty + (s.year)))) {
                    studentGroupMap.get(s.faculty + (s.year).toString()).add(s);
                } else {
                    List<Student> newList = new ArrayList<>();
                    newList.add(s);
                    studentGroupMap.put(s.faculty + (s.year).toString(), newList);
                }
//            }
        }
        return studentGroupMap;
    }


}
