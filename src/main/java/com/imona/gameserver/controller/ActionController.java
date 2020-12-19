package com.imona.gameserver.controller;

import com.imona.gameserver.entity.Action;
import com.imona.gameserver.model.ActionResponse;
import com.imona.gameserver.repository.ActionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActionController {
    private final ActionRepository actionRepository;

    @Autowired
    public ActionController(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }


    @GetMapping("/action/{gameId}")
    public List<ActionResponse> getActions(Long gameId){
        List<Action> entities = actionRepository.findByGameId(gameId);
        List<ActionResponse> models = new ArrayList<>();
        for (Action entity : entities) {
            ActionResponse model = new ActionResponse();
            BeanUtils.copyProperties(entity,model);
            models.add(model);
        }
        return models;
    }
}
