package com.edithtech.jobportal.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record ContactDto(
        @NotBlank(message = "Email should not be empty")
        @Email(message = "Invalid Email Address")
        String email,

        @NotBlank(message = "Message should not be empty")
        @Size(min = 5, max = 500, message = "Message should be between 5 to 500 characters")
        String message,

        @NotBlank(message = "Name should not be empty")
        @Size(min = 5, max = 30, message = "Name should be between 5 to 30 characters")
        String name,

        @NotBlank(message = "Subject should not be empty")
        @Size(min = 5, max = 40, message = "Subject should be between 5 to 40 characters")
        String subject,

        @NotBlank(message = "Email should not be empty")
        @Pattern(regexp = "Job Seeker")
        String userType
) implements Serializable {
}
