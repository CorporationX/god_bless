package faang.school.godbless.kxnvg.googledocs;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class DocumentSection {

    private String id;
    @Setter
    private String data;
    private ConcurrentHashMap<String, String> document;

    public DocumentSection(String id, String data) {
        this.id = id;
        this.data = data;
        document = CollaborativeDocument.getDocument();
    }

    public void writeContent() {
        document.put(id, data);
    }

    public String readContent(String id) {
        return document.get(id);
    }

    public String getSectionInfo() {
        return id + " : " + data;
    }
}
