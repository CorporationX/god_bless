package school.faang.s_4_1_triwizard_tournament;

public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    // допускаю параллельные таски на одну школу
    public synchronized void achievePoints(int reward) {
        points += reward;
    }
}
