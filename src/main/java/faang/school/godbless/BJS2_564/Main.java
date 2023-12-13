package faang.school.godbless.BJS2_564;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Rauan", "MCM", 1));
        listOfStudents.add(new Student("Vova", "CI", 4));
        listOfStudents.add(new Student("Nariman", "SIS", 2));

        addStudent(listOfStudents, new Student("Alinur", "MCM", 1));

        deleteStudent(listOfStudents, "Rauan", "MCM", 1);

        System.out.println(sortStudent(listOfStudents));
        System.out.println(findStudent(listOfStudents, "CI", 4));

    }

    public static HashMap<String, List<Student>> sortStudent(List<Student> listOfStudents) {
        HashMap<String, List<Student>> result = new HashMap<>();
        String[] key = new String[2];
        for (Student s : listOfStudents) {
            key[0] = s.getFaculty();
            key[1] = Integer.toString(s.getCourse());
            String keyy = key[0] + key[1];
            List<Student> value = result.getOrDefault(keyy, new ArrayList<>());
            value.add(s);
            result.put(keyy, value);
        }
        return result;
    }

    public static List<Student> addStudent(List<Student> list, Student student) {
        list.add(student);
        return list;
    }

    public static List<Student> deleteStudent(List<Student> list, String name, String faculty, int course) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getName().equals(name) && s.getFaculty().equals(faculty) && s.getCourse() == course) {
                iterator.remove();
            }
        }
        return list;
    }

    public static String findStudent(List<Student> list, String faculty, int course) {
        for (Student s : list) {
            if (s.getFaculty().equals(faculty) && s.getCourse() == course) {
                return s.getName();
            }
        }
        return "There are no student with this faculty and course";
    }
}


