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
    @OneToMany(mappedBy = "game")
    private List<Player> players;
    @OneToMany(mappedBy = "game")
    private List<Action> actions;
}
