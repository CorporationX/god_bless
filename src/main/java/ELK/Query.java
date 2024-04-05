package ELK;

public class Query {
    private int id;
    private String content;
    private String timestamp;

    public Query(int id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String timestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
