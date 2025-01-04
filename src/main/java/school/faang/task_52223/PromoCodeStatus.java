package school.faang.task_52223;

import lombok.Getter;

@Getter
public enum PromoCodeStatus {
    ACTIVE("Промокод активен."),
    REDEEMED("Промокод был использован."),
    INVALID("Промокод недействителен.");

    private String type;

    PromoCodeStatus(String type) {
        this.type = type;
    }

}
