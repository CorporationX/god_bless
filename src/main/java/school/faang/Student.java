package school.faang.bjs2_82905;

class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }

    public void addPoints(int additionalPoints) {
        this.points += additionalPoints;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}

