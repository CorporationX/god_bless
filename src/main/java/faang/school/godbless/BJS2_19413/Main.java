package faang.school.godbless.BJS2_19413;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Student> studentList = new ArrayList<Student>();

    public static void main(String[] args) {
        studentList.add(new Student("Adam", "ART", 1));
        studentList.add(new Student("Lisa", "SEC", 3));
        studentList.add(new Student("Denis", "CS", 2));

        printStudentsGroupedByFacultyAndYearMap( getStudentsGruepedByFacultyAndYearMap(studentList) );
        System.out.println();

        addStudent(new Student("Albert", "ART", 3));
        addStudent(new Student("Jan", "ART", 4));
        addStudent(new Student("Nataliia", "CS", 2));

        printStudentsGroupedByFacultyAndYearMap( getStudentsGruepedByFacultyAndYearMap(studentList) );
        System.out.println();

        deleteStudentByNameAndFacultyAndYear("Albert", "ART", 35);

        printStudentsGroupedByFacultyAndYearMap( getStudentsGruepedByFacultyAndYearMap(studentList) );
        System.out.println();

        for(Student student : findStudentsByFacultyAndYearList("CS", 2)) {
            System.out.println(student);
        }

    }


    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void deleteStudentByNameAndFacultyAndYear(String name, String faculty, int year) {
        for (Student student : studentList) {
            Student tempStudent = new Student(name, faculty, year);
            if (tempStudent.equals(student)) {
                studentList.remove(student);
            }
        }
    }

    public static List<Student> findStudentsByFacultyAndYearList(String faculty, int year) {
        List<Student> finalStudentsList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                finalStudentsList.add(student);
            }
        }
        return finalStudentsList;
    }

    public static Map<YearAndFacultyMapKey, List<Student>> getStudentsGruepedByFacultyAndYearMap(List<Student> students) {
        Map<YearAndFacultyMapKey, List<Student>> studentsToFacultyMap = new HashMap<>();
        for (Student student : students) {
            YearAndFacultyMapKey yearAndFacultyMapKey = new YearAndFacultyMapKey(student.getFaculty(), student.getYear());

            if (studentsToFacultyMap.containsKey(yearAndFacultyMapKey)) {
                studentsToFacultyMap.get(yearAndFacultyMapKey).add(student);
            } else {
                studentsToFacultyMap.put(yearAndFacultyMapKey, new ArrayList<>());
                studentsToFacultyMap.get(yearAndFacultyMapKey).add(student);
            }

        }
        return studentsToFacultyMap;
    };

    public static void printStudentsGroupedByFacultyAndYearMap(Map<YearAndFacultyMapKey, List<Student>> map) {
        for (Map.Entry<YearAndFacultyMapKey, List<Student>> entry : map.entrySet()) {
            YearAndFacultyMapKey yearAndFacultyMapKey = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("-----------" + yearAndFacultyMapKey + "-----------");

            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
