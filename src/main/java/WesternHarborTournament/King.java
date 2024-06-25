package WesternHarborTournament;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight charles = new Knight("Charles");
        Knight robert = new Knight("Robert");

        charles.addTrail(new Trial(charles.getName(), "The Trial of Strength"));
        robert.addTrail(new Trial(robert.getName(), "The Trial of Courage"));
        charles.addTrail(new Trial(charles.getName(), "The Trial of Wisdom"));
        robert.addTrail(new Trial(robert.getName(), "The Trial of Virtue"));

        Knight.startTrail();
    }
}
