package amazonorders;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PENDING("Pending"),
    PROCESSED("Processed"),
    FAILED("Failed");

    private final String description;

}
