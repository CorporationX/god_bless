package school.faang.bjs251188;

public record DocumentSection(int id, CollaborativeDocument document) {
    public void write(String data) {
        document.addData(id, data);
    }

    public String read() {
        return document.getData(id);
    }
}