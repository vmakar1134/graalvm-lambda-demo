package com.makar.graalvmdemo.model;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for {@link com.makar.graalvmdemo.entity.User}
 */
@Getter
@Setter
public class UserResponse {

    private Long id;

    private String username;

    private String email;

    private Instant createdAt;

}
