package school.faang.goodandbad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily(new Chore[]{new Chore("Сделай кораблик"), new Chore("Помой пол"), new Chore("Выучи Redis")});
        for (Chore chore : weasleyFamily.tasks()) {
            service.submit(chore);
        }
        service.shutdown();
    }
}
