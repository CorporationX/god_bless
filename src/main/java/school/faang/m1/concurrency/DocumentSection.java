package school.faang.m1.concurrency;

public record DocumentSection(String id, CollaborativeDocument document) {
    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}
