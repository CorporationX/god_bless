package school.faang.alhimia;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Group {

    public int gatherIngredients(Potion potion) {
        int countIngredients = potion.getRequiredIngredients();
        try {
            TimeUnit.SECONDS.sleep(countIngredients);
            log.info("имитация сбора средств для зелья: {} ", potion.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("необходимо для зелья {} ингредиентов", countIngredients);
        return countIngredients;
    }
}
