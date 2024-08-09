package faang.school.godbless.countAbsencesTest;

import faang.school.godbless.countAbsences.Faculty;
import faang.school.godbless.countAbsences.PairKey;
import faang.school.godbless.countAbsences.Student;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.countAbsences.Faculty.MapOfStudentsByFacultiesAndYears;

public class countAbsences {
    private Faculty faculty1;
    private Faculty faculty2;
    private Faculty faculty3;
    private Student std1;
    private Student std2;
    private Student std3;
    private Student std4;
    private Student std5;
    @BeforeEach
    public void setUp(){
        faculty1 = new Faculty("MachineLearning");
        faculty2 = new Faculty("IT");
        faculty3 = new Faculty("BT");
        std1 = new Student("Yen",faculty1,1);
        std2 = new Student("Den",faculty1,1);
        std3 = new Student("Ben",faculty2,1);
        std4 = new Student("Ren",faculty2,2);
        std5 = new Student("Ten",faculty3,3);

    }

    @Test
    public void test_countAbsences(){
        List<Student> students = new ArrayList<>();
        students.add(std1);
        students.add(std2);
        students.add(std3);
        students.add(std4);
        students.add(std5);
        Map<PairKey<Faculty,Integer>, List<Student>> mapStudents = MapOfStudentsByFacultiesAndYears(students);
        // Проверка содержимого Map
        assertEquals(2, mapStudents.get(new PairKey<>(faculty1, 1)).size());
        assertEquals(1, mapStudents.get(new PairKey<>(faculty2, 1)).size());
        assertEquals(1, mapStudents.get(new PairKey<>(faculty2, 2)).size());
        assertEquals(1, mapStudents.get(new PairKey<>(faculty3, 3)).size());

        // Проверка конкретного студента
        assertTrue(mapStudents.get(new PairKey<>(faculty1, 1)).contains(std1));
        assertTrue(mapStudents.get(new PairKey<>(faculty2, 1)).contains(std3));
    }



}
