package kr.co.biztax.wms.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SlipNoDto {

    private String biz_cd;
    private String slip_gbn;
    private String slip_dt;
    private String pre_char;
    private String sepa_char;
    private String fill_char;
    private int seq_len;

}
