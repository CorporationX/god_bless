package school.faang.google_docs_BJS2_39364;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final int SECTIONS_COUNT = 5;

    public static void main(String[] args) {
        CollaborativeDocument collaborativeDoc = new CollaborativeDocument();
        List<DocumentSection> sections = new ArrayList<>();

        for (int i = 0; i < SECTIONS_COUNT; i++) {
            String title = "Section " + i;
            collaborativeDoc.addData(title, "Text " + i);
            sections.add(new DocumentSection(title, collaborativeDoc));
        }

        ArrayList<Thread> threads = new ArrayList<>();
        sections.forEach(documentSection ->
                threads.add(new Thread(new DocumentSectionProcessor(documentSection))));

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        sections.forEach(documentSection ->
                System.out.printf("Processed data of %s - %s\n", documentSection.getId(), documentSection.read()));
    }
}