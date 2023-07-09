package Sprint_4_Tamagochi_Vlad;

import lombok.Data;

@Data

public class TamagotchiVlad {
    private String name;

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public void feed() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": " + getName() +" вкусно покушал");
        }
    }

    public void play() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": " + getName() + " интересно поиграл");
        }
    }

    public void clean() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": " + getName() + " помылся в душе");
        }
    }

    public void sleep() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": " + getName() + " сладко поспал");

        }
    }
}
