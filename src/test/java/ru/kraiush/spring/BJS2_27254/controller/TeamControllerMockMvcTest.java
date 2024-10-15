package ru.kraiush.spring.BJS2_27254.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.service.TeamMemberServiceFulfil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("TeamController")
@WebMvcTest
class TeamControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    TeamMemberServiceFulfil service;

    //    @Test
    public void givenTeamMemberObject_whenCreateTeamMember_thenReturnSavedTeamMember() throws Exception {
        TeamMember member = createTeamMemberOne();
        given(service.create(any(TeamMember.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/api/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(member)));
        response.andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.name",
                        is(member.getName())))
                .andExpect(jsonPath("$.location",
                        is(member.getLocation())))
                .andExpect(jsonPath("$.email",
                        is(member.getEmail())));
    }

    //    @Test
    public void givenListOfTeamMembers_whenGetAllTeamMembers_thenReturnTeamMembersList() throws Exception {
        List<TeamMember> listOfTeamMembers = new ArrayList<>();
        listOfTeamMembers.add(createTeamMemberOne());
        listOfTeamMembers.add(createTeamMemberTwo());

        given(service.findAll()).willReturn(listOfTeamMembers);

        ResultActions response = mockMvc.perform(get("/api/members"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.size()",
                        is(listOfTeamMembers.size())));
    }

    //    @Test
    public void givenTeamMemberId_whenGetTeamMemberById_thenReturnTeamMemberObject() throws Exception {
        TeamMember member = createTeamMemberOne();
        Long id = member.getId();
        given(service.findById(id)).willReturn(Optional.of(member));
        ResultActions response = mockMvc.perform(get("/api/members/{id}", id));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(member.getName())))
                .andExpect(jsonPath("$.location", is(member.getLocation())))
                .andExpect(jsonPath("$.email", is(member.getEmail())))
                .andExpect(jsonPath("$.name").value("Artemis"))
                .andExpect(jsonPath("$.gender").value(true))
                .andExpect(jsonPath("$.location").value("Olympus"))
                .andExpect(jsonPath("$.email").value("artemis@olymp.gc"))
                .andExpect(jsonPath("$.age").value(1797))
                .andExpect(jsonPath("$.lastDate").value("2024-01-01T01:00:00"))
                .andExpect(jsonPath("$.role").value("ROLE_TEAMLEAD"));
    }

    //    @Test
    public void givenUpdatedTeamMember_whenUpdateTeamMember_thenReturnUpdateTeamMemberObject() throws Exception {
        TeamMember savedMember = createTeamMemberOne();
        Long memberId = savedMember.getId();

        TeamMember updMember = TeamMember.builder()
                .id(memberId)
                .name("Sonia")
                .location("India")
                .email("sonia@gmail.com")
                .build();

        given(service.findById(memberId)).willReturn(Optional.of(savedMember));
        given(service.update(any(TeamMember.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(put("/api/members/{id}", memberId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updMember)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(updMember.getName())))
                .andExpect(jsonPath("$.location", is(updMember.getLocation())))
                .andExpect(jsonPath("$.email", is(updMember.getEmail())));
    }

    //    @Test
    public void givenTeamMemberId_whenDeleteTeamMember_thenReturn200() throws Exception {
        TeamMember savedMember = createTeamMemberOne();
        Long memberId = savedMember.getId();
        willDoNothing().given(service).deleteById(memberId);
        ResultActions response = mockMvc.perform(delete("/api/members/{id}", memberId));
        response.andExpect(status().isOk())
                .andDo(print());
    }

    private static TeamMember createTeamMemberOne() {
        return TeamMember.builder()
                .id(3876l)
                .name("Artemis")
                .gender(true)
                .email("artemis@olymp.gc")
                .location("Olympus")
                .age(1797)
                .lastDate(LocalDateTime.of(2024, 1, 1, 1, 0, 0, 0))
                .role(Role.ROLE_TEAMLEAD)
                .build();
    }

    private static TeamMember createTeamMemberTwo() {
        return TeamMember.builder()
                .id(3876l)
                .name("Dayana")
                .gender(false)
                .email("dayana@olymp.gc")
                .location("Olympus")
                .age(19)
                .lastDate(LocalDateTime.now())
                .role(Role.ROLE_FAKE)
                .build();
    }
}