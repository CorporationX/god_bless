package school.faang.BJS2_61181;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final Logger logger = LoggerFactory.getLogger(GriffinsFoodDelivery.class);
    private static final String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final int AMOUNT_OF_FOOD = 10;
    private static final int AMOUNT_OF_THREAD = 3;

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREAD);

    }
}
