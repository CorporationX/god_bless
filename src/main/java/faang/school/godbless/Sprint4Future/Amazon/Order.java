package faang.school.godbless.Sprint4Future.Amazon;


import lombok.Data;

@Data
public class Order {
    private static int id = 1;
    private String status;

    public Order(String status) {
        this.status = status;
        id++;
    }
}
