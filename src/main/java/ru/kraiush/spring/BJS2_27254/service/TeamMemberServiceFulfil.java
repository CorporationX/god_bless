package ru.kraiush.spring.BJS2_27254.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.exception.ElementAlreadyExistsException;
import ru.kraiush.spring.BJS2_27254.exception.ElementNotFoundException;
import ru.kraiush.spring.BJS2_27254.repository.TeamMemberRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TeamMemberServiceFulfil implements TeamMemberService {

    private final TeamMemberRepository repository;

    public TeamMemberServiceFulfil(TeamMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TeamMember> findAll() {
        List<TeamMember> listMembers = repository.findAll();
        if (listMembers.isEmpty()) {
            log.info("No elements found!");
        }
        return listMembers;
    }

    @Override
    public Optional<TeamMember> findById(long id) {
        Optional<TeamMember> optionalMember = repository.findById(id);
        if (optionalMember.isPresent()) {
            return optionalMember;
        } else
            throw new ElementNotFoundException("NO PARTY PRESENT WITH ID = " + id);
    }

    public TeamMember create(TeamMember user) {
        TeamMember existingTeamMember = repository.findByEmail(user.getEmail())
                .orElse(null);
        if (existingTeamMember == null) {
            return repository.save(user);
        } else
            throw new ElementAlreadyExistsException("PARTY WITH SUCH EMAIL ALREADY EXISTS - " + user.getId());
    }

    public TeamMember getByTeamMemberName(String name) {
        return repository.findByName(name)
                .orElseThrow(
                        () -> new ElementNotFoundException("NO PARTY PRESENT WITH NAME - " + name));
    }

    @Override
    public TeamMember update(TeamMember user) {
        TeamMember existingTeamMember = repository.findById(user.getId())
                .orElse(null);
        if (existingTeamMember == null)
            throw new ElementNotFoundException("NO SUCH USER EXISTS!");
        else
            return repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        TeamMember existingTeamMember = repository.findById(id)
                .orElse(null);
        if (existingTeamMember == null)
            throw new ElementNotFoundException("NO SUCH PARTY EXISTS!");
        else
            repository.deleteById(id);
    }

    @Override
    public String findRoleByName(String name) {
        TeamMember member = getByTeamMemberName(name);
        if (member == null) {
            log.info("No member found!");
        }
        return repository.findRoleByName(name);
    }

    @Override
    public void deleteAll() {
        List<TeamMember> listMembers = repository.findAll();
        if (listMembers.isEmpty()) {
            log.info("No elements for deleting found!");
        } else
            repository.deleteAll();
    }
}
