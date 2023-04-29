package com.geekster.UserManagement.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotBlank
    private String userId;

    @NotEmpty(message = "user name can't be empty!!!")
    private String userName;

    @Pattern(regexp = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])")
    private String dateOFBirth;

    @Email
    @NotEmpty
    private String email;

    @Size(min=12, max=12)
    @Pattern(regexp = "^[0-9]+$")
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])")
    private String date;

    @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")
    private String time;

}
