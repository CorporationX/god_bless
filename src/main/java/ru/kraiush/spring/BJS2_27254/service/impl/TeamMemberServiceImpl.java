package ru.kraiush.spring.BJS2_27254.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraiush.spring.BJS2_27254.exception.MemberException;
import ru.kraiush.spring.BJS2_27254.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.repository.TeamMemberRepository;
import ru.kraiush.spring.BJS2_27254.service.TeamMemberService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.kraiush.spring.BJS2_27254.common.ConstantsMember.ErrorMessage.MEMBER_ALREADY_EXISTS;
import static ru.kraiush.spring.BJS2_27254.common.ConstantsMember.eventItemsExceptionMessage.*;

@Service
@RequiredArgsConstructor
public class TeamMemberServiceImpl implements TeamMemberService {

    private TeamMemberRepository repository;
    private static final Logger log = LoggerFactory.getLogger(TeamMemberServiceImpl.class);

    @Autowired
    public TeamMemberServiceImpl(TeamMemberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public List<TeamMember> findAll() {
        List<TeamMember> listMembers = repository.findAll();
        if (listMembers.isEmpty()) {
            log.info("No elements found!");
        } else {
            return listMembers.stream()
                    .sorted(Comparator.comparing(TeamMember::getId))
                    .collect(Collectors.toList());
        }
        return listMembers;
    }

    @Transactional
    @Override
    public TeamMember findById(long id) {
        Optional<TeamMember> element = repository.findById(id);
        if (element.isPresent()) {
            return element.get();
        } else {
            log.info("The element wasn't found!");
            return null;
        }
    }

    @Override
    public TeamMember create(TeamMember entity) {
        try {
            Optional<TeamMember> eventOptional = repository.findById(entity.getId());
            if (eventOptional.isEmpty()) {
                return repository.save(entity);
            } else {
                throw new MemberException(MEMBER_ALREADY_EXISTS + entity.getId());
            }
        } catch (final RuntimeException e) {
            throw new MemberException(MEMBER_CREATE_EXCEPTION, e);
        }
    }

    @Override
    public void update(TeamMember event) {
        try {
            repository.save(event);
        } catch (final Exception e) {
            throw new MemberException(MEMBER_UPDATE_EXCEPTION, e);
        }
    }

    @Override
    public void deleteById(final long id) {
        try {
            repository.deleteById(id);
        } catch (final Exception e) {
            throw new MemberException(MEMBER_DELETE_EXCEPTION, e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            repository.deleteAll();
        } catch (final Exception e) {
            throw new MemberException(MEMBER_DELETE_ALL_EXCEPTION, e);
        }
    }
}
