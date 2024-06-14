package faang.school.godbless.week1.Students;

public class Students {
    private String fullName;
    private String faculty;
    private int year;

    public Students(String fullName,String faculty,int year){
        this.fullName=fullName;
        this.faculty=faculty;
        this.year=year;
    }
    public String getFullName(){
        return fullName;
    }
    public  String getFaculty(){
        return faculty;
    }
    public int getYear(){
        return  year;
    }

    @Override
    public String toString(){
        return "Student{fullName='" + fullName+ "', faculty='" + faculty + "', year=" + year + "}";
    }
}
