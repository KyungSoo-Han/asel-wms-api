package kr.co.biztax.wms.dto.inbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchInboundDto {
    private String biz_cd;
    private String slip_no;
    private String cust_cd;
    private String custProv_cd;
    private String fDate;
    private String tDate;

}
