package com.thoughtworks.capacity.gtb.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull(message = ("UserName must not be null"))
    @Length(min =3,max = 10)
    @Pattern(regexp =  "\\w+$")
    private String username;
    @NotNull(message = ("Password must not be null"))
    @Length(min =5,max = 12)
    private String password;
    @Email
    private String email;
}
