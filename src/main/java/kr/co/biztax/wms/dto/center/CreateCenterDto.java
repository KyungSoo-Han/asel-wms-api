package kr.co.biztax.wms.dto.center;

import lombok.Data;

@Data
public class CreateCenterDto {

    private String user_id;
    private String center_cd;
    private String center_nm;
    private String biz_cd;
    private String zip_no;
    private String zip_addr;
    private String dtl_addr;
    private String remark;

}
