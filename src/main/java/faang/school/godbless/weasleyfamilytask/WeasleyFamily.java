import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("Мытье посуды", "Уборка", "Мытье полов");
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.stream().map(Chore::new).forEach(executor::submit);
        executor.shutdown();
    }
}
