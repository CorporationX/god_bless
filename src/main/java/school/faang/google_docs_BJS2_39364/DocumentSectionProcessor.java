package school.faang.google_docs_BJS2_39364;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private DocumentSection section;

    @Override
    public void run() {
        section.write(process(section.read()));
    }

    public String process(String data) {
        return data.toUpperCase();
    }
}