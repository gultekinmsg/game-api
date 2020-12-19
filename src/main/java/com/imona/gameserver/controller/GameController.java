package com.imona.gameserver.controller;

import com.imona.gameserver.entity.Game;
import com.imona.gameserver.model.GameResponse;
import com.imona.gameserver.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {
    private final GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/game")
    public List<GameResponse>getGames(){
        List<Game> entities = gameRepository.findAll();
        List<GameResponse> models = new ArrayList<>();
        for (Game entity : entities) {
            GameResponse model = new GameResponse();
            BeanUtils.copyProperties(entity,model);
            models.add(model);
        }
        return models;
    }
}
