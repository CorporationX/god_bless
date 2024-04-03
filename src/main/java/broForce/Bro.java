package broForce;

public class Bro {
    private String name;
    private int lives;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
