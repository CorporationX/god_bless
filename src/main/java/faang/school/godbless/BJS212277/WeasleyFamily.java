package faang.school.godbless.BJS212277;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {"мытье посуды", "готовка ужина"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        Arrays.stream(chores).map(Chore::new).forEach(executorService::execute);
        executorService.shutdown();
    }
}
