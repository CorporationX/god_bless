package faang.school.godbless.family_guy;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FamilyGuyFoodDelivery {
    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(3);
            String[] familyMembersNames = {"Peter", "Lois", "Meg", "Chris", "Stewie", "Brian"};
            Arrays.stream(familyMembersNames)
                    .map(fmn ->
                            new FoodDeliveryTask(fmn, ((new Random()).nextInt(5) + 1))
                    )
                    .forEach(executor::submit);

            executor.shutdown();
            executor.awaitTermination(15, TimeUnit.SECONDS);
            System.out.println("================================================");
            System.out.println("Every family member has received their delivery!");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
