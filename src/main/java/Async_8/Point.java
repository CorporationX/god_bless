package Async_8;

public class Point {

    private final float xO;
    private final float yO;

    public Point() {
        this.xO = (float) Math.random();
        this.yO = (float) Math.random();
    }

    public float getxO() {
        return xO;
    }

    public float getyO() {
        return yO;
    }
}
