package com.imona.gameserver.controller;


import com.imona.gameserver.entity.Player;
import com.imona.gameserver.model.PlayerRequest;
import com.imona.gameserver.model.PlayerResponse;
import com.imona.gameserver.repository.PlayerRepository;
import net.bytebuddy.implementation.auxiliary.PrivilegedMemberLookupAction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/player/{gameId}")
    public List<PlayerResponse> getPlayers(@PathVariable Long gameId) {
        List<Player> entities = playerRepository.findByGameId(gameId);
        List<PlayerResponse> models = new ArrayList<>();
        for (Player entity : entities) {
            PlayerResponse model = new PlayerResponse();
            BeanUtils.copyProperties(entity, model);
            models.add(model);
        }
        return models;
    }

    @PostMapping("/player")
    public void addPlayer(@RequestBody @Valid PlayerRequest playerRequest) {
        Player player = new Player();
        BeanUtils.copyProperties(playerRequest, player);
        playerRepository.save(player);
    }

    @PutMapping("/player/{playerId}")
    public void editPlayer(@RequestBody @Valid PlayerRequest playerRequest, @PathVariable Long playerId) {
        Player playerEntity = getPlayer(playerId);
        BeanUtils.copyProperties(playerRequest,playerEntity);
        playerRepository.save(playerEntity);
    }

    @DeleteMapping("/player/{playerId}")
    public void deletePlayer(@PathVariable Long playerId){
        playerRepository.delete(getPlayer(playerId));
    }

    private Player getPlayer(Long playerId){
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            throw new NullPointerException();
        }
        return player.get();
    }
}
