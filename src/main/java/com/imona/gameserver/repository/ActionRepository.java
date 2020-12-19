package com.imona.gameserver.repository;

import com.imona.gameserver.entity.Action;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActionRepository extends CrudRepository<Action, Long> {
    List<Action> findByGameId(Long gameId);
}
