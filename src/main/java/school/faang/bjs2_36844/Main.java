package school.faang.bjs2_36844;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        String[] choresWeasleyFamily = createChores();
        WeasleyFamily weasleyFamily = new WeasleyFamily(choresWeasleyFamily);
        String[] chores = weasleyFamily.getChores();
        ExecutorService executorService = Executors.newCachedThreadPool();

        Arrays.stream(chores)
                .map(Chore::new)
                .forEach(executorService::execute);

        executorService.shutdown();
    }

    private static String[] createChores() {
        return new String[]{
                "Wash the dishes",
                "Sweep the floor",
                "Prepare dinner",
                "Vacuum the carpet",
                "Laundry",
                "Clean the bathroom",
                "Take out the trash",
                "Water the plants",
                "Dust the furniture",
                "Organize the closet"
        };
    }
}
