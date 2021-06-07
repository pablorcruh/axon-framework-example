package com.example.usercore.events;

import com.example.usercore.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdatedEvent {

    private String id;

    private User user;
}
