package faang.school.godbless.module1.sprint3.task5;

public class King {
    public static void main(String[] args) {
        Knight aria = new Knight("Aria");
        Knight robert = new Knight("Robert");

        aria.addTrial(new Trial(aria.getName(), "Kill Rock"));
        aria.addTrial(new Trial(aria.getName(), "Drink vine"));
        robert.addTrial(new Trial(robert.getName(), "Go away"));
        robert.addTrial(new Trial(robert.getName(), "Go home"));

        Trial.startTrials(robert.getTrials());
        Trial.startTrials(aria.getTrials());
    }
}
