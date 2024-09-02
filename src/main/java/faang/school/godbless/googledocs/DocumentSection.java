package faang.school.godbless.googledocs;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DocumentSection {
    private final String id;
    private final CollaborativeDocument document;

    public void writeContent(String content) {
        this.document.addSectionData(id, content);
    }

    public String readContent() {
        return this.document.getSectionData(id);
    }
}