package kr.co.biztax.wms.service.inbound;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.inbound.InboundDto;
import kr.co.biztax.wms.dto.inbound.DeleteInboundDto;
import kr.co.biztax.wms.dto.inbound.SearchInboundDto;

import java.util.List;

public interface InboundService {
    List<InboundDto>  createInbound(List<InboundDto> saveInboundDto) throws CustomException;
    void deleteInbound(String biz_cd, String slip_no) throws CustomException;

    void deleteInboundItem(List<DeleteInboundDto> deleteInboundDto) throws CustomException;

    List<InboundDto> findInbound(String biz_cd, String slip_no) throws CustomException;

    List<InboundDto> findInboundList(SearchInboundDto searchInboundDto);
}
