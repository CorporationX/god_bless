package doble_cache;

import double_Cache.Student;
import double_Cache.StudentDatabase;
import double_Cache.Subject;
import double_Cache.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentDataBaseTest {

    @InjectMocks
    private StudentDatabase studentDataBase;

    @Mock
    private Validator validator;

    Student petr = new Student("Petr");
    Student kate = new Student("Kate");
    Student nina = new Student(null);
    Student oly = new Student(" ");
    Subject subject = new Subject("Math");
    Subject subject1 = new Subject("Eng");
    Subject subjectNull = new Subject(null);
    Map<Subject, List<Student>> subjectListMap = new HashMap<>();
    List<Student> studentList = new ArrayList<>();
    Map<Subject, Integer> subjectIntegerMap = new HashMap<>();
    Map<Student, Map<Subject, Integer>> studentMapMap = new HashMap<>();

    @Test
    public void TestAddAssessmentsStudents() {
        Integer grade = 5;
        doNothing().when(validator).checkGrade(grade);
        doNothing().when(validator).checkSaveMapMap(petr, subject, studentMapMap);

        studentDataBase.addAssessmentsStudents(petr, subject, grade, studentMapMap);
        Assertions.assertTrue(studentMapMap.containsKey(petr), "Должен содержать ключ Petr");
        Assertions.assertTrue(studentMapMap.get(petr).containsKey(subject), "Должен содержать ключ Math");
        Assertions.assertEquals(grade, studentMapMap.get(petr).get(subject), "Должен содержать оценку 5");
    }
    @Test
    public void testRemoveStudent(){
        subjectIntegerMap.put(subject,4);
        studentMapMap.put(petr,subjectIntegerMap);

        doNothing().when(validator).checkStudentIsBlank(petr);
        doNothing().when(validator).checkMapIsEmpty(studentMapMap);

        studentDataBase.removeStudent(petr,studentMapMap);
        verify(validator).checkRemoveMapStudents(petr,studentMapMap);
    }
}
