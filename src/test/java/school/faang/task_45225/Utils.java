package school.faang.task_45225;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static Map<Student, Map<Subject, Integer>> initSubjectsByStudent() {
        return new HashMap<>() {{
            put(new Student(1, "Vasya"), new HashMap<>() {{
                put(new Subject(1, "Math"), 5);
                put(new Subject(2, "Physics"), 4);
            }});
            put(new Student(2, "Petya"), new HashMap<>() {{
                put(new Subject(1, "Math"), 3);
                put(new Subject(3, "Russian"), 4);
                put(new Subject(4, "Literature"), 4);
            }});
            put(new Student(3, "Alina"), new HashMap<>() {{
                put(new Subject(1, "Math"), 5);
                put(new Subject(2, "Physics"), 5);
                put(new Subject(5, "Technology"), 5);
            }});
        }};
    }

    public static Map<Subject, List<Student>> initStudentsBySubject() {
        return new HashMap<>() {{
            put(new Subject(1, "Math"),
                    new ArrayList<>() {{
                        add(new Student(1, "Vasya"));
                        add(new Student(2, "Petya"));
                        add(new Student(3, "Alina"));
                    }});
            put(new Subject(2, "Physics"),
                    new ArrayList<>() {{
                        add(new Student(1, "Vasya"));
                        add(new Student(3, "Alina"));
                    }});
            put(new Subject(3, "Russian"),
                    new ArrayList<>() {{
                        add(new Student(2, "Petya"));
                    }});
            put(new Subject(4, "Literature"),
                    new ArrayList<>() {{
                        add(new Student(2, "Petya"));
                    }});
            put(new Subject(5, "Technology"),
                    new ArrayList<>() {{
                        add(new Student(3, "Alina"));
                    }});
        }};
    }
}
