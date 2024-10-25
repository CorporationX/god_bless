package bjs2_37889;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private DocumentSection documentSection;

    @Override
    public void run() {
        String processedDocumentSectionContent = process(documentSection.read());
        documentSection.write(processedDocumentSectionContent);
    }

    private String process(String data) {
        return data.toUpperCase();
    }
}
