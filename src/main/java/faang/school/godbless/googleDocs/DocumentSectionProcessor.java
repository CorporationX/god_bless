package faang.school.godbless.googleDocs;

public class DocumentSectionProcessor implements Runnable{
    private CollaborativeDocument document;

    public DocumentSectionProcessor(CollaborativeDocument document) {
        this.document = document;
    }

    @Override
    public void run() {
        for (var entry : document.getDocument().entrySet()){
            upCase(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void upCase(String key){
        document.addSomething(key, document.getFromDocument(key).toUpperCase());
    }
}
