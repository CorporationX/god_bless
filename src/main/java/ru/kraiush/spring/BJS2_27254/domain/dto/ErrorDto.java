package ru.kraiush.spring.BJS2_27254.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder(builderMethodName = "init", setterPrefix = "set")
@Getter
public class ErrorDto {

    private final boolean success;

    private final String uri;

    private final int code;

    private final String title;

    private final String description;

    private final String message;

    private final List<String> stackTrace;
}
