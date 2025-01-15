package school.faang.task_51234;

public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;

    public DocumentSectionProcessor(DocumentSection section) {
        this.section = section;
    }

    public void process(String data) {
        String processedData = data.toUpperCase();
        section.write(processedData);
    }

    @Override
    public void run() {
        System.out.println("Processing section: " + section.read());
        process("new content for section " + section.read());
        System.out.println("Updated section content: " + section.read());
    }
}
