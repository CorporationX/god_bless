package faang.school.godbless.electronic_diary;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentPerformanceServiceTest {

    private static final StudentPerformanceService SERVICE = new StudentPerformanceService();

    @Test
    void avgMarkForEachSubject() {
        Map<CourseType, Double> result = SERVICE.avgMarkForEachSubject(Main.getStudents());
        Map<CourseType, Double> expectedResult = Map.of(
                CourseType.LANGUAGE, 4.7272727272727275,
                CourseType.MUSIC, 3.0,
                CourseType.PE, 4.75,
                CourseType.MATH, 4.214285714285714
        );
        assertEquals(result, expectedResult);
    }

    @Test
    void findFinalMarksByStudent() {
        Map<CourseType, Integer> result = SERVICE.findFinalMarksByStudent(Main.getStudents(), "test5", "test5");
        Map<CourseType, Integer> expectedResult = Map.of(
                CourseType.MUSIC, 3,
                CourseType.LANGUAGE, 5,
                CourseType.MATH, 5
        );
        assertEquals(result, expectedResult);
    }

    @Test
    void getHardestSubject() {
        String result = SERVICE.getHardestSubject(Main.getStudents());
        assertEquals(result, "MUSIC");
    }
}