package faang.school.godbless.royalHarbor;

public class King {
    public static void main(String... args) {
        Knight knight1 = new Knight("Golden knight");
        Knight knight2 = new Knight("Knight of flowers");
        knight1.addTrial(new Trial(knight1.getName(), "horse riding"));
        knight1.addTrial(new Trial(knight1.getName(), "lion slaying"));
        knight2.addTrial(new Trial(knight2.getName(), "dragon riding"));
        knight2.addTrial(new Trial(knight2.getName(), "wolf seeking"));
        knight1.startTrials();
        knight2.startTrials();
    }
}
