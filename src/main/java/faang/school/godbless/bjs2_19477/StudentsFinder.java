package faang.school.godbless.bjs2_19477;

public abstract class StudentsFinder {
    protected Faculty faculty;
    protected int year;

    protected StudentsFinder(Faculty faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public abstract boolean equals(Object o);

    public abstract int hashCode();
}
