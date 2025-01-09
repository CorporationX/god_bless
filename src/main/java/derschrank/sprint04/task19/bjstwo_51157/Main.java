package derschrank.sprint04.task19.bjstwo_51157;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int COUNT_OF_SECTIONS = 1000;
    private static final int COUNT_PARALLEL_PROCESSORS = 10;

    public static void main(String[] args) {
        Document document = new CollaborativeDocument();
        List<Section> sections = new ArrayList<>();

        fillDocument(document, sections);
        System.out.println(document);
        System.out.println("Count of sections: " + document.getSize());

        System.out.println("\n\n\n");

        processDocument(document, sections);
        System.out.println(document);
        System.out.println("Count of sections: " + document.getSize());

    }

    private static void fillDocument(Document document, List<Section> sections) {
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        System.out.println("\n\n\nPROCESSING IS BEGAN");
        for (int i = 0; i < COUNT_OF_SECTIONS; i++) {
            final int id = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> new DocumentSection("Section #" + id, document)
                    )
                            .thenCompose(section ->
                                    CompletableFuture.runAsync(
                                            () -> {
                                                document.addData(
                                                        section.id(),
                                                        "String abcABC # " + id
                                                );
                                                sections.add(section);
                                            }
                                    ))
            );
        }
        futures.forEach(CompletableFuture::join);
        System.out.println("PROCESSING IS ENDED");
    }

    private static void processDocument(Document document, List<Section> sections) {
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (int i = 0; i < COUNT_PARALLEL_PROCESSORS; i++) {
            for (Section section : sections) {
                futures.add(
                        CompletableFuture.supplyAsync(
                                () -> new DocumentSectionProcessor(section)

                        )
                                .thenCompose(runnable ->
                                        CompletableFuture.runAsync(runnable)
                                )
                );
            }
        }
        futures.forEach(CompletableFuture::join);

    }
}
