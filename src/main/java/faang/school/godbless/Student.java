package faang.school.godbless;
public class Student {
    private String name;
    private String faculty;
    private Integer year;

    public Student(String name, String faculty, Integer year){
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

    public Integer getYear() {
        return year;
    }
}