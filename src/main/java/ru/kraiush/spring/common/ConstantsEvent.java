package ru.kraiush.spring.common;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConstantsEvent {

    @NoArgsConstructor(access = PRIVATE)
    public static final class eventItemsExceptionMessage {

        public static final String EVENT_LIST_EXCEPTION = "Error getting event list";

        public static final String EVENT_ITEM_EXCEPTION = "Error getting event with id: ";

        public static final String EVENT_CREATE_EXCEPTION = "Error creating event";

        public static final String EVENT_UPDATE_EXCEPTION = "Error updating event";

        public static final String EVENT_DELETE_EXCEPTION = "Error deleting event";

        public static final String EVENT_DELETE_ALL_EXCEPTION = "Error deleting all events";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class ErrorMessage {

        public static final String EVENT_ALREADY_EXISTS = "event already exists: ";
    }
}
