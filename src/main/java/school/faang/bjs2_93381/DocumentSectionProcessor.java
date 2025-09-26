package school.faang.bjs2_93381;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    DocumentSection documentSection;

    @Override
    public void run() {
        String temp = documentSection.read();
        process(temp);
    }

    public void process(String data) {
        documentSection.write(data.toUpperCase());
    }
}
