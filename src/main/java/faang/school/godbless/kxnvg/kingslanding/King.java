package faang.school.godbless.kxnvg.kingslanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        Knight artur = new Knight("Артур");
        Knight henrih = new Knight("Генрих");

        artur.addTrial(new Trial("Вытащить меч короля Артура"));
        artur.addTrial(new Trial("Убить льва"));
        henrih.addTrial(new Trial("Убить гидру"));
        henrih.addTrial(new Trial("Украсть золотые яблоки"));

        ExecutorService service = Executors.newFixedThreadPool(2);

        for (Trial trial : artur.getTrials()) {
            service.submit(trial);
        }
        for (Trial trial : henrih.getTrials()) {
            service.submit(trial);
        }
        service.shutdown();
    }
}
