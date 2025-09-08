package school.faang.bjs2_85996;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Subject sub1 = new Subject("sub1");
        Subject sub2 = new Subject("sub2");
        Subject sub3 = new Subject("sub3");

        Map<Subject, Integer> studentMapIlya = new HashMap<>();
        studentMapIlya.put(sub1, 5);
        studentMapIlya.put(sub3, 5);
        studentMapIlya.put(sub2, 5);
        StudentDataBase studentDataBase = new StudentDataBase();
        studentDataBase.addNewStudent("iLya", studentMapIlya);

        Subject sub4 = new Subject("sub4");
        Subject sub5 = new Subject("sub5");
        Map<Subject, Integer> studentMapDima = new HashMap<>();
        studentMapDima.put(sub1, 5);
        studentMapDima.put(sub4, 3);
        studentMapDima.put(sub5, 4);
        studentDataBase.addNewStudent("Dima", studentMapDima);

        Map<Subject, Integer> studentMapGrisha = new HashMap<>();
        studentMapGrisha.put(sub1, 5);
        studentMapGrisha.put(sub2, 3);
        studentMapGrisha.put(sub5, 3);
        studentDataBase.addNewStudent("Grisha", studentMapGrisha);

        Map<Subject, Integer> studentMapVitalya = new HashMap<>();
        studentMapVitalya.put(sub3, 4);
        studentMapVitalya.put(sub5, 5);
        studentMapVitalya.put(sub2, 3);
        studentDataBase.addNewStudent("Vitalya", studentMapVitalya);

        studentDataBase.printAllStudent();

        studentDataBase.addNewSubjectForStudent("sub6", 3, 4);

        studentDataBase.printAllStudent();

        studentDataBase.removeStudent(3);

        studentDataBase.printAllStudent();

        System.out.println();
        Map<Integer, Integer> listStudentForSub = new HashMap<>();
        listStudentForSub.put(1, 3);
        listStudentForSub.put(3, 3);
        studentDataBase.addNewSubject("sub7", listStudentForSub);

        studentDataBase.printAllSubject();

        studentDataBase.addStudentForSubject(sub1, 3, 4);

        studentDataBase.printAllSubject();

        studentDataBase.deleteStudent(3, sub1);

        studentDataBase.printAllSubject();

    }
}
