package StudentFaculte;

import java.util.Objects;

public class Faculte {
    private String name;
    private int year;

    public Faculte(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculte faculte = (Faculte) o;
        return year == faculte.year && Objects.equals(name, faculte.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }

    @Override
    public String toString() {
        return "Faculte{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
