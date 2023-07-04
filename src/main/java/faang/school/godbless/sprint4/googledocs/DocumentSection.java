package faang.school.godbless.sprint4.googledocs;


public class DocumentSection {
    private final String id;
    private final CollaborativeDocument documents;

    public DocumentSection(String id, CollaborativeDocument document) {
        this.id = id;
        this.documents = document;
    }

    public void writeContent(String content) {
        documents.addDataToSection(id, content);
    }

    public String readContent() {
        return documents.getDataFromSection(id);
    }
}
