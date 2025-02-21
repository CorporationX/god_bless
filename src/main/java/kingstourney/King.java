package kingstourney;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight knight1 = new Knight("Robert Baratheon");
        Knight knight2 = new Knight("Jaime Lannister");

        knight1.addTrial(new Trial(knight1.getName(), "Sword Fight"));
        knight1.addTrial(new Trial(knight1.getName(), "Horse Riding"));

        knight2.addTrial(new Trial(knight2.getName(), "Jousting"));
        knight2.addTrial(new Trial(knight2.getName(), "Archery"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
