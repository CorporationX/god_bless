package faang.school.godbless.sprint4.KingsLandingTournament.classes;

public class King {
    public static void main(String[] args) {
        Knight first = new Knight("First");
        Knight second = new Knight("Second");

        first.addTrial(new Trial(first.getName(), "Fight with bear"));
        first.addTrial(new Trial(first.getName(), "Swimming in the sea with armor"));

        second.addTrial(new Trial(second.getName(), "Fight with the lion"));
        second.addTrial(new Trial(second.getName(), "Climbing the mountain"));

        first.startTrial();
        second.startTrial();
    }
}
