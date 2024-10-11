package ru.kraiush.spring.BJS2_27254.common;

import static lombok.AccessLevel.PRIVATE;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class Constants {

	@NoArgsConstructor(access = PRIVATE)
	public static final class ApiConstants {

		public static final String DATE_FORMAT_PATTERN = "dd.MM.yyyy";

		public static final String DATE_FORMAT_EXAMPLE = "21.12.2021";
	}

	@NoArgsConstructor(access = PRIVATE)
	public static final class Common {

		public static final String BASE_PACKAGE = "ru.kraiush.*";

		public static final String HTTP_PREFIX = "http://";
	}
}
