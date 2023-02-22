package kr.co.biztax.wms.mapper.buy;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.buy.BuyOrderDto;
import kr.co.biztax.wms.dto.buy.DeleteBuyOrderDto;
import kr.co.biztax.wms.dto.buy.SearchBuyOrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuyOrderMapper {
    void saveBuyOrder(Map<String, Object> map) ;

    void saveBuyOrderMst(Map<String, Object> map);
    void deleteBuyOrder(String biz_cd, String slip_no);
    void deleteBuyOrderItem(Map<String, Object> deleteBuyOrderDto) throws CustomException;
    List<BuyOrderDto> findBuyOrder(String biz_cd, String slip_no);

    List<BuyOrderDto> findBuyOrderList(SearchBuyOrderDto searchBuyOrderDto);

}
