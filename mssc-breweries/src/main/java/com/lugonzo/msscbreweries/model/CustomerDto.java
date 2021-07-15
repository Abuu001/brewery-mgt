package com.lugonzo.msscbreweries.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {


    private UUID Id;

    @NotBlank
    @Size(min =3 ,max =20 )
    private String name;
    private int age;
    private Boolean isAdult;
    //TODO : Add DOB and calc the age
}
