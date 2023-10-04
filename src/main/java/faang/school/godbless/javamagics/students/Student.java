package faang.school.godbless.javamagics.students;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Student {
    private static final List<String> FACULTY_LIST = Arrays.asList(
            "Computer Science","Computer Engineering", "Information Systems", "Information Science");
    private static final List<String> UNIVERSITY_YEARS = Arrays.asList("1st year","2nd year","3rd year");
    private String name;
    private String faculty;
    private String year;

    public Student(String name, String faculty, String year) {
        validateInput(name,faculty,year);

        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    private void validateInput(String name, String faculty, String year){
        if(name == null || name.isBlank()){
            throw new NoSuchElementException("Name can't be empty");
        }

        if(!FACULTY_LIST.contains(faculty)){
            throw new NoSuchElementException("University doesn't have this faculty");
        }

        if(!UNIVERSITY_YEARS.contains(year)){
            throw new NoSuchElementException("There years are in range from 1 to 3");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty) && Objects.equals(year, student.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, year);
    }
}
