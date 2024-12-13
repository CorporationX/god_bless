package ru.maks1979.task_46427;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Image {
    @Setter
    private String name;
    @Setter
    private String description;
}

