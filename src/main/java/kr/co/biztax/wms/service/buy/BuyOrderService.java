package kr.co.biztax.wms.service.buy;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.buy.BuyOrderDto;
import kr.co.biztax.wms.dto.buy.DeleteBuyOrderDto;
import kr.co.biztax.wms.dto.buy.SearchBuyOrderDto;

import java.util.List;

public interface BuyOrderService {
    List<BuyOrderDto>  saveBuyOrder(List<BuyOrderDto> saveBuyOrderDto) throws CustomException;
    void deleteBuyOrder(String biz_cd, String slip_no) throws CustomException;

    void deleteBuyOrderItem(List<DeleteBuyOrderDto> deleteBuyOrderDto) throws CustomException;

    List<BuyOrderDto> findBuyOrder(String biz_cd, String slip_no) throws CustomException;

    List<BuyOrderDto> findBuyOrderList(SearchBuyOrderDto searchBuyOrderDto);
}
