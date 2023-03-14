package kr.co.biztax.wms.dto.inbound;

import lombok.Data;

@Data
public class DeleteInboundDto {
    private String biz_cd;
    private String slip_no;
    private int seq_no;
}
