package faang.school.godbless;

import java.util.*;

public class Main {
    static List<Student> listStudents = new ArrayList<>();
    private static final Map<Book, String> bookPlace = new HashMap<>();
    private static final Map<String, House> houseMap = new HashMap<>();

    public static void mainStart() {
        
        Student student1 = new Student("Ivan", "information technologies", 2);
        Student student2 = new Student("Petr", "information technologies", 2);
        Student student4 = new Student("Artem", "Biology", 2);
        Student student3 = new Student("Aleksandr", "information technologies", 1);

        addition(student1);
        addition(student2);
        addition(student3);
        addition(student4);

        removeStudent("Aleksandr", "information technologies", 1);

        Map<GroupInUniversity, List<Student>> groupStudents = createGroupStudent(listStudents);

        searchAllStudentInGroups("information technologies", 2);
        printAllGroupsStudent(groupStudents);

    }
  
   public static void mainStart() {
        Scanner in = new Scanner(System.in);

        Book headFirstJava = new Book("Head First Java", "Katie Sierra and Bert Bates", 2003);
        Book javaForDummies = new Book("Java for dummies", "Barry Bird", 2006);
        Book javaBeginnersGuide = new Book("Java. Beginner's Guide", "Herbert Shildt", 2002);
        System.out.print("Enter a location for the book" + headFirstJava.getTitle() + ":");
        String place = in.nextLine();
        additionBookPlace(headFirstJava, place);
        System.out.print("\nEnter a location for the book" + javaForDummies.getTitle() + ":");
        place = in.nextLine();
        additionBookPlace(javaBeginnersGuide, place);
        System.out.print("\nEnter a location for the book" + javaBeginnersGuide.getTitle() + ":");
        place = in.nextLine();
        additionBookPlace(javaForDummies, place);
        removeBook("Java for dummies", "Barry Bird", 2006);
        searchBook("Java. Beginner's Guide", "Herbert Shildt", 2002);
        printAllBooks();
    }
   
    public static void mainStartHouseGame() {
        House stark = new House("Stark", "direwolf");
        House lannister = new House("Lannister", "Lion rampant");
        House baratheon = new House("Baratheon", "black crowned stag");
      
        addition(stark.getName(),stark);
        addition(lannister.getName(),lannister);
        addition(baratheon.getName(),baratheon);
        delete(lannister.getName());
        search(baratheon.getName());
        listOfAllHouses();
    }

    private static void addition(Student student) {
        listStudents.add(student);
    }

    private static void removeStudent(String name, String faculty, int year) {
        listStudents.remove(new Student(name, faculty, year));
    }

    private static Map<GroupInUniversity, List<Student>> createGroupStudent(List<Student> listStudents) {
        Map<GroupInUniversity, List<Student>> groups = new HashMap<>();

        listStudents.forEach((f) -> {
            GroupInUniversity newGroupStudents = new GroupInUniversity(f.getFaculty(), f.getYear());
            List<Student> updateListStudent = groups.get(newGroupStudents);
            if (updateListStudent != null) {
                updateListStudent.add(f);
                groups.put(newGroupStudents, updateListStudent);

            } else {
                List<Student> updateGroupListStudent = new ArrayList<>();
                updateGroupListStudent.add(f);
                groups.put(newGroupStudents, updateGroupListStudent);
            };
        });
        return groups;
    }

    private static List<Student> searchAllStudentInGroups(String faculty, int year) {
        List<Student> studentsOfTheRequestedGroup = new ArrayList<>();
        listStudents.forEach((s) -> {
            if (s.getFaculty() == faculty && s.getYear() == year) {
                studentsOfTheRequestedGroup.add(s);
            }
        });
        return studentsOfTheRequestedGroup;
    }

    private static void printAllGroupsStudent(Map<GroupInUniversity, List<Student>> groupStudent) {
        groupStudent.forEach((group, listStudent) -> {
            System.out.println("In a group with faculty " + group.getFaculty() + " and course number " +
                    +group.getYear() + " Matching list of students:");
        });
    }
  
    private static void addition(String name, House house) {
        houseMap.put(name, house);
    }

    public static void delete(String name) {
        houseMap.remove(name);
    }

    public static void search(String name) {
        System.out.println(houseMap.get(name).getSigil() + " Герб дома " + name);

    }

    public static void listOfAllHouses() {
        houseMap.forEach((name, house) -> System.out.println("Название дома: " + name + " Название герба: " + house.getSigil()));
    }

    private static void additionBookPlace(Book book, String place) {
        bookPlace.put(book, place);
    }

    private static void removeBook(String name, String author, int year) {
        bookPlace.remove(new Book(name, author, year));
    }

    private static void searchBook(String name, String author, int year) {
        System.out.println("place book with title: " + name + " in library: " + bookPlace.get(new Book(name, author, year)));
    }

    private static void printAllBooks() {
        bookPlace.forEach(
                (book, place) -> {
                    System.out.println(book.toString() + " Book place in the library: " + place);
                }
        );
    }
}