package com.ktko.admin.domain.test.dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestObj {

    @NotNull
    @NotEmpty
    private String notNullCheck;

    @Min(25)
    @Max(31)
    private int valueCheck;

    @Size(min = 4)
    String lengthCheck;

    String nullCheck;
}
