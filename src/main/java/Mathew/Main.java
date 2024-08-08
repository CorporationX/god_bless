package Mathew;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main1 {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student student1 = new Student("Ван Ванов Даркхолмов", "Факультет информатики", 2);
        Student student2 = new Student("Мария Петрова", "Факультет экономики", 3);
        Student student3 = new Student("Дмитрий Сергеев", "Факультет физики", 1);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        System.out.println(facultyYearOfStudents(students));
        System.out.println(listOfAllStudentsFacultyAndYear());
        addStudent("Mitio Kanai", "Japanese History", 1);
        removeStudent("Дмитрий Сергеев");
        searchStudents("Факультет экономики",3);
        System.out.println(facultyYearOfStudents(students));

    }

    public static HashMap<Pair, List<Student>> facultyYearOfStudents(List<Student> list) {
        HashMap<Pair, List<Student>> hashMap = new HashMap<>();
        for (Student student : list) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            hashMap.computeIfAbsent(pair, k -> new ArrayList<>()).add(student);
        }
        return hashMap;
    }

    public static void addStudent(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public static List<Student> searchStudents(String faculty, int year) {
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    //вывод списка всех студентов сгруппированных по факультетам и курсам
    public static Map<Pair, List<Student>> listOfAllStudentsFacultyAndYear() {
        Map<Pair, List<Student>> hashMap_StudentsFacultyAndYear = new HashMap<>();
        for (Student student : students) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            hashMap_StudentsFacultyAndYear.computeIfAbsent(pair, k -> new ArrayList<>()).add(student);
        }
        return hashMap_StudentsFacultyAndYear;
    }
}


import java.util.HashMap;
import java.util.Map;

public class Main2 {
    static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book detective = new Book("Sherlock Holmes", "Doyle", 1900);
        Book romance = new Book("Island", "Dephoe", 1950);
        Book prose = new Book("Christine", "King", 1980);

        library.put(detective, "A");
        library.put(romance, "B");
        library.put(prose, "C");
        getAllBooks();
        removeBook(romance.getTitle(), romance.getAuthor(), romance.getYear());
        addBook(romance, "L");
    }

    public static void addBook(Book book, String number) {

        library.put(book, number);
    }

    public static void removeBook(String name, String author, int year) {
        library.remove(new Book(name, author, year));
    }

    public static void getAllBooks() {

        library.forEach(((key, value) -> System.out.println(key + value)));
    }
}

