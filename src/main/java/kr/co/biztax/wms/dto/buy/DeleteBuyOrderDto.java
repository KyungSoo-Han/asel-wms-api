package kr.co.biztax.wms.dto.buy;

import lombok.Data;

@Data
public class DeleteBuyOrderDto {
    private String biz_cd;
    private String slip_no;
    private int seq_no;
}
