package faang.school.godbless.evtscatch;

public class StreamEvent {
    private Integer id;
    private String type;
    private String data;

    public StreamEvent(Integer id, String type, String data) {
        this.id = id;
        this.type = type;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
