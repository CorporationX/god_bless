package WesternHarborTournament;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight charles = new Knight("Charles");
        Knight robert = new Knight("Robert");

        Knight.addTrail(new Trial(charles.getName(), "The Trial of Strength"));
        Knight.addTrail(new Trial(robert.getName(), "The Trial of Courage"));
        Knight.addTrail(new Trial(charles.getName(), "The Trial of Wisdom"));
        Knight.addTrail(new Trial(robert.getName(), "The Trial of Virtue"));

        Knight.startTrail();
    }
}
