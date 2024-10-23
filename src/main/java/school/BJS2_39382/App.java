package school.BJS2_39382;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    private static final int SIZE_OF_THREADS = 10;

    public static void main(String[] args) {

        CollaborativeDocument document = new CollaborativeDocument();

        DocumentSection[] documentSections = new DocumentSection[SIZE_OF_THREADS];

        for (int i = 0; i < 10; i++) {
            DocumentSection documentSection = new DocumentSection(i + "", document);
            documentSection.write("Данные для раздела номер " + i);
            documentSections[i] = documentSection;
        }

        ExecutorService service = Executors.newFixedThreadPool(SIZE_OF_THREADS);

        for (DocumentSection documentSection : documentSections) {
            service.execute(new DocumentSectionProcessor(documentSection));
        }
        service.shutdown();

    }
}
