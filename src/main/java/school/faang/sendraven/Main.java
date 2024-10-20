package school.faang.sendraven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        List<Kingdom> kingdoms = new ArrayList<>();
        kingdoms.add(new Kingdom("Winterfell"));
        kingdoms.add(new Kingdom("King's Landing"));
        kingdoms.add(new Kingdom("First"));
        kingdoms.add(new Kingdom("Second"));
        kingdoms.add(new Kingdom("Third"));

        List<CompletableFuture<String>> futures = new ArrayList<>();
        for (int i = 0; i < kingdoms.size(); i++) {
            futures.add(ravenService.sendRaven(kingdoms.get(i), kingdoms.get((i + 1) % kingdoms.size()))
                    .handle((result, exception) -> {
                        if (exception != null) {
                            System.out.println("Ошибка: " + exception.getMessage());
                        } else {
                            System.out.println(result);
                        }
                        return null;
                    }));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }
}