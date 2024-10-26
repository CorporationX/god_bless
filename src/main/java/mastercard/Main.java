package mastercard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        logger.info("Запускаем процессы оплаты и сбора аналитики");

        service.doAll();

        logger.info("Процессы завершены");
    }
}
