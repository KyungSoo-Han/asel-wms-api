package kr.co.biztax.wms.dto.center;

import lombok.Data;

@Data
public class CreateCenterDto {

    private String centerCd;
    private String centerNm;
    private String bizCd;
    private String zipNo;
    private String zipAddr1;
    private String zipAddr2;
    private String remark;

}
