package com.imona.gameserver.controller;

import com.imona.gameserver.model.GameRequest;
import com.imona.gameserver.model.GameResponse;
import com.imona.gameserver.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GameController {
    private final GameService gameService;
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game/{gameId}")
    public GameResponse getGame(@PathVariable Long gameId) {
        return gameService.findGameById(gameId);
    }

    @PostMapping("/game")
    public void createGame(@RequestBody @Valid GameRequest gameRequest){
        gameService.createGame(gameRequest);
    }
}
