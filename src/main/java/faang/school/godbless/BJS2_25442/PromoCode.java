package faang.school.godbless.BJS2_25442;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PromoCode {
    private String code;
    private double discount;
    private LocalDate expirationDate;
    private double minimumOrderValue;
    private boolean isUsed;

    public PromoCode(String code, double discount, LocalDate expirationDate, double minimumOrderValue) {
        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.minimumOrderValue = minimumOrderValue;
        isUsed = false;
    }

    public void setPromoCodeAsUsed() {
        isUsed = true;
    }

    public boolean isValidForOrder(double totalSum) {
        return expirationDate.isAfter(LocalDate.now()) && minimumOrderValue < totalSum && !isUsed;
    }
}
