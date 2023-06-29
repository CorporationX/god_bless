package faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city;

public class Location {
    private final int x;
    private final int y;

    private final int sumLoc;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        sumLoc = x + y;
    }

    public int getSumLoc() {
        return sumLoc;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}