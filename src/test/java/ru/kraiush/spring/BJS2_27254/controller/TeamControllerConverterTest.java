package ru.kraiush.spring.BJS2_27254.controller;

import org.junit.jupiter.api.Test;
import ru.kraiush.spring.BJS2_27254.domain.dto.PhoneDto;
import ru.kraiush.spring.BJS2_27254.domain.dto.TeamMemberDto;
import ru.kraiush.spring.BJS2_27254.domain.model.Phone;
import ru.kraiush.spring.BJS2_27254.domain.model.Role;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.util.MapperUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamControllerConverterTest {

    @Test
    void checkConvertDtoToEntity() {
        TeamMemberDto memberDto = new TeamMemberDto();
        memberDto.setId(new Random().nextLong(1, 10000));
        memberDto.setName(randomAlphabetic(10));
        memberDto.setGender(false);
        memberDto.setEmail("hetaera@olymp.gc");
        memberDto.setAge(new Random().nextInt(1, 1000));
        memberDto.setLocation(randomAlphabetic(10));
        memberDto.setLastDate(LocalDateTime.of(2024, 1, 1, 1, 0, 0, 0));
        memberDto.setRole(Role.ROLE_DB);

        List<PhoneDto> listPhonesDto = new ArrayList<>();
        listPhonesDto.add(new PhoneDto(new Random().nextLong(1000, 2000), new Random().nextInt(1000, 100000)));
        listPhonesDto.add(new PhoneDto(new Random().nextLong(1000, 2000), new Random().nextInt(1000, 100000)));
        memberDto.setPhones(listPhonesDto);

        TeamMember teamMember = MapperUtil.convertClass(memberDto, TeamMember.class);
        assertEquals(memberDto.getId(), teamMember.getId());
        assertEquals(memberDto.getName(), teamMember.getName());
        assertEquals(memberDto.isGender(), teamMember.isGender());
        assertEquals(memberDto.getEmail(), teamMember.getEmail());
        assertEquals(memberDto.getAge(), teamMember.getAge());
        assertEquals(memberDto.getLocation(), teamMember.getLocation());
        assertEquals(memberDto.getLastDate(), teamMember.getLastDate());
        assertEquals(memberDto.getRole(), teamMember.getRole());
        assertEquals(memberDto.getPhones().get(0).getId(), teamMember.getPhones().get(0).getId());
        assertEquals(memberDto.getPhones().get(0).getPhone(), teamMember.getPhones().get(0).getPhone());
        assertEquals(memberDto.getPhones().get(1).getId(), teamMember.getPhones().get(1).getId());
        assertEquals(memberDto.getPhones().get(1).getPhone(), teamMember.getPhones().get(1).getPhone());
    }

    @Test
    void checkConvertEntityToDto() {
        TeamMember member = new TeamMember();
        member.setId(new Random().nextLong(1, 10000));
        member.setName(randomAlphabetic(10));
        member.setGender(false);
        member.setEmail("hetaera@olymp.gc");
        member.setAge(new Random().nextInt(1, 1000));
        member.setLocation(randomAlphabetic(10));
        member.setLastDate(LocalDateTime.of(2024, 1, 1, 1, 0, 0, 0));
        member.setRole(Role.ROLE_DB);

        List<Phone> listPhones = new ArrayList<>();
        listPhones.add(new Phone(new Random().nextLong(1000, 2000), new Random().nextInt(1000, 100000)));
        listPhones.add(new Phone(new Random().nextLong(1000, 2000), new Random().nextInt(1000, 100000)));
        member.setPhones(listPhones);

        TeamMemberDto memberDto = MapperUtil.convertClass(member, TeamMemberDto.class);
        assertEquals(memberDto.getId(), member.getId());

        assertEquals(member.getId(), memberDto.getId());
        assertEquals(member.getName(), memberDto.getName());
        assertEquals(member.isGender(), memberDto.isGender());
        assertEquals(member.getEmail(), memberDto.getEmail());
        assertEquals(member.getAge(), memberDto.getAge());
        assertEquals(member.getLocation(), memberDto.getLocation());
        assertEquals(member.getLastDate(), memberDto.getLastDate());
        assertEquals(member.getRole(), memberDto.getRole());
        assertEquals(member.getPhones().get(0).getId(), memberDto.getPhones().get(0).getId());
        assertEquals(member.getPhones().get(0).getPhone(), memberDto.getPhones().get(0).getPhone());
        assertEquals(member.getPhones().get(1).getId(), memberDto.getPhones().get(1).getId());
        assertEquals(member.getPhones().get(1).getPhone(), memberDto.getPhones().get(1).getPhone());
    }
}
