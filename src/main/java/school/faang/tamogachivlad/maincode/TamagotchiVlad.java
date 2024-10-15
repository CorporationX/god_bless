package school.faang.tamogachivlad.maincode;

public class TamagotchiVlad {
    private String name;
    private String state = "нейтральное";

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        state = "сыт";
        System.out.println(name + " кушает. Его состояние " + state);
    }

    public synchronized void play() {
        state = "весел";
        System.out.println(name + " играет. Его состояние " + state);
    }

    public synchronized void clean() {
        state = "чист";
        System.out.println(name + " купается. Его состояние " + state);
    }

    public synchronized void sleep() {
        state = "спит";
        System.out.println(name + " спит. Его состояние " + state ) ;
    }
}
