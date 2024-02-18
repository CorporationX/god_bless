package lru;

class Data {
    private int id;
    private String value;
    private long timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void updateTimestamp() {
        this.timestamp = System.currentTimeMillis();
    }
}

