package school.faang.task327.Vlad;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class TamagotchiVlad {
    private String name;

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public String state = "нейтральное";

    public synchronized void feed() {
        state = "сыт";
        System.out.println(name + " ест");
    }

    public synchronized void sleep() {
        state = "выспался";
        System.out.println(name + " спит");
    }

    public synchronized void play() {
        state = "наигрался";
        System.out.println(name + " играет");
    }

    public synchronized void clean() {
        state = "чист";
        System.out.println(name + " моется");
    }

    public synchronized String getState() {
        return state;
    }
}
