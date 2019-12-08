package com.einstein.api.model;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String userId;
}
