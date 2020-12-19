package com.imona.gameserver.repository;

import com.imona.gameserver.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Long> {



}
