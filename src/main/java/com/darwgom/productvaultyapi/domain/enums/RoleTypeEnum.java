package com.darwgom.productvaultyapi.domain.enums;

public enum RoleTypeEnum {

    ROLE_ADMIN("role_admin"),
    ROLE_EXTERNAL("role_external");

    private final String value;

    RoleTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

