package school.faang.task_45249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    HashMap<Student, Map<Subject, Integer>> studentGrades = Main.getStudentGrades();
    HashMap<Subject, List<Student>> subjectStudents = Main.getSubjectStudents();


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
                if (studs != null) {
                    studs.remove(stud);
                }
            }
        }
    }


    //    вывод списка всех студентов и их оценок
    public void printAllStudents() {
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

    //Добавление нового предмета и списка студентов, изучающих его.
    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).put(subject, null);
        }
    }

    //добавление студента к существующему предметy
    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
        studentGrades.putIfAbsent(student, new HashMap<>());
        studentGrades.get(student).put(subject, null);
    }

    // удаление студента из предмета
    public void removeStudFromSub(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);

        //удаляем из subjectStudents
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentGrades.get(student);
        //удаляем из studentsGrades
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjects() {
        // Проходим по каждому предмету
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            System.out.println("Предмет: " + subject);

            // Проходим по студентикам
            for (Student student : entry.getValue()) {
                System.out.println("   Студент: " + student.getName());
            }

            System.out.println(); // строка для визуального разделения предметов
        }
    }

}
