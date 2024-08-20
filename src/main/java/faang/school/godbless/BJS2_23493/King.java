package faang.school.godbless.BJS2_23493;

public class King {
    public static void main(String[] args) {

        Knight stark = new Knight("Eddard");
        Knight lannister = new Knight("Jaime");

        stark.addTrial(new Trial(stark.getName(), "Rescue Mission"));
        stark.addTrial(new Trial(stark.getName(), "The siege of the tower"));
        stark.addTrial(new Trial(stark.getName(), "Hunting"));

        lannister.addTrial(new Trial(lannister.getName(), "Rescue Mission"));
        lannister.addTrial(new Trial(lannister.getName(), "The siege of the tower"));
        lannister.addTrial(new Trial(lannister.getName(), "Hunting"));

        stark.startTrials();
        lannister.startTrials();

    }
}
