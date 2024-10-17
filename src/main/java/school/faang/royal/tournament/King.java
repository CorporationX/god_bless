package school.faang.royal.tournament;

public class King {

    public static void main(String[] args) {
        Knight lancelot = new Knight("Ланселот");
        Knight herald = new Knight("Герольд");

        Trial defeatTheDragon = new Trial(lancelot.getName(), "победить дракона", 5);
        Trial sweepTheYard = new Trial(lancelot.getName(), "подмести двор", 2);
        Trial mowTheLawn = new Trial(lancelot.getName(), "подстричь газон", 1);
        Trial digUpPotatoes = new Trial(herald.getName(), "вскопать картошку", 2);
        Trial saveThePrincess = new Trial(herald.getName(), "спасти принцессу", 3);

        lancelot.addTrial(defeatTheDragon);
        lancelot.addTrial(sweepTheYard);
        lancelot.addTrial(mowTheLawn);
        herald.addTrial(saveThePrincess);
        herald.addTrial(digUpPotatoes);

        lancelot.startTrials();
        herald.startTrials();
    }
}
