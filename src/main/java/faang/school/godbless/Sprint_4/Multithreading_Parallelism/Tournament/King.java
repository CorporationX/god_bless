package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Tournament;

public class King {
    public static void main(String[] args) {
        Knight jaime = new Knight("Jaime Lannister");
        Knight brienne = new Knight("Brienne of Tarth");
        Trial duel = new Trial(jaime.getName(), "Duel");
        Trial waterTrial = new Trial(jaime.getName(), "Water Trial");
        Trial fireTrial = new Trial(brienne.getName(), "Fire Trial");
        Trial strengthTrial = new Trial(brienne.getName(), "Strength Trial");

        jaime.addTrial(duel);
        jaime.addTrial(waterTrial);
        brienne.addTrial(fireTrial);
        brienne.addTrial(strengthTrial);

        jaime.startTrials();
        brienne.startTrials();
    }
}
