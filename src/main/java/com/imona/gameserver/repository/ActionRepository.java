package com.imona.gameserver.repository;

import com.imona.gameserver.entity.Action;
import org.springframework.data.repository.CrudRepository;

public interface ActionRepository extends CrudRepository<Action, Long> {
}
