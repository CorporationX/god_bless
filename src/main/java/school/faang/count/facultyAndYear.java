package school.faang.count;

import java.util.Objects;

public class facultyAndYear {
     private final String faculty;
     private final int year;

     public facultyAndYear(String faculty, int year) {
         this.faculty = faculty;
         this.year = year;
     }

     public String getFaculty() {
         return faculty;
     }

     public int getYear() {
         return year;
     }

    public String getCombineFacultyAndYear() {
        return faculty + " " + year;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        facultyAndYear that = (facultyAndYear) object;
        return year == that.year && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
