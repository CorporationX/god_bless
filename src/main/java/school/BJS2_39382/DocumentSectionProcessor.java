package school.BJS2_39382;

public class DocumentSectionProcessor implements Runnable{

    private DocumentSection section;

    public DocumentSectionProcessor(DocumentSection section) {
        this.section = section;
    }

    public String process(String data) {
        return data.toUpperCase();
    }

    @Override
    public void run() {
        String word = section.read();
        String upperWord = process(word);
        section.write(upperWord);
        section.printData();
    }
}
