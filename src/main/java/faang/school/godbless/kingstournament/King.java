package faang.school.godbless.kingstournament;
public class King {
    public static void main(String[] args) {
        Knight bokuto = new Knight("Bokuto");
        Knight hinata = new Knight("Hinata");

        bokuto.addTrial(new Trial("Bokuto", "do smth"));
        bokuto.addTrial(new Trial("Bokuto", "do another thing"));
        hinata.addTrial(new Trial("Hinata", "play volleyball"));
        hinata.addTrial(new Trial("Hinata", "jump high"));

        bokuto.startTrials();
        hinata.startTrials();
    }

}
