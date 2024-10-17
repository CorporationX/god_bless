package ru.kraiush.spring.BJS2_27254.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.exception.ResourceAlreadyExistsException;
import ru.kraiush.spring.BJS2_27254.exception.ResourceNotFoundException;
import ru.kraiush.spring.BJS2_27254.repository.TeamMemberRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamMemberServiceFulfil implements TeamMemberService {

    private final TeamMemberRepository repository;

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
            throw new ResourceNotFoundException("NO OBJECT PRESENT WITH ID = " + id);
    }

    public TeamMember create(TeamMember user) {
        TeamMember existingTeamMember = repository.findByEmail(user.getEmail())
                .orElse(null);
        if (existingTeamMember == null) {
            return repository.save(user);
        } else
            throw new ResourceAlreadyExistsException("OBJECT WITH SUCH EMAIL ALREADY EXISTS - " + user.getId());
    }

    public TeamMember getByTeamMemberName(String name) {
        return repository.findByName(name)
                .orElseThrow(
                        () -> new ResourceNotFoundException("NO OBJECT PRESENT WITH NAME - " + name));
    }

    @Override
    public TeamMember update(TeamMember user) {
        TeamMember existingTeamMember = repository.findById(user.getId())
                .orElse(null);
        if (existingTeamMember == null)
            throw new ResourceNotFoundException("NO SUCH USER EXISTS!");
        else
            return repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        TeamMember existingTeamMember = repository.findById(id)
                .orElse(null);
        if (existingTeamMember == null)
            throw new ResourceNotFoundException("NO SUCH OBJECT EXISTS!");
        else
            repository.deleteById(id);
    }

    @Override
    public String findRoleById(Long userID) {
        Optional<TeamMember> memberOptional = findById(userID);
        if (memberOptional.isEmpty()) {
            log.info("No member found!");
        }
        return repository.findRoleById(userID);
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
