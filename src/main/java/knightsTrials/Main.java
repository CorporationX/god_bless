package knightsTrials;

public class Main {
    public static void main(String[] args) {
        Knight elon = new Knight("Elon Mask");
        Knight yuri = new Knight("Yuri Gagarin");
        Trial centrifuge = new Trial("Yuri Gagarin", "Центрифуга");
        Trial pressure = new Trial("Yuri Gagarin", "Барокамера");
        Trial pres = new Trial("Elon Mask", "Прес качат");
        Trial anzhumania = new Trial("Elon Mask", "Анжумания");

        elon.addTrial(pres);
        elon.addTrial(anzhumania);
        yuri.addTrial(pressure);
        yuri.addTrial(centrifuge);

        elon.startTrials();
        yuri.startTrials();
        Knight.executorService.shutdown();
    }
}
