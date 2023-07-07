package faang.school.godbless.googleDocs;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        DocumentSection section1 = new DocumentSection("1", "aaa", document);
        DocumentSection section2 = new DocumentSection("2", "bbb", document);
        DocumentSection section3 = new DocumentSection("3", "ccc", document);
        DocumentSection section4 = new DocumentSection("4", "ddd", document);
        DocumentSection section5 = new DocumentSection("5", "eee", document);
        Set<DocumentSection> sections = new HashSet<>();
        sections.add(section1);
        sections.add(section2);
        sections.add(section3);
        sections.add(section4);
        sections.add(section5);
        DocumentSectionProcessor processor = new DocumentSectionProcessor(document);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Set<CompletableFuture<Void>> allFuturesADD = new HashSet<>();
        Set<CompletableFuture<Void>> allFuturesUP = new HashSet<>();

        for (var section : sections){
            allFuturesADD.add(CompletableFuture.runAsync(() -> {
                document.addSomething(section.getIdent(), section.getData());
                System.out.println(section.getData() + " added");
            }, executor));

        }
        CompletableFuture.allOf(allFuturesADD.toArray(new CompletableFuture[0])).join();
        System.out.println("Файлы добавлены");

        for (var section : sections){
            allFuturesUP.add(CompletableFuture.runAsync(() -> processor.upCase(section.getIdent()), executor));
        }
        CompletableFuture.allOf(allFuturesUP.toArray(new CompletableFuture[0])).join();
        System.out.println("Файлы изменены");
        document.getDocument().forEach((key, value) -> System.out.println(value));
        executor.shutdown();
    }
}
