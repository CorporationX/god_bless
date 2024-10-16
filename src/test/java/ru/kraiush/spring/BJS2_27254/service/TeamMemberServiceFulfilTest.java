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
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.exception.ElementAlreadyExistsException;
import ru.kraiush.spring.BJS2_27254.repository.TeamMemberRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.AdditionalMatchers.and;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("service TeamMemberServiceFulfil")
class TeamMemberServiceFulfilTest {

    @InjectMocks
    private TeamMemberServiceFulfil service;
    @Mock
    private TeamMemberRepository repository;

    private TeamMember user;

    @BeforeEach
    public void setup() {
        user = TeamMember.builder()
                .id(3876l)
                .name("Nika")
                .gender(false)
                .email("nika@olymp.gc")
                .location("Olympus")
                .age(17)
                .lastDate(LocalDateTime.now())
                .role(Role.ROLE_USER)
                .build();
    }

    @DisplayName("JUnit test for create() method")
    @Test
    void givenTeamMemberObject_whenSaveTeamMember_thenReturnTeamMemberObject() {
        given(repository.findByEmail(user.getEmail()))
                .willReturn(Optional.empty());
        given(repository.save(user)).willReturn(user);
        TeamMember savedTeamMember = service.create(user);
        assertThat(savedTeamMember).isNotNull();
        assertThat(repository.findByEmail("abra@cada.bra").isEmpty());
        assertThat(repository.findByName("Nika")).isNotNull();
        assertThat(repository.findById(3876l).isPresent());
        verify(repository).save(any());
        verify(repository).save(and(notNull(), argThat(p -> p.getId() == 3876l)));
    }

    @DisplayName("JUnit test for create method for existing element which throws exception")
    @Test
    public void givenExistingEmail_whenSaveTeamMember_thenThrowsException() {
        given(repository.findByEmail(user.getEmail()))
                .willReturn(Optional.of(user));
        assertThrows(ElementAlreadyExistsException.class, () -> {
            service.create(user);
        });
    }

    @DisplayName("JUnit test should return empty if the id is not found")
    @Test
    void shouldThrowExceptionWhenNotFoundById() {
        when(repository.findById(any(Long.class)))
                .thenReturn(Optional.empty());
        assertThat(repository.findById(666l).isEmpty());
    }

    @DisplayName("JUnit test for getAllTeamMembers method")
    @Test
    public void whenGetAllTeamMembers_thenReturnTeamMembersList() {
        TeamMember user2 = TeamMember.builder()
                .id(7876l)
                .name("Aloe")
                .gender(false)
                .email("aloe@olymp.gc")
                .location("Greece")
                .age(17)
                .lastDate(LocalDateTime.now())
                .role(Role.ROLE_USER)
                .build();

        given(repository.findAll()).willReturn(List.of(user, user2));
        List<TeamMember> userList = service.findAll();
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getById method")
    @Test
    public void givenTeamMemberId_whenGetTeamMemberById_thenReturnTeamMemberObject() {
        given(repository.findById(3876L)).willReturn(Optional.of(user));
        Optional<TeamMember> savedTeamMember = service.findById(user.getId());
        assertThat(savedTeamMember).isNotNull();
    }

    @DisplayName("JUnit test should get user by name")
    @Test
    void givenTeamMember_whenGetTeamMembername_thenReturnTeamMemberObject() {
        given(repository.findByName("Nika")).willReturn(Optional.of(user));
        assertThat(repository.findByName("Nika")).isNotNull();
        verify(repository).findByName(anyString());
        assertEquals(repository.findByName("Nika").get().getId(), 3876l);
        verify(repository, times(2)).findByName(anyString());
        verify(repository, times(2)).findByName("Nika");
    }

    @DisplayName("JUnit test for update() method")
    @Test
    public void givenTeamMemberObject_whenUpdateTeamMember_thenReturnUpdatedTeamMember() throws Exception {
        given(repository.findById(3876L)).willReturn(Optional.of(user));
        user.setEmail("crishna@gmail.in");
        user.setName("Rama");
        service.update(user);
        assertThat(user.getEmail()).isEqualTo("crishna@gmail.in");
        assertThat(user.getName()).isEqualTo("Rama");
    }

    @DisplayName("JUnit test for delete() method")
    @Test
    public void givenTeamMemberId_whenDeleteTeamMember_thenNothing() throws Exception {
        given(repository.findById(3876L)).willReturn(Optional.of(user));
        long userId = 3876L;
        willDoNothing().given(repository).deleteById(userId);
        service.deleteById(userId);
        verify(repository, times(1)).deleteById(userId);
    }
}