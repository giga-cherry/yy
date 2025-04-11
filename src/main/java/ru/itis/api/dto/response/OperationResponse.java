package ru.itis.api.dto.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Типовой ответ для операций, где может быть более двух возможных сценариев.
 * operationStatus - числовой код сценария;
 * description - текстовое описание сценария для отображения пользователю
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OperationResponse {

    private int operationStatus;

    private String description;

}
