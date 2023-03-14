package kr.co.biztax.wms.dto.inbound;

import lombok.Data;

@Data
public class InboundDto {
    private String gbn;
    private String biz_cd;
    private String center_cd;
    private String slip_no;
    private int seq_no;
    private String slip_dt;
    private String cust_cd;
    private String cust_nm;
    private String custProv_cd;
    private String custProv_nm;
    private String buy_gbn;
    private String remark;
    private String item_cd;
    private String item_nm;
    private int item_qty;
    private double price_amt;
    private double supply_amt;
    private String delivReq_dt;
    private String provLot_no;
    private String make_dt;
    private String exp_dt;
    private String item_remark;
    private String user_id;

}
