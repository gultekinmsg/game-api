package com.imona.gameserver.service;

import com.imona.gameserver.entity.Action;
import com.imona.gameserver.entity.Game;
import com.imona.gameserver.entity.Player;
import com.imona.gameserver.model.ActionRequest;
import com.imona.gameserver.model.GameRequest;
import com.imona.gameserver.model.GameResponse;
import com.imona.gameserver.model.PlayerRequest;
import com.imona.gameserver.repository.ActionRepository;
import com.imona.gameserver.repository.GameRepository;
import com.imona.gameserver.repository.PlayerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final ActionRepository actionRepository;

    @Autowired
    public GameService(GameRepository gameRepository,
                          PlayerRepository playerRepository,
                          ActionRepository actionRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.actionRepository = actionRepository;
    }

    public GameResponse findGameById(Long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        if (game.isEmpty()){
            return null;
        }
        Game entity = game.get();
        GameResponse model = new GameResponse();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    public void createGame(GameRequest gameRequest){
        Game game = saveGame(gameRequest);
        savePlayers(gameRequest.getPlayers(),game);
        saveActions(gameRequest.getActions(),game);

    }

    private void savePlayers(List<PlayerRequest> playerRequests, Game game){
        for (PlayerRequest playerRequest : playerRequests) {
            Player player = new Player();
            BeanUtils.copyProperties(playerRequest,player);
            player.setGame(game);
            playerRepository.save(player);
        }
    }

    private void saveActions(List<ActionRequest> actionRequests, Game game){
        for (ActionRequest actionRequest : actionRequests){
            Action action = new Action();
            BeanUtils.copyProperties(actionRequest,action);
            action.setGame(game);
            actionRepository.save(action);
        }
    }

    private Game saveGame(GameRequest gameRequest){
        Game game = new Game();
        game.setName(gameRequest.getName());
        game.setDescription(gameRequest.getDescription());
        gameRepository.save(game);
        return game;
    }
}
