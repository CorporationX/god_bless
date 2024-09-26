package ru.kraiush.threads.BJS2_25570;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PromoCode {
    private String code;
    private int discount;
    private Date expirationDate;
    private BigDecimal minimumOrderValue;
    private volatile boolean isUsed;
}
