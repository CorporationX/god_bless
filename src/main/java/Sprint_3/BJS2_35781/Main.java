package Sprint_3.BJS2_35781;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight("Paladin");
        knight.addTrial(new Trial("испытание воли", "тест на волю"));
        knight.addTrial(new Trial("испытание гнева", "сложное испытание гнева"));
        knight.addTrial(new Trial("испытание веры", "тест на веру"));

        knight.startTrials();
    }
}
