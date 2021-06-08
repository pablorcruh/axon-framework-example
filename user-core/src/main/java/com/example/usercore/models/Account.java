package com.example.usercore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account{

    @Size(min = 3, message = "usename have minimum of 3 characters")
    private String username;

    @Size(min = 7, message = "password have minimum of 7 characters")
    private String password;

    @NotNull(message = "specify at least 1 role")
    private List<Role> roles;
}
