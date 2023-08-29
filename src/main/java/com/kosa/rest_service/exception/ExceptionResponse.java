package com.kosa.rest_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 에러 메시지를 전담하여 보여줄 수 있는 객체
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
