package school.faang.googledocs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class App {
    private static final int COUNT_SECTIONS = 10;

    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        List<DocumentSection> sections = new ArrayList<>();
        for (int i = 0; i < COUNT_SECTIONS; i++) {
            sections.add(new DocumentSection(String.valueOf(i), document));
            document.addData(String.valueOf(i), "Text " + i);
        }

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (DocumentSection section : sections) {
            futures.add(CompletableFuture.runAsync(() ->
                    new DocumentSectionProcessor(section).run()));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (int i = 0; i < COUNT_SECTIONS; i++) {
            System.out.println(document.getData(String.valueOf(i)));
        }
    }
}