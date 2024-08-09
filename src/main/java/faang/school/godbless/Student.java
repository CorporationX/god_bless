package faang.school.godbless;

import java.util.*;

public class Student {
    String name;
    String faculty;
    int year;

    public Student(String name, String faculty, int year){
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public static Map<String, List<Student>> findTargetStudents (List<Student> students){
        Set<String> allStudyGroups = new HashSet<>();
        List<Student> studentOfCurrentCourse = new ArrayList<>();
        String tempGroup;
        Map <String, List<Student>> targetTable = new HashMap<>();
        for(Student currentStudent : students){ // создание сета неповторяющихся курсов
            tempGroup = currentStudent.faculty + " " + Integer.toString(currentStudent.year);
            allStudyGroups.add(tempGroup);
        }
        for(String currentCourse : allStudyGroups){
            for(Student currentStudent : students){
                if(currentCourse.equals(currentStudent.faculty + " " + Integer.toString(currentStudent.year))){ //
                    studentOfCurrentCourse.add(currentStudent);
                }
                targetTable.put(currentCourse, studentOfCurrentCourse);
            }
        }
        return targetTable;
    }
}
