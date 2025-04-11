package ru.itis.api.dto.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Ответ для сценариев завершения регистрации или входа.
 * Может быть ненулевой статус операции и описание, либо нулевой код и токен для входа в приложение
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class TokenResponse extends OperationResponse {

    private String token;

}
