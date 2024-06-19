package faang.school.godbless.KingsLanding;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Sir Bron");
        knight1.addTrial(new Trial("Sir Lancelot", "Пробежать 100 метров"));
        knight1.addTrial(new Trial("Sir Lancelot", "Победить гору"));

        Knight knight2 = new Knight("Sir Baristan");
        knight2.addTrial(new Trial("Sir Baristan", "Победить пса"));

        knight1.startTrials();
        knight2.startTrials();
    }
}




