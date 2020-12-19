package com.imona.gameserver.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<Player> players;
    @OneToMany
    private List<Action> actions;
}
