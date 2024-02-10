package src.main.java.faang.school.godbless;
public class Student {
    String name;
    String faculty;
    int year;

    Student(String name, String faculty, int year){
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }



}
