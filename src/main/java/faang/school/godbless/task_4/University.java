package faang.school.godbless.task_4;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@Getter
public class University {
    private final String faculty;
    private final String course;

    public University(String faculty, String course) {
        this.faculty = faculty;
        this.course = course;
    }

    public static Map<University, List<Student>> getUniversityMap(List<Student> students) {
        Map<University, List<Student>> mapStudentsOnCourse = new HashMap<>();
        List<Student> studentsOnCourse;
        for (Student st : students) {
            String faculty = st.getFaculty();
            String course = st.getCourse();
            University university = new University(faculty, course);
            studentsOnCourse = mapStudentsOnCourse.getOrDefault(university, new ArrayList<>());
            studentsOnCourse.add((st));
            mapStudentsOnCourse.put(university, studentsOnCourse);
        }
        return mapStudentsOnCourse;
    }

    @Override
    public String toString() {
        return "University{" +
                "faculty='" + faculty + '\'' +
                ", course='" + course + '\'' +
                '}' + '\n';
    }
}
