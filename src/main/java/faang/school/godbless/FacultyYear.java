package faang.school.godbless;

public class FacultyYear {
    private String faculty;
    private int year;

    public FacultyYear(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty(){
        return faculty;
    }

    public int getYear(){
        return year;
    }

    @Override
    public String toString() {
        return faculty + " " + year;
    }

}
