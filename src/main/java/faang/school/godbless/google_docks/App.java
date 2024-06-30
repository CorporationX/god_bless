package faang.school.godbless.google_docks;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int THREAD_NUM = 8;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

    public static void main(String[] args) {
        CollaborativeDocument collaborativeDocument = new CollaborativeDocument();

        Map<String, String> idAndSectionEntries = getIdAndSectionEntries();

        idAndSectionEntries.forEach(collaborativeDocument::addData);

        List<DocumentSectionProcessor> documentSectionProcessorList = idAndSectionEntries.keySet().stream()
                .map(key -> new DocumentSectionProcessor(
                        new DocumentSection(key, collaborativeDocument)
                        , String::toUpperCase))
                .toList();

        documentSectionProcessorList.forEach(executorService::execute);

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(collaborativeDocument.getIdAndSectionMap());
    }

    private static Map<String, String> getIdAndSectionEntries() {
        return Map.of(
                "1", "one",
                "2", "two",
                "3", "three",
                "4", "four",
                "5", "five",
                "6", "six",
                "7", "seven",
                "8", "eight"
        );
    }
}
