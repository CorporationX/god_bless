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
        Optional<TeamMember> existingUser = repository.findByName(user.getName());
        if (existingUser.isPresent()) {
            throw new ResourceAlreadyExistsException("SUCH OBJECT ALREADY EXISTS- " + user.getName());
        } else {
            Optional<TeamMember> existingUserEmail = repository.findByEmail(user.getEmail());
            if (existingUserEmail.isPresent()) {
                throw new ResourceAlreadyExistsException("OBJECT WITH SUCH EMAIL ALREADY EXISTS - " + user.getEmail());
            } else
                return repository.save(user);
        }
    }

    @Override
    public TeamMember update(TeamMember user) {
        TeamMember existingUser = repository.findById(user.getId())
                .orElse(null);
        if (existingUser == null)
            throw new ResourceNotFoundException("NO SUCH OBJECT EXISTS!");
        else
            return repository.save(user);
    }

    @Override
    public String findRoleById(Long id) {
        Optional<TeamMember> memberOptional = findById(id);
        if (memberOptional.isEmpty()) {
            log.info("No such role found!");
        }
        return repository.findRoleById(id);
    }

    @Override
    public void deleteById(long id) {
        TeamMember existingUser = repository.findById(id)
                .orElse(null);
        if (existingUser == null)
            throw new ResourceNotFoundException("NO SUCH OBJECT EXISTS WIT ID - " + id);
        else
            repository.deleteById(id);
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
