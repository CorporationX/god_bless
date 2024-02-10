package faang.school.godbless.hash_map.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentsGrade = new HashMap<>();

    private static Map<Subject, List<Student>> studentsStudyingSubject = new HashMap<>();

    public static void addSubject(Student student, Subject subject, Integer grade){
        studentsGrade.get(student).put(subject, grade);
        if(!studentsStudyingSubject.containsKey(subject)){
            studentsStudyingSubject.put(subject, new ArrayList<>());
        }
        studentsStudyingSubject.get(subject).add(student);
    }

    public static void main(String[] args) {
        Subject mathematica = new Subject(1, "Математика");
        Subject russian = new Subject(2, "Русский язык");
        Subject computerScience = new Subject(3, "Информатика");
        Subject okt = new Subject(4, "Общий курс транспорта");
        Subject python = new Subject(5, "Python");
        Student kirill = new Student(1, "Кирилл");
        Student yaroslav = new Student(2, "Ярослав");
        Student pasha = new Student(3, "Паша");
        Student maxim = new Student(4, "Максим");
        Map<Subject, Integer> a = new HashMap<>();
        addStudent(kirill, new HashMap<>(){{
            put(mathematica, 4);
            put(russian, 4);
            put(computerScience, 4);
        }});
        addStudent(yaroslav, new HashMap<>(){{
            put(mathematica, 4);
            put(russian, 4);
            put(computerScience, 5);
        }});


        printStudent();
        System.out.println();
        System.out.println("----------------------");
        printSubjectAndStudents();

        addSubject(kirill,okt, 3);

        printStudent();

        deleteStudent(yaroslav);

        System.out.println("--------------");
        printStudent();


        addSubjectAndStudents(python, new ArrayList<>(){{
            add(yaroslav);
            add(kirill);
            add(pasha);
        }});

        printSubjectAndStudents();

        System.out.println("-------");

        addStudentToSubject(maxim, python);

        printSubjectAndStudents();

        System.out.println("___-------__");
        deleteStudentFromSubject(yaroslav, python);
        printSubjectAndStudents();

    }

    public static void addStudent(Student student, Map<Subject, Integer> studentSubject){
        studentsGrade.put(student, studentSubject);
        for(Subject subject : studentSubject.keySet()){
            if(!studentsStudyingSubject.containsKey(subject)){
                studentsStudyingSubject.put(subject, new ArrayList<>());
            }
            studentsStudyingSubject.get(subject).add(student);
        }
    }

    public static void deleteStudent(Student student){
        Set<Subject> subjectStudent = studentsGrade.remove(student).keySet();
        for (var entry : studentsStudyingSubject.entrySet()){
            if(subjectStudent.contains(entry.getKey())){
                entry.getValue().remove(student);
            }
        }
    }

    public static void printStudent(){
        for(var entry: studentsGrade.entrySet()){
            System.out.println("Студент: " + entry.getKey().getName());
            System.out.print("Оценки студента: ");
            entry.getValue().forEach((x,y) -> {
                System.out.print("[" +x.getName() + " : " + y + "] ");
            });
            System.out.println();
        }
    }

    public static void addSubjectAndStudents(Subject subject, List<Student> list){
        studentsStudyingSubject.put(subject, list);
    }

    public static void addStudentToSubject(Student student, Subject subject){
        studentsStudyingSubject.get(subject).add(student);
    }

    public static void deleteStudentFromSubject(Student student, Subject subject){
        List<Student> students = studentsStudyingSubject.get(subject);
        if (students != null) {
            students.remove(student);
        }
        else {
            System.out.println("Предмета не существует");
        }
    }

    public static void printSubjectAndStudents(){
        for(var entry : studentsStudyingSubject.entrySet()){
            System.out.println("Предмет: " + entry.getKey().getName());
            System.out.print("Список учеников: ");
            entry.getValue().forEach(x -> System.out.print("[id: " + x.getId()+ ", Имя: " + x.getName() + "] "));
            System.out.println();
        }
    }
}
