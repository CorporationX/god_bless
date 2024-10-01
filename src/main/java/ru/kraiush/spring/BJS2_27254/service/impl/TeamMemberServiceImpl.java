package ru.kraiush.spring.BJS2_27254.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraiush.spring.BJS2_27254.exception.MemberException;
import ru.kraiush.spring.BJS2_27254.model.TeamMember;
import ru.kraiush.spring.BJS2_27254.repository.TeamMemberRepository;
import ru.kraiush.spring.BJS2_27254.service.TeamMemberService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.kraiush.spring.BJS2_27254.common.ConstantsMember.ErrorMessage.MEMBER_ALREADY_EXISTS;
import static ru.kraiush.spring.BJS2_27254.common.ConstantsMember.eventItemsExceptionMessage.*;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamMemberServiceImpl implements TeamMemberService {

    private TeamMemberRepository repository;

    @Autowired
    public TeamMemberServiceImpl(TeamMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TeamMember> findAll() {
        try {
            List<TeamMember> listMembers = repository.findAll();
            return listMembers.stream()
                    .sorted((o1, o2) -> o1.getId().compareTo(o2.getId()))
                    .collect(Collectors.toList());
        } catch (final Exception e) {
            throw new MemberException(MEMBER_LIST_EXCEPTION, e);
        }
    }

    @Override
    public TeamMember findById(long id) {
        try {
            return repository.findById(id).stream()
                    .findAny()
                    .orElseThrow(RuntimeException::new);
        } catch (final RuntimeException e) {
            throw new MemberException(MEMBER_ITEM_EXCEPTION + id, e);
        }
    }

    @Override
    public TeamMember create(TeamMember entity) {
        try {
            Optional<TeamMember> eventOptional = repository.findById(entity.getId());
            if (eventOptional == null) {
                return repository.save(entity);
            } else {
                throw new MemberException(MEMBER_ALREADY_EXISTS + entity.getId());
            }
        } catch (final RuntimeException e) {
            throw new MemberException(MEMBER_CREATE_EXCEPTION, e);
        }
    }

    @Override
    @Transactional
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
