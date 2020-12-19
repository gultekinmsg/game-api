package com.imona.gameserver.repository;

import com.imona.gameserver.entity.Game;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAll();
}
