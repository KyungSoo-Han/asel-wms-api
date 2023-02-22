package kr.co.biztax.wms.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
public class ResponseDto<T> {

    private final boolean success = true;
    private final String error = null;
    private String message;
    private T data;

    @Builder
    public ResponseDto(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
