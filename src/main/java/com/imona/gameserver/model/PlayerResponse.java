package com.imona.gameserver.model;

import com.imona.gameserver.entity.Gender;
import lombok.Data;
import java.util.Date;

@Data
public class PlayerResponse {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private Date birthDate;
    private String birthCity;
    private Boolean active;
}
