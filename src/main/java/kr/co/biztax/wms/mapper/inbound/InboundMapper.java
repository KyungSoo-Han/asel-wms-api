package kr.co.biztax.wms.mapper.inbound;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.inbound.InboundDto;
import kr.co.biztax.wms.dto.inbound.SearchInboundDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InboundMapper {
    void saveInbound(Map<String, Object> map) ;

    void saveInboundMst(Map<String, Object> map);
    void deleteInbound(String biz_cd, String slip_no);
    void deleteInboundItem(Map<String, Object> deleteInboundDto) throws CustomException;
    List<InboundDto> findInbound(String biz_cd, String slip_no);

    List<InboundDto> findInboundList(SearchInboundDto searchInboundDto);

}
