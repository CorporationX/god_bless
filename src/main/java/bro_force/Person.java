package bro_force;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int score = 0;
    private int lives;
    private boolean isDead;

    public Person(String name, int lives, boolean isDead) {
        this.name = name;
        this.lives = lives;
        this.isDead = isDead;
    }
}
