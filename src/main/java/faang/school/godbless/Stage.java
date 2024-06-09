package faang.school.godbless;

import java.util.Objects;

public class Stage {
    private String faculty;
    private int year;

    public Stage(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        else {
            Stage student = (Stage) o;
            return this.faculty == student.faculty && this.year == student.year;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.faculty, this.year);
    }

    @Override
    public String toString() {
        return "|" + this.faculty + "| course |" + this.year + "|";
    }
}