package com.imona.gameserver.controller;


import com.imona.gameserver.entity.Player;
import com.imona.gameserver.model.PlayerAddRequest;
import com.imona.gameserver.model.PlayerResponse;
import com.imona.gameserver.repository.PlayerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/player")
    public void addPlayer(@RequestBody @Valid PlayerAddRequest playerAddRequest){
        Player player = new Player();
        BeanUtils.copyProperties(playerAddRequest,player);
        playerRepository.save(player);
    }
   

}

