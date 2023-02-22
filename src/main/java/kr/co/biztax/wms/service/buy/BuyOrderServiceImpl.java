package kr.co.biztax.wms.service.buy;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.buy.BuyOrderDto;
import kr.co.biztax.wms.dto.buy.DeleteBuyOrderDto;
import kr.co.biztax.wms.dto.buy.SearchBuyOrderDto;
import kr.co.biztax.wms.dto.common.SlipNoDto;
import kr.co.biztax.wms.mapper.buy.BuyOrderMapper;
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
public class BuyOrderServiceImpl implements BuyOrderService {
    private final BuyOrderMapper mapper;
    private final SlipNoMapper slipNoMapper;

    @Transactional
    @Override
    public List<BuyOrderDto>  saveBuyOrder(List<BuyOrderDto> saveBuyOrderDto) throws CustomException {
        System.out.println("saveBuyOrderDto = " + saveBuyOrderDto);
        String slipNo ="";
        if(saveBuyOrderDto.get(0).getSlip_no() =="") {
            SlipNoDto slipNoDto = SlipNoDto.builder()
                    .slip_dt(saveBuyOrderDto.get(0).getSlip_dt().replace("-", ""))
                    .seq_len(5)
                    .biz_cd(saveBuyOrderDto.get(0).getBiz_cd())
                    .pre_char("A")
                    .sepa_char("-")
                    .slip_gbn("BUY_ORDER")
                    .fill_char("0")
                    .build();

            slipNo = slipNoMapper.getSlipNo(slipNoDto);
        }
        else{
            slipNo = saveBuyOrderDto.get(0).getSlip_no();
        }

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("biz_cd", saveBuyOrderDto.get(0).getBiz_cd());
        objectMap.put("slip_no", slipNo);
        objectMap.put("list", saveBuyOrderDto);
        if(saveBuyOrderDto.get(0).getItem_cd() == null){
            mapper.saveBuyOrderMst(objectMap);
        }else {
            mapper.saveBuyOrder(objectMap);
        }
        System.out.println("saveBuyOrderDto = " + saveBuyOrderDto);

        return mapper.findBuyOrder(saveBuyOrderDto.get(0).getBiz_cd(), slipNo);
//        return slipNo;
    }

    @Override
    public void deleteBuyOrder(String biz_cd, String slip_no) throws CustomException {

        mapper.deleteBuyOrder(biz_cd, slip_no);
    }

    @Transactional
    @Override
    public void deleteBuyOrderItem(List<DeleteBuyOrderDto> deleteBuyOrderDto) throws CustomException {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("biz_cd", deleteBuyOrderDto.get(0).getBiz_cd());
        objectMap.put("list", deleteBuyOrderDto);

        mapper.deleteBuyOrderItem(objectMap);
    }

    @Override
    public List<BuyOrderDto> findBuyOrder(String biz_cd, String slip_no) throws CustomException {
        return mapper.findBuyOrder(biz_cd, slip_no);
    }

    @Override
    public List<BuyOrderDto> findBuyOrderList(SearchBuyOrderDto searchBuyOrderDto) {
        System.out.println("buyOrderSearchDto = " + searchBuyOrderDto);
        return mapper.findBuyOrderList(searchBuyOrderDto);
    }
}
