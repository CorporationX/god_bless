package doubleCache;

import java.util.HashMap;
import java.util.Map;

public class Grade {
    private Map<Subject, Integer> grades = new HashMap<>();

    public void addGrade(Subject subject, int grade) {
        grades.put(subject, grade);
    }

    public int getGrade(Subject subject) {
        return grades.get(subject);
    }

    public Map<Subject, Integer> getAllGrades() {
        return grades;
    }
}
