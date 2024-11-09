package school.faang.report;
public class sales {
    public String productId;
    public long timestamp;
    public int quantity;

    public sales(String pid, long ts, int qty) {
        productId = pid;
        timestamp = ts;
        quantity = qty;
    }

    public String getID() {
        return productId;
    }

    public long Time() {
        return this.timestamp;
    }

    public int getQty() {
        return quantity;
    }
}
