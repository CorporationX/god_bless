package bjs292937;

public record Student(String name, int year, int points) {
    public Student addPoints(int value) {
        return new Student(name, year, points + value);
    }
}
