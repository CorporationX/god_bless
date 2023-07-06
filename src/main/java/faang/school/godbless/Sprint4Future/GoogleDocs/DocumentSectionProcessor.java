package faang.school.godbless.Sprint4Future.GoogleDocs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {

    private DocumentSection documentSection;

    @Override
    public void run() {
        documentSection.addData(documentSection.getData().toUpperCase());
    }
}
