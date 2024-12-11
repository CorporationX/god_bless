package school.faang.task_45249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    HashMap<Student, Map<Subject, Integer>> studentGrades = Main.getStudentGrades();
    HashMap<Subject, List<Student>> subjectStudents = Main.subjectStudents;


    //    Добавление нового студента и его предметов с оценками
    public void addStudentWithGrades(Student stud, Map<Subject, Integer> grades) {
        studentGrades.put(stud, grades);

        for (Subject sub : grades.keySet()) {
            subjectStudents.putIfAbsent(sub, new ArrayList<>());
            subjectStudents.get(sub).add(stud);
        }
    }

    //    Добавление нового предмета для существующего студента с оценкой
    public void addSubjectForStudent(Student stud, Subject sub, int grade) {
        Map<Subject, Integer> grades = studentGrades.get(stud);
        if (grades != null) {
            grades.put(sub, grade);
            subjectStudents.putIfAbsent(sub, new ArrayList<>());
            subjectStudents.get(sub).add(stud);
        }
    }

    //    удаление студента и его предметов
    public void removeStud(Student stud, Subject sub) {
        Map<Subject, Integer> grades = studentGrades.remove(stud);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> studs = subjectStudents.get(subject);
                studs.remove(stud);
            }
        }
    }

    //    вывод списка всех студентов и их оценок
    public void printAll() {
        // Проходим по каждому студенту
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            Student student = entry.getKey();
            System.out.println("Студент: " + student);

            // Проходим по оценкам для каждого студента
            for (Map.Entry<Subject, Integer> grades : entry.getValue().entrySet()) {
                System.out.println("  " + grades.getKey() + " -  " + grades.getValue());
            }

            System.out.println(); // строка для визуального разделения студентов
        }
    }


}
