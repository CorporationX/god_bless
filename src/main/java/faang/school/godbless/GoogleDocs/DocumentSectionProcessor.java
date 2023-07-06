package faang.school.godbless.GoogleDocs;

public class DocumentSectionProcessor implements Runnable {
    DocumentSection documentSection;

    public DocumentSectionProcessor(DocumentSection documentSection) {
        this.documentSection = documentSection;
    }

    @Override
    public void run() {
        String content = documentSection.readContent();
        documentSection.writeContent(content.toUpperCase());
    }
}
