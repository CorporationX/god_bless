package ru.kraiush.spring.BJS2_27254.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.User;
import ru.kraiush.spring.BJS2_27254.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.and;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("service UserServiceFulfil")
class UserServiceFulfilTest {

    @InjectMocks
    private UserServiceFulfil service;
    @Mock
    private UserRepository repository;

    private User user;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .id(3876l)
                .username("Adelina")
                .gender(false)
                .email("nika@olymp.gc")
                .location("Olympus")
                .age(17)
                .lastDate(LocalDateTime.now())
                .password("pass")
                .role(Role.ROLE_USER)
                .build();
    }

    @DisplayName("JUnit test for create() method")
    @Test
    void givenUserObject_whenSaveUser_thenReturnUserObject() {
        given(repository.findByEmail(user.getEmail()))
                .willReturn(Optional.empty());
        given(repository.save(user)).willReturn(user);
        // when -  action or the behaviour that we are going test
        User savedUser = service.create(user);
        // then - verify the output
        assertThat(savedUser).isNotNull();
        verify(repository).save(any());
        verify(repository).save(and(notNull(), argThat(p -> p.getId() == 3876l)));
    }

    @DisplayName("JUnit test for save method which throws exception")
    @Test
    public void givenExistingEmail_whenSaveUser_thenThrowsException() {
        when(repository.findByEmail(any(String.class)))
                .thenReturn(Optional.empty());
        assertThat(repository.findByEmail("abra@cada.bra").isEmpty());
        assertThat(repository.findByUsername("Adelina")).isNotNull();
        assertThat(repository.findById(3876l).isPresent());
        verify(repository, never()).save(any(User.class));
    }

    @DisplayName("JUnit test should throw an exception if the id is not found")
    @Test
    void shouldThrowExceptionWhenNotFoundById() {
        when(repository.findById(any(Long.class)))
                .thenReturn(Optional.empty());
        assertThat(repository.findById(666l).isEmpty());
    }

    @DisplayName("JUnit test for getAllUsers method")
    @Test
    public void whenGetAllUsers_thenReturnUsersList() {
        User user2 = User.builder()
                .id(3876l)
                .username("Adelina")
                .gender(false)
                .email("nika@olymp.gc")
                .location("Olympus")
                .age(17)
                .lastDate(LocalDateTime.now())
                .password("pass")
                .role(Role.ROLE_USER)
                .build();

        given(repository.findAll()).willReturn(List.of(user, user2));
        List<User> userList = service.findAll();
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getById method")
    @Test
    public void givenUserId_whenGetUserById_thenReturnUserObject() {
        given(repository.findById(3876L)).willReturn(Optional.of(user));
        User savedUser = service.findById(user.getId());
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Should get user by name")
    @Test
    void getByName() {
        given(repository.findByUsername("Adelina")).willReturn(Optional.of(user));
        assertThat(repository.findByUsername("Adelina")).isNotNull();
        verify(repository).findByUsername(anyString());
        assertEquals(repository.findByUsername("Adelina").get().getId(), 3876l);
        verify(repository, times(2)).findByUsername(anyString());
        verify(repository, times(2)).findByUsername("Adelina");
    }

    @DisplayName("JUnit test for update() method")
    @Test
    public void givenUserObject_whenUpdateUser_thenReturnUpdatedUser() {
        given(repository.findById(3876L)).willReturn(Optional.of(user));
        user.setEmail("crishna@gmail.in");
        user.setUsername("Rama");
        service.update(user);
        assertThat(user.getEmail()).isEqualTo("crishna@gmail.in");
        assertThat(user.getUsername()).isEqualTo("Rama");
    }

    @DisplayName("JUnit test for delete() method")
    @Test
    public void givenUserId_whenDeleteUser_thenNothing() {
        given(repository.findById(3876L)).willReturn(Optional.of(user));
        long userId = 3876L;
        willDoNothing().given(repository).deleteById(userId);
        service.deleteById(userId);
        verify(repository, times(1)).deleteById(userId);
    }
}