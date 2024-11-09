package school.faang.report;

public class Sales {
    private String productId;
    private long timestamp;
    private int quantity;

    public Sales(String productId, long timestamp, int quantity) {
        this.productId = productId;
        this.timestamp = timestamp;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getQuantity() {
        return quantity;
    }
}

