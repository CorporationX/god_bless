package faang.school.godbless.BJS2_25370;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class DocumentSection {
    private final int id;
    private StringBuilder content = new StringBuilder();

    public String read() {
        return content.toString();
    }

    public DocumentSection write(String content) {
        this.content.append(content);
        return this;
    }

    public String clear() {
        String content = this.content.toString();
        this.content.setLength(0);
        return content;
    }
}
