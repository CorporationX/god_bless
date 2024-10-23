package school.faang.mice.nice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int TIMEOUT = 10;
        House house = new House(
                new Room(new Food("cheeseburger"), new Food("loaded fries"), new Food("spicy hot dog")),
                new Room(new Food("double cheeseburger"), new Food("garlic fries"), new Food("chili hot dog")),
                new Room(new Food("bacon cheeseburger"), new Food("truffle fries"), new Food("jalapeño hot dog")),
                new Room(new Food("veggie burger"), new Food("sweet potato fries"), new Food("turkey hot dog")),
                new Room(new Food("mushroom burger"), new Food("onion rings"), new Food("chicken sausage")),
                new Room(new Food("black bean burger"), new Food("zucchini fries"), new Food("vegan sausage")),
                new Room(new Food("caramel apple"), new Food("peach cobbler"), new Food("blueberry muffin")),
                new Room(new Food("pesto pasta"), new Food("caprese salad"), new Food("grilled chicken")),
                new Room(new Food("sushi roll"), new Food("edamame"), new Food("miso soup")),
                new Room(new Food("pulled pork sandwich"), new Food("coleslaw"), new Food("bbq beans"))
        );

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(TIMEOUT);

        executor.shutdown();
        if (executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
            System.out.println("All foods were collected");
        }
    }
}
