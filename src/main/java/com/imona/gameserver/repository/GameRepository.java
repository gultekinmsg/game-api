package com.imona.gameserver.repository;

import com.imona.gameserver.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}
