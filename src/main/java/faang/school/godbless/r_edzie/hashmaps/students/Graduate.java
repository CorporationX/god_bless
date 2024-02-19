package faang.school.godbless.r_edzie.hashmaps.students;

import java.util.Objects;

public class Graduate {
    private final String faculty;
    private final int year;

    public Graduate(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graduate graduate = (Graduate) o;
        return year == graduate.year && Objects.equals(faculty, graduate.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
