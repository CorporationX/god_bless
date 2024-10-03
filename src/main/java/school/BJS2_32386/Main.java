package school.BJS2_32386;

import java.util.*;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> mappa1 = new HashMap<>();
    private static final Map<Subject, List<Student>> mappa2 = new HashMap<>();


    public static void main(String[] args) {
        Student student_1 = new Student(1025, "Рома");
        Student student_2 = new Student(1024, "Катя");
        Student student_3 = new Student(1023, "Петя");
        Subject subject_1 = new Subject(1,"Математика");
        Subject subject_2 = new Subject(2, "Физика");
        Subject subject_3 = new Subject(3, "Биология");

        //добавляем списки предметов с оценками для студентов
        Map<Subject, Integer> student1 = new HashMap<>();
        student1.put(subject_1, 5);
        student1.put(subject_3,2);
        Map<Subject, Integer> student2 = new HashMap<>();
        student2.put(subject_2, 4);
        student2.put(subject_3,5);
        Map<Subject, Integer> student3 = new HashMap<>();
        student3.put(subject_2, 2);
        student3.put(subject_3,1);
        student3.put(subject_1,4);

        //добавляем в mappa1
        addStudent(student_1,student1);
        addStudent(student_2,student2);
        addStudent(student_3,student3);
        printStudents();
        System.out.println("---------------------------------------");

        //Добавляем предмет для студента
        addSubjectForStudent(student_1,subject_2,4);
        printStudents();
        System.out.println("---------------------------------------");
        //удаляем студента
        removeStudent(student_1);
        printStudents();
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");

        //создаем список какие студенты посещают предметы
        List<Student> subject_mat = new ArrayList<>();
        subject_mat.add(student_1);
        subject_mat.add(student_2);
        List<Student> subject_fis = new ArrayList<>();
        subject_fis.add(student_2);
        subject_fis.add(student_3);
        List<Student> subject_bio = new ArrayList<>();
        subject_bio.add(student_1);
        subject_bio.add(student_2);
        subject_bio.add(student_3);

        //добавляем предметы в mappa2
        addSubject(subject_1,subject_mat);
        addSubject(subject_2,subject_fis);
        addSubject(subject_3,subject_bio);
        printSubjects();
        System.out.println("---------------------------------------");

        //добавляем предмет для студента
        addStudentToSubject(subject_2,student_1);
        printSubjects();
        System.out.println("---------------------------------------");

        //удаляем студента из предмета
        removeStudentFromSubject(subject_2,student_1);
        printSubjects();
    }

    //добавление нового студента и его предметов с оценками
    private static void addStudent(Student student, Map<Subject, Integer> mappa) {
        mappa1.put(student,mappa);
    }

    //добавление нового предмета для существующего студента с оценкой
    private static void addSubjectForStudent(Student student, Subject subject, int note) {
        if(mappa1.containsKey(student)) {
            for (Map.Entry<Student, Map<Subject, Integer>> entry : mappa1.entrySet()) {
                if (!entry.getValue().containsKey(subject)) {
                    entry.getValue().put(subject, note);
                }
            }
        }
    }

    //удаление студента и его предметов с оценками
    private static void removeStudent(Student student) {
        mappa1.remove(student);
    }

    //вывод списка всех студентов и их оценок по предметам
    private static void printStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : mappa1.entrySet()) {
            System.out.printf("Для студента с id %d, именем %s список предметов: ",entry.getKey().getId(),entry.getKey().getName());
            System.out.println();
            for (Map.Entry<Subject, Integer> subject : entry.getValue().entrySet()) {
                System.out.printf("Посещает предмет : %s со средней оценкой %d",subject.getKey().getName(),subject.getValue());
                System.out.println();
            }
        }
    }

    //добавление нового предмета и списка студентов
    public static void addSubject (Subject subject, List<Student> students) {
        mappa2.put(subject, students);
    }

    //добавление студента к существующему предмету
    public static void addStudentToSubject(Subject subject, Student student) {

        for (Map.Entry<Subject, List<Student>> entry : mappa2.entrySet()) {
            if(Objects.equals(entry.getKey(),subject) && !entry.getValue().contains(student)) {
                entry.getValue().add(student);
            }
        }
    }

    //удаление студента из предмета
    public static void removeStudentFromSubject(Subject subject, Student student) {
        for (Map.Entry<Subject, List<Student>> entry : mappa2.entrySet()) {
            if(Objects.equals(entry.getKey(),subject)) {
                entry.getValue().remove(student);
            }
        }
    }

    //вывод списка всех предметов и студентов, изучающих их
    private static void printSubjects() {
        for (Map.Entry<Subject, List<Student>> entry : mappa2.entrySet()) {
            System.out.printf("Предмет %s посещают студенты : " , entry.getKey().getName());
            System.out.println();
            for (Student s : entry.getValue()) {
                System.out.print(s.getName());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
