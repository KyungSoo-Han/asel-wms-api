package kr.co.biztax.wms.service.inbound;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.inbound.InboundDto;
import kr.co.biztax.wms.dto.inbound.DeleteInboundDto;
import kr.co.biztax.wms.dto.inbound.SearchInboundDto;
import kr.co.biztax.wms.dto.common.SlipNoDto;
import kr.co.biztax.wms.mapper.inbound.InboundMapper;
import kr.co.biztax.wms.mapper.common.SlipNoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InboundServiceImpl implements InboundService {
    private final InboundMapper mapper;
    private final SlipNoMapper slipNoMapper;

    @Transactional
    @Override
    public List<InboundDto>  createInbound(List<InboundDto> saveInboundDto) throws CustomException {
        System.out.println("saveInboundDto = " + saveInboundDto);
        String slipNo ="";
        if(saveInboundDto.get(0).getSlip_no() =="") {
            SlipNoDto slipNoDto = SlipNoDto.builder()
                    .slipDt(saveInboundDto.get(0).getSlip_dt().replace("-", ""))
                    .bizCd(saveInboundDto.get(0).getBiz_cd())
                    .preChar("A")
                    .slipGbn("BUY_ORDER")
                    .build();

            slipNo = slipNoMapper.getSlipNo(slipNoDto);
        }
        else{
            slipNo = saveInboundDto.get(0).getSlip_no();
        }

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("biz_cd", saveInboundDto.get(0).getBiz_cd());
        objectMap.put("slip_no", slipNo);
        objectMap.put("list", saveInboundDto);
        if(saveInboundDto.get(0).getItem_cd() == null){
            mapper.saveInboundMst(objectMap);
        }else {
            mapper.saveInbound(objectMap);
        }
        System.out.println("saveInboundDto = " + saveInboundDto);

        return mapper.findInbound(saveInboundDto.get(0).getBiz_cd(), slipNo);
//        return slipNo;
    }

    @Override
    public void deleteInbound(String biz_cd, String slip_no) throws CustomException {

        mapper.deleteInbound(biz_cd, slip_no);
    }

    @Transactional
    @Override
    public void deleteInboundItem(List<DeleteInboundDto> deleteInboundDto) throws CustomException {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("biz_cd", deleteInboundDto.get(0).getBiz_cd());
        objectMap.put("list", deleteInboundDto);

        mapper.deleteInboundItem(objectMap);
    }

    @Override
    public List<InboundDto> findInbound(String biz_cd, String slip_no) throws CustomException {
        return mapper.findInbound(biz_cd, slip_no);
    }

    @Override
    public List<InboundDto> findInboundList(SearchInboundDto searchInboundDto) {
        System.out.println("buyOrderSearchDto = " + searchInboundDto);
        return mapper.findInboundList(searchInboundDto);
    }
}
