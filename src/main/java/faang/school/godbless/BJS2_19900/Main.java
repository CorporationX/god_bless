package faang.school.godbless.BJS2_19900;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// добавление нового студента и его предметов с оценками;
// добавление нового предмета для существующего студента с оценкой;
// удаление студента и его предметов с оценками;
// вывод списка всех студентов и их оценок по предметам.
// -----------------------------------
// добавление нового предмета и списка студентов, изучающих его;
// добавление студента к существующему предмету;
// удаление студента из предмета;
// вывод списка всех предметов и студентов, изучающих их.


public class Main {
    private final static Map<Student, Map<Subject, Integer>> studentMap = new HashMap<>();
    private final static Map<Subject, List<Student>> subjectMap = new HashMap<>();

    public static void main(String[] args) {
        addStudent(new Student(0, "Ivan"), new HashMap<Subject, Integer>() {{
            put(new Subject(0, "Math"), 5);
        }});
        addStudent(new Student(1, "Petr"), new HashMap<Subject, Integer>() {{
            put(new Subject(0, "Math"), 5);
        }});


//        System.out.println(studentMap.get(new Student(0, "Ivan")));
    printAllStudentRates();
    }




    private static void addStudent(Student student, Map<Subject, Integer> subjectRatesMap) {
        studentMap.computeIfAbsent(student, k -> subjectRatesMap);
    }

    private static void printAllStudentRates() {
        for (var entry : studentMap.entrySet()) {
            System.out.println(entry.getKey().getName()+": ");
            for (var subject : entry.getValue().entrySet()) {
                System.out.println(subject.getKey().getName()+" - "+subject.getValue());

            }
            System.out.println("-------------");
        }
    }
}
