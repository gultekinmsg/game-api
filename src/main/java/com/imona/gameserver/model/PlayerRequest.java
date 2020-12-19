package com.imona.gameserver.model;
import com.imona.gameserver.entity.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class PlayerRequest {
    @NotBlank
    @Size(max = 255)
    private String name;
    @NotBlank
    @Size(max = 255)
    private String surname;
    @NotNull
    private Gender gender;
    @NotNull
    private Date birthDate;
    @NotBlank
    @Size(max = 255)
    private String birthCity;
    @NotNull
    private Boolean active;
}
