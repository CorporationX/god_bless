package ru.kraiush.spring.BJS2_27254.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.User;
import ru.kraiush.spring.BJS2_27254.exception.ElementAlreadyExistsException;
import ru.kraiush.spring.BJS2_27254.exception.ElementNotFoundException;
import ru.kraiush.spring.BJS2_27254.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.AdditionalMatchers.and;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
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
                .username("Nika")
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
        User savedUser = service.create(user);
        assertThat(savedUser).isNotNull();
        assertThat(repository.findByEmail("abra@cada.bra").isEmpty());
        assertThat(repository.findByUsername("Nika")).isNotNull();
        assertThat(repository.findById(3876l).isPresent());
        verify(repository).save(any());
        verify(repository).save(and(notNull(), argThat(p -> p.getId() == 3876l)));
    }

    @DisplayName("JUnit test for create method for existing element which throws exception")
    @Test
    public void givenExistingEmail_whenSaveUser_thenThrowsException() {
        given(repository.findByEmail(user.getEmail()))
                .willReturn(Optional.of(user));
        assertThrows(ElementAlreadyExistsException.class, () -> {
            service.create(user);
        });
    }

    @DisplayName("JUnit test for update() method which throws exception")
    @Test
    public void givenNotExistedUser_whenUpdate_thenThrowsException() {
        given(repository.findById(9991L)).willReturn(Optional.of(user));
        assertThrows(ElementNotFoundException.class, () -> {
            service.update(user);
        });
        verify(repository, never()).save(any(User.class));
    }

    @DisplayName("JUnit test should return empty if the id is not found")
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
                .id(7876l)
                .username("Aloe")
                .gender(false)
                .email("aloe@olymp.gc")
                .location("Greece")
                .age(17)
                .lastDate(LocalDateTime.now())
                .password("pass213")
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

    @DisplayName("JUnit test should get user by name")
    @Test
    void givenUser_whenGetUsername_thenReturnUserObject() {
        given(repository.findByUsername("Nika")).willReturn(Optional.of(user));
        assertThat(repository.findByUsername("Nika")).isNotNull();
        verify(repository).findByUsername(anyString());
        assertEquals(repository.findByUsername("Nika").get().getId(), 3876l);
        verify(repository, times(2)).findByUsername(anyString());
        verify(repository, times(2)).findByUsername("Nika");
    }

    @DisplayName("JUnit test for update() method")
    @Test
    public void givenUserObject_whenUpdateUser_thenReturnUpdatedUser() throws Exception {
        given(repository.findById(3876L)).willReturn(Optional.of(user));
        user.setEmail("crishna@gmail.in");
        user.setUsername("Rama");
        service.update(user);
        assertThat(user.getEmail()).isEqualTo("crishna@gmail.in");
        assertThat(user.getUsername()).isEqualTo("Rama");
    }

    @DisplayName("JUnit test for delete() method")
    @Test
    public void givenUserId_whenDeleteUser_thenNothing() throws Exception {
        given(repository.findById(3876L)).willReturn(Optional.of(user));
        long userId = 3876L;
        willDoNothing().given(repository).deleteById(userId);
        service.deleteById(userId);
        verify(repository, times(1)).deleteById(userId);
    }
}