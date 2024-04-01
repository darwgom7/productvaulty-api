package com.darwgom.productvaultyapi.application.dto;

import com.darwgom.productvaultyapi.domain.enums.RoleTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private RoleTypeEnum roleType;

}
