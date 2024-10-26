package school.faang.google_docs_BJS2_39364;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument collaborativeDoc = new CollaborativeDocument();

        List<DocumentSection> sections = new ArrayList<>(List.of(
                new DocumentSection("section-001", collaborativeDoc),
                new DocumentSection("section-002", collaborativeDoc),
                new DocumentSection("section-003", collaborativeDoc),
                new DocumentSection("section-004", collaborativeDoc)));

        collaborativeDoc.addData("section-001",
                "Introduction: This section provides an overview of the document's purpose and structure.");
        collaborativeDoc.addData("section-002",
                "Getting Started: Instructions on how to set up the necessary environment and initial configurations.");
        collaborativeDoc.addData("section-003",
                "Features: Detailed explanation of each feature, with examples and use cases.");
        collaborativeDoc.addData("section-004",
                "Troubleshooting: Common issues and solutions, including FAQs and contact information.");

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