package school.faangSprint4.t19;

import lombok.Getter;

public record DocumentSection(@Getter String id, CollaborativeDocument document) {

    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}