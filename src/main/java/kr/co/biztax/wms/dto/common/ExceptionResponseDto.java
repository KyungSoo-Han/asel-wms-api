package kr.co.biztax.wms.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
public class ExceptionResponseDto<T> {

    private final boolean success = false;
    private String error;
    private String message;
    private final T data = null;
    @Builder
    public ExceptionResponseDto(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
