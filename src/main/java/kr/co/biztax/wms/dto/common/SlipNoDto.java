package kr.co.biztax.wms.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SlipNoDto {

    private String bizCd;
    private String slipGbn;
    private String preChar;
    private String slipDt;

}
