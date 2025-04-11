package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private long id;

    private String email;

    private String rawPassword;

    private String nickname;

    private boolean confirmed;
}
