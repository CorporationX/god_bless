package school.faang.HashMaps.doubleCache;

import java.util.ArrayList;
import java.util.HashMap;

import static school.faang.HashMaps.doubleCache.service.StudentAndSubjectAction.addStudentToSubject;
import static school.faang.HashMaps.doubleCache.service.StudentAndSubjectAction.addStudentWithSubject;
import static school.faang.HashMaps.doubleCache.service.StudentAndSubjectAction.addSubject;
import static school.faang.HashMaps.doubleCache.service.StudentAndSubjectAction.addSubjectForStudent;
import static school.faang.HashMaps.doubleCache.service.StudentAndSubjectAction.printStudents;
import static school.faang.HashMaps.doubleCache.service.StudentAndSubjectAction.printSubjects;
import static school.faang.HashMaps.doubleCache.service.StudentAndSubjectAction.removeStudent;
import static school.faang.HashMaps.doubleCache.service.StudentAndSubjectAction.removeStudentFromSubject;

public class Main {
    public static void main(String[] args) {
        Subject math = new Subject("Math", 1);
        Subject english = new Subject("English", 2);
        Subject history = new Subject("History", 3);
        Subject lithography = new Subject("Lithography", 4);

        Student student1 = new Student("Sergey", 1);
        Student student2 = new Student("John", 2);
        Student student3 = new Student("Andrey", 3);

        addStudentWithSubject(student1, new HashMap<>() {{
            put(math, 5);
            put(english, 4);
            put(history, 3);
        }});
        addStudentWithSubject(student2, new HashMap<>() {{
            put(math, 5);
            put(english, 5);
            put(history, 3);
        }});
        addStudentWithSubject(student3, new HashMap<>() {{
            put(english, 4);
            put(history, 3);
        }});
        addSubjectForStudent(lithography, student1);
        removeStudent(student3);
        printStudents();

        addSubject(new Subject("Psyhology", 5), new ArrayList<>() {{
            add(student1);
            add(student2);
        }});

        addStudentToSubject(math, student3);
        removeStudentFromSubject(math, student1);
        printSubjects();
    }
}
