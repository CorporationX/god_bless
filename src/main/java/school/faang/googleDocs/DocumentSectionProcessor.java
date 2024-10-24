package school.faang.googleDocs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;

    public String process(String data) {
        return data.toUpperCase();
    }

    @Override
    public void run() {
        String data = section.read();
        String processedData = process(data);
        section.write(processedData);
        System.out.println("Processed data: " + processedData);
    }
}
