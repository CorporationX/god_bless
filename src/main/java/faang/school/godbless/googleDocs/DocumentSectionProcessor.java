package faang.school.godbless.googleDocs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;
    private final String data;

    public void processData() {
        System.out.println("Processing data of section: " + section.getId());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Processing interrupted");
        }
        section.addDataToSection(data.toUpperCase());
    }

    @Override
    public void run() {
        processData();
    }
}
