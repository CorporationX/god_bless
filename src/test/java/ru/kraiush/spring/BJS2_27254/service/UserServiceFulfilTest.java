package ru.kraiush.spring.BJS2_27254.service;

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

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalMatchers.and;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("service UserServiceFulfil")
class UserServiceFulfilTest {

    @InjectMocks
    private UserServiceFulfil service;
    @Mock
    private UserRepository repository;

    @DisplayName("Should get user by name")
    @Test
    void getByName() {
        User user = createUser();
        given(repository.findByUsername(any())).willReturn(Optional.of(user));
        assertThat(repository.findByUsername("Adelina")).isNotNull();
        verify(repository).findByUsername(anyString());
        assertEquals(repository.findByUsername("Adelina").get().getId(), 3876l);
        verify(repository, times(2)).findByUsername(anyString());
        verify(repository, times(2)).findByUsername("Adelina");
    }

    @DisplayName("get access to the repository on the findAll()")
    @Test
    void shouldCallRepositoryOnFindAll() {
        when(repository.findAll()).thenReturn(emptyList());
        service.findAll();
        verify(repository, times(1)).findAll();
        assertNotNull(repository.findAll());
        assertThat(repository.findAll()).isInstanceOf(List.class);
        assertThat(service.findAll()).isInstanceOf(List.class);
        assertNotNull(service.findAll());
    }

    @DisplayName("should throw an exception if the id is not found")
    @Test
    void shouldThrowExceptionWhenNotFoundById() {
        when(repository.findById(any(Long.class)))
                .thenReturn(Optional.empty());
        assertThat(repository.findById(666l).isEmpty());
    }

    @Test
    void shouldCreateMember() {
        User user = createUser();
        when(repository.findByUsername(anyString())).thenReturn(Optional.of(user));
        assertThat(repository.findByUsername("Adelina")).isNotNull();
        assertThat(repository.findById(3876l).isPresent());
    }

    @Test
    void shouldSaveMember() {
        service.create(createUser());
        verify(repository).save(any());
        verify(repository).save(and(notNull(), argThat(p -> p.getId() == 3876l)));
    }

    private static User createUser() {
        return new User(3876l, "Nika", true, "nika@olymp.gc", "Olympus", 17, LocalDateTime.now(), Role.ROLE_USER, "password");
    }

}