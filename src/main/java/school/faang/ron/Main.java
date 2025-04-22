package school.faang.ron;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addChore(new Chore("помыть полы"));
        weasleyFamily.addChore(new Chore("помыть посуду"));
        weasleyFamily.addChore(new Chore("убрать вещи"));
        weasleyFamily.addChore(new Chore("подмести пол"));
        weasleyFamily.addChore(new Chore("помыть окно"));
        weasleyFamily.addChore(new Chore("поставить чайник"));
        weasleyFamily.addChore(new Chore("свари обед"));
        weasleyFamily.addChore(new Chore("протри пыль"));
        weasleyFamily.addChore(new Chore("отмыть ванну"));


        for(Chore chore : weasleyFamily.getChores()) {
            service.submit(chore);
        }
        service.shutdown();
    }
}
