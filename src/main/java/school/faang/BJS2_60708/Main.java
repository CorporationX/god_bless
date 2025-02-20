package school.faang.BJS2_60708;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily(List.of(
                new Chore("помыть посуду"),
                new Chore("подмести пол"),
                new Chore("приготовить ужин")
        ));

        try {
            weasleyFamily.actionsCore();
        } catch (InterruptedException e) {
            logger.error("Домашние дела семьи Уизли не завершены. ", e);

        }
    }
}
