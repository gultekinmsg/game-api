package com.imona.gameserver.controller;


import com.imona.gameserver.entity.Player;
import com.imona.gameserver.model.PlayerResponse;
import com.imona.gameserver.repository.PlayerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/player/{gameId}")
    public List<PlayerResponse> getPlayers(@PathVariable Long gameId){
        List<Player> entities = playerRepository.findByGameId(gameId);
        List<PlayerResponse> models = new ArrayList<>();
        for (Player entity : entities) {
            PlayerResponse model = new PlayerResponse();
            BeanUtils.copyProperties(entity,model);
            models.add(model);
        }
        return models;
    }
}

