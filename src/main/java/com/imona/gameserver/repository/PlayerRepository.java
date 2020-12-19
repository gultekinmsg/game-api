package com.imona.gameserver.repository;

import com.imona.gameserver.entity.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player,Long> {
    List<Player> findByGameId(Long gameId);
}
