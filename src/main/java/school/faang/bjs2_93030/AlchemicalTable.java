package school.faang.bjs2_93030;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlchemicalTable {
    private static final int THREAD_SLEEPS_MILS = 1000;

    public int searchIngredient(Potion potion) {
        try {
            log.info("Встретил по пути путника {}. Начинаем поиск ингридиентов, в количестве {} для зелья {}",
                    Thread.currentThread().getName(), potion.getScoreIngredient(), potion.getName());
            Thread.sleep((long) THREAD_SLEEPS_MILS * potion.getScoreIngredient());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Произошла ошибка в поиске ингредиентов");
        }
        return potion.getScoreIngredient();
    }
}
