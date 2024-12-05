package school.faang.task_45225;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> subjectsAndGrade = initSubjectsAndGradeByStudent();
        Map<Subject, List<Student>> students = initStudentsBySubject();
        StudentDatabase studentDatabase = new StudentDatabase(subjectsAndGrade, students);
        studentDatabase.addStudentWithSubjectsAndGrades(
                new Student(6, "Lila"),
                new HashMap<>() {{
                    put(new Subject(1, "Math"), 3);
                }}
        );
        studentDatabase.printAllStudentsWithSubjectsAndGrades();

        studentDatabase.addSubjectAndGradeForExistingStudent(new Student(1, "Vasya"), new Subject(6, "Sport"), 5);
        studentDatabase.printAllStudentsWithSubjectsAndGrades();

        studentDatabase.deleteStudentWithSubjectsAndGrades(new Student(1, "Vasya"));
        studentDatabase.printAllStudentsWithSubjectsAndGrades();

        studentDatabase.addSubjectWithStudents(new Subject(8, "English"), List.of(
                new Student(1, "Vasya"),
                new Student(2, "Petya"),
                new Student(3, "Alina")
        ));
        studentDatabase.printAllSubjectsWithStudents();
        studentDatabase.addStudentAtExistingSubject(new Student(6, "Katya"), new Subject(1, "Math"));
        studentDatabase.printAllSubjectsWithStudents();
        studentDatabase.deleteStudentAtSubject(new Student(1, "Vasya"), new Subject(1, "Math"));
        studentDatabase.printAllSubjectsWithStudents();
    }

    private static Map<Student, Map<Subject, Integer>> initSubjectsAndGradeByStudent() {
        return new HashMap<>() {{
                put(new Student(1, "Vasya"), new HashMap<>() {{
                        put(new Subject(1, "Math"), 5);
                        put(new Subject(2, "Physics"), 4);
                    }
                });
                put(new Student(2, "Petya"), new HashMap<>() {{
                        put(new Subject(1, "Math"), 3);
                        put(new Subject(3, "Russian"), 4);
                        put(new Subject(4, "Literature"), 4);
                    }
                });
                put(new Student(3, "Alina"), new HashMap<>() {{
                        put(new Subject(1, "Math"), 5);
                        put(new Subject(2, "Physics"), 5);
                        put(new Subject(5, "Technology"), 5);
                    }
                });
            }};
    }

    private static Map<Subject, List<Student>> initStudentsBySubject() {
        return new HashMap<>() {{
                put(new Subject(1, "Math"),
                        new ArrayList<>() {{
                            add(new Student(1, "Vasya"));
                            add(new Student(2, "Petya"));
                            add(new Student(3, "Alina"));
                        }
                    });
                put(new Subject(2, "Physics"),
                        new ArrayList<>() {{
                            add(new Student(1, "Vasya"));
                            add(new Student(3, "Alina"));
                        }
                    });
                put(new Subject(3, "Russian"),
                        new ArrayList<>() {{
                            add(new Student(2, "Petya"));
                        }
                    });
                put(new Subject(4, "Literature"),
                        new ArrayList<>() {{
                            add(new Student(2, "Petya"));
                        }
                    });
                put(new Subject(5, "Technology"),
                        new ArrayList<>() {{
                            add(new Student(3, "Alina"));
                        }
                    });
            }};
    }
}
