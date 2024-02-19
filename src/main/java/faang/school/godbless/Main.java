package faang.school.godbless;


import ch.qos.logback.classic.util.LogbackMDCAdapter;
import faang.school.godbless.gmail.Email;
import faang.school.godbless.gmail.EmailProcessor;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    static List<Student> listStudents = new ArrayList<>();
    private static final Map<Book, String> bookPlace = new HashMap<>();
    private static final Map<String, House> houseMap = new HashMap<>();
    private final static Map<String, WeatherData> weatherInTheCity = new HashMap<>();
    private final static Mock mockServise = new Mock();

    public static void startGroupingByHobby() {
        User user1Validation = new User("vanya", "Google", "London", 18);
        User user2Validation = new User("Petua", "Amazon", "Minsk", 19);
        User user3Validation = new User("Misha", "Google", "London", 17);

        Set<String> activity1 = Set.of("Drawing", "Dancing", "Music", "Sport");
        User user1 = new User("Ivan", 14, activity1);
        Set<String> activity2 = Set.of("Dancing", "Music", "Drawing", "Sport");
        User user2 = new User("Sergey", 20, activity2);
        Set<String> activity3 = Set.of("Sport", "Drawing", "Dancing", "Music");
        User user3 = new User("Artem", 35, activity3);
        Set<String> activity4 = Set.of("Learning foreign languages", "Blogging");
        User user4 = new User("Mathew", 23, activity4);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Map<User, String> spisUser = User.findHobbyLovers(users, activity2);
    }

    public static void startGroupingByAge() {
        User user1GroupAge = new User("Vanua", "work", "NN", 10);
        User user2GroupAge = new User("Petua", "work", "NN", 11);
        User user3GroupAge = new User("Misha", "work", "NN", 12);
        User user4GroupAge = new User("Ivan", "work", "NN", 10);
        User user5GroupAge = new User("Petr", "work", "NN", 11);

        List<User> groupAgeusers = List.of(user1GroupAge, user2GroupAge, user3GroupAge, user4GroupAge, user5GroupAge);
        Map<Integer, List<User>> groupAgeUsers = User.groupUsers(groupAgeusers);

    }

    public static void studentsStart() {

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

    public static void libraryStart() {
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

        addition(stark.getName(), stark);
        addition(lannister.getName(), lannister);
        addition(baratheon.getName(), baratheon);
        delete(lannister.getName());
        search(baratheon.getName());
        listOfAllHouses();
    }

    public static void weatherMain() throws IOException {
        WeatherData newYork = new WeatherData("New York", 25.1, 30);
        WeatherData miami = new WeatherData("Miami", 30, 70);

        weatherInTheCity.put(newYork.getCity(), newYork);
        weatherInTheCity.put(miami.getCity(), miami);
        getWeatherInTheCity("Dubai");
        updateWeather("Dubai");
        remove("Dubai");
        printAllCitys();

    }

    private static WeatherData getWeatherInTheCity(String city) {
        if (weatherInTheCity.containsKey(city)) {
            return weatherInTheCity.get(city);
        }
        WeatherData createWD = mockServise.createWeather(city);
        weatherInTheCity.put(city, createWD);
        return createWD;
    }

    private static void updateWeather(String city) throws IOException {
        if (!(weatherInTheCity.containsKey(city))) {
            throw new IOException("The city you sent is not in the database");
        }
        weatherInTheCity.put(city, mockServise.createWeather(city));
    }

    private static void remove(String city) {
        weatherInTheCity.remove(city);
    }

    private static void printAllCitys() {

        System.out.print("Weather information is available in cities:");
        weatherInTheCity.forEach((city, weather) -> {
            System.out.print(" " + city);
        });
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
            }
            ;
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
            System.out.println("In a group with faculty " + group.getFaculty() + " and course number " + +group.getYear() + " Matching list of students:");
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
        bookPlace.forEach((book, place) -> {
            System.out.println(book.toString() + " Book place in the library: " + place);
        });
    }
}
