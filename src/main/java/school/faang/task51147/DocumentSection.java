package school.faang.task51147;

public record DocumentSection(String id,
                              CollaborativeDocument document) {

    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}
