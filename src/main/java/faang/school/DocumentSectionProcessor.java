package faang.school;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable{
    private final DocumentSection doc;
    @Override
    public void run() {
        var content = doc.readContent().toUpperCase();
        doc.writeContent(content);
    }
}
