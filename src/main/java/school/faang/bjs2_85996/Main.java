package school.faang.bjs2_85996;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDataBase studentDataBase = new StudentDataBase();

        Subject sub1 = new Subject("sub1");
        Subject sub2 = new Subject("sub2");
        Subject sub3 = new Subject("sub3");
        Subject sub4 = new Subject("sub4");
        Subject sub5 = new Subject("sub5");

        Map<Subject, Integer> studentMapIlya = new HashMap<>();
        studentMapIlya.put(sub1, 5);
        studentMapIlya.put(sub3, 5);
        studentMapIlya.put(sub2, 5);
        studentDataBase.addNewStudent("iLya", studentMapIlya);

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
        studentMapVitalya.put(sub4, 4);
        studentMapVitalya.put(sub5, 5);
        studentMapVitalya.put(sub2, 3);
        studentDataBase.addNewStudent("Vitalya", studentMapVitalya);

        studentDataBase.printAllStudent();

        studentDataBase.addNewSubjectForStudent("sub6","Grisha",4  );

        studentDataBase.printAllStudent();

        studentDataBase.removeStudent("Grisha");

        studentDataBase.printAllStudent();

    }
}
