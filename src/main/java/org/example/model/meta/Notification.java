package org.example.model.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;
}
