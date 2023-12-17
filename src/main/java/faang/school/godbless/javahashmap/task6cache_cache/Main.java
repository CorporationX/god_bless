package faang.school.godbless.javahashmap.task6cache_cache;

import java.util.*;

public class Main {
    private static Map<Student, Map<Subject, Integer>> mapGrades = new HashMap<>();
    private static Map<Subject, List<Student>> mapStudents = new HashMap<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String... args) {
        initMapStudents();
        Student student4 = new Student("Stiv");

        System.out.println(mapGrades);
        System.out.println(mapStudents);
        System.out.println();

        addGrades(student4);
        System.out.println(mapGrades);
        System.out.println();

        removeStudentGrade(new Student("yhhthhdt"));
        //removeStudentGrade(student4);

        info();

        Subject math = new Subject("Math");
        addSubject(math, students);

        addStudent(new Subject("htht"), student4);
        addStudent(math, student4);

        removeStudentSubject(new Student("garers"), new Subject("gdzfgd"));
        removeStudentSubject(student4, math);
    }

    public static void initMapStudents() {
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        Subject chemistry = new Subject("Chemistry");
        Subject history = new Subject("History");
        Subject literature = new Subject("Literature");
        Subject programming = new Subject("Programming");
        Subject biology = new Subject("Biology");
        Subject geography = new Subject("Geography");
        Subject music = new Subject("Music");
        Subject art = new Subject("Art");

        Main.addGrade(student1, math, 5);
        Main.addGrade(student1, chemistry, 3);
        System.out.println();

        Main.addGrade(student2, chemistry, 2);
        Main.addGrade(student2, history, 4);
        System.out.println();

        Main.addGrade(student3, programming, 4);
        Main.addGrade(student3, programming, 3);
        Main.addGrade(student3, music, 3);
        System.out.println();
    }

    public static void addGrade(Student student, Subject subject, int grade) {
        if (!mapGrades.containsKey(student)) {
            System.out.println("Студент " + student.getName() + " добавлен");
        }

        mapGrades.computeIfAbsent(student, x -> new HashMap<>()).put(subject, grade);
        mapStudents.computeIfAbsent(subject, x -> new ArrayList<>()).add(student);
        System.out.println("Студентy " + student.getName() + " добавленa оценка " + grade
                + " по " + subject.getName());
    }

    public static void addGrades(Student student) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите вместо предмета команду end когда закончите выставлять оценки\n");

            while (true) {
                System.out.println("Введите предмет:");
                String subject = scanner.nextLine();

                if (subject.equalsIgnoreCase("end")) {
                    break;
                }

                System.out.println("Введите оценку:");
                int grade = scanner.nextInt();

                scanner.nextLine(); // очистка буфера

                addGrade(student, new Subject(subject), grade);
                System.out.println();
            }
        }
    }

    public static void removeStudentGrade(Student student) {
        if (!mapStudents.containsKey(student)) {
            System.out.println("Не найден студент с именем " + student.getName() + "\n");
            return;
        }

        Map<Subject, Integer> subjectsGrade = mapGrades.remove(student);

        for (Subject subject : subjectsGrade.keySet()) {
            mapStudents.getOrDefault(subject, new ArrayList<>()).remove(student);
        }

        System.out.println("Студент " + student.getName() + " был удален\n");
    }

    public static void info() {
        mapGrades.forEach((student, grades) -> {
            System.out.println(student + ":  " + grades);
        });
    }

    public static void addSubject(Subject subject, List<Student> students) {
        mapStudents.put(subject, students);
        System.out.println("Добавлен предмет " + subject.getName() + " со списком студентов\n");
    }

    public static void addStudent(Subject subject, Student student) {
        if (!mapStudents.containsKey(subject)) {
            System.out.println("Добавление студента " + student.getName() + " невозможно, не добавлен предмет " + subject.getName() + "\n");
            return;
        }

        mapStudents.get(subject).add(student);
        System.out.println("Студент " + student.getName() + " добавлен к предмету " + subject.getName() + "\n");
    }

    public static void removeStudentSubject(Student student, Subject subject) {

        if (!mapStudents.containsKey(subject)) {
            System.out.println("Не существует предмета " + subject.getName() + "\n");
            return;
        }

        boolean isFoundStudent = mapStudents.getOrDefault(subject, new ArrayList<>()).remove(student);

        if (isFoundStudent) {
            System.out.println("Из предмета " + subject.getName() + " был удален студент " + student.getName() + "\n");
        } else {
            System.out.println("Не найден студент с именем " + student.getName() + "\n");
        }
    }

}
