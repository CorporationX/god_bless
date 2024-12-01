package school.faang.BJS237933;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        Kingdom kingdom = new Kingdom("Что-то");
        Kingdom kingdom2 = new Kingdom("Кому-то");

        kingdom.sendRaven(kingdom, kingdom2).handle((result, exp) -> {
            if (exp != null) {
                return "Ошибка: " + exp.getMessage();
            } else {
                log.info("Результат: " + result);
                return result;
            }
        }).join();
        kingdom.shutDown();
    }
}
