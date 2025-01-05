package derschrank.sprint04.task19.bjstwo_51157;

public record DocumentSection(
        String id,
        Document document
) implements Section {
    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
}
