package ru.kraiush.spring.exception.model;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder(builderMethodName = "init", setterPrefix = "set")
@Getter
public class ErrorDto {

	private final boolean success;

	private final String uri;

	private final UUID uuid;

	private final int code;

	private final String title;

	private final String description;

	private final String message;

	private final List<String> stackTrace;
}


