package com.imona.gameserver.model;

import lombok.Data;

@Data
public class ActionResponse {
    private String name;
    private String description;
    private Long point;
}
