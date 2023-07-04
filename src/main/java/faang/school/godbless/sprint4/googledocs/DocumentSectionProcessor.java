package faang.school.godbless.sprint4.googledocs;

public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection documentSection;

    public DocumentSectionProcessor(DocumentSection section) {
        this.documentSection = section;
    }

    public void run() {
        String content = documentSection.readContent().toUpperCase();
        documentSection.writeContent(content);
    }
}
