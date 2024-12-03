package school.faang.cash_cash_45217;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    HashMap<Student, Map<Subject, Integer>> students;
    HashMap<Subject, List<Student>> subject;

    public StudentDatabase(HashMap<Subject, List<Student>> subject, HashMap<Student, Map<Subject, Integer>> students) {
        this.subject = subject;
        this.students = students;
    }

    public void addStudent(Student student, Map<Subject, Integer> subjects){
        students.put(student, subjects);
        for (Subject subject : subjects.keySet()){
            this.subject.putIfAbsent(subject, new ArrayList<>());
            this.subject.get(subject).add(student);
        }
    }
    
}


