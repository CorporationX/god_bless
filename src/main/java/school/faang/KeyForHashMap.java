package school.faang;

import java.util.Objects;

public class KeyForHashMap {
    private String faculty;
    private int year;

    public KeyForHashMap(int year, String faculty) {
        this.year = year;
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyForHashMap key = (KeyForHashMap) obj;
        return year == key.year &&
                Objects.equals(faculty, key.faculty);

    }
}
