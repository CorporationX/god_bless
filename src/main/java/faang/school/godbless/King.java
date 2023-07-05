package faang.school.godbless;


public class King {
    public static void main(String[] args) {
        Knight tyson = new Knight("Tyson");
        Knight ronaldo = new Knight("Ronaldo");

        tyson.addTrial(new Trial(tyson.getName(), "fight with cat"));
        tyson.addTrial(new Trial(tyson.getName(), "fight with dog"));
        ronaldo.addTrial(new Trial(ronaldo.getName(), "jump across the ocean"));

        tyson.startTrials();
        ronaldo.startTrials();

        System.out.println("All the trials has finished by " + tyson.getName() + ": " + tyson.isDone());
        System.out.println("All the trials has finished by " + ronaldo.getName() + ": " + ronaldo.isDone());
    }
}
