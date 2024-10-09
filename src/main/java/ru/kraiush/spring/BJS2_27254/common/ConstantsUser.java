package ru.kraiush.spring.BJS2_27254.common;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConstantsUser {

    public static final String USER_CREATE_EXCEPTION = "Error creating user";
    public static final String USER_GET_EXCEPTION = "The user wasn't found: ";
    public static final String USER_UPDATE_EXCEPTION = "Error updating user";
    public static final String USER_DELETE_EXCEPTION = "Error deleting user";
    public static final String USER_DELETE_ALL_EXCEPTION = "Error deleting all users";

    @NoArgsConstructor(access = PRIVATE)
    public static final class ErrorMessage {
        public static final String USER_ALREADY_EXISTS = "User already exists: ";
        public static final String USER_EMAIL_ALREADY_EXISTS = "User's email already exists: ";
    }
}
