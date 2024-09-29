package ru.kraiush.threads.BJS2_18351;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {

    private long id;

    private OrderType type;

}
