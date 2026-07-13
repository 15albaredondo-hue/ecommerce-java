package com.portfolio.ecommerce.user.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Long roleId;

}
