package ru.kraiush.spring.BJS2_27254.common;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConstantsMember {

    @NoArgsConstructor(access = PRIVATE)
    public static final class eventItemsExceptionMessage {

        public static final String MEMBER_LIST_EXCEPTION = "Error getting members list";

        public static final String MEMBER_ITEM_EXCEPTION = "Error getting member with id: ";

        public static final String MEMBER_CREATE_EXCEPTION = "Error creating member";

        public static final String MEMBER_UPDATE_EXCEPTION = "Error updating member";

        public static final String MEMBER_DELETE_EXCEPTION = "Error deleting member";

        public static final String MEMBER_DELETE_ALL_EXCEPTION = "Error deleting all members";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class ErrorMessage {

        public static final String MEMBER_ALREADY_EXISTS = "member already exists: ";
    }
}
