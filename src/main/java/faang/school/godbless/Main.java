package faang.school.godbless;

public class Main {
    public static void main(String[] args) {

        Knight knight1 = new Knight("Carlton");
        knight1.addTrial(new Trial("Carlton", "Trial of Valor"));
        knight1.addTrial(new Trial("Carlton", "Trial of Courage"));

        Knight knight2 = new Knight("Keys");
        knight2.addTrial(new Trial("Keys", "Trial of Wisdom"));
        knight2.addTrial(new Trial("Keys", "Trial of Strength"));

        knight1.startTrials();
        knight2.startTrials();

    }
}
