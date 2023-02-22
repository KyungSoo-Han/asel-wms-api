package kr.co.biztax.wms.service.common;

import kr.co.biztax.wms.dto.common.SlipNoDto;
import kr.co.biztax.wms.mapper.common.SlipNoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlipNoService {

    private final SlipNoMapper slipNoMapper;

    public String getSlipNo(SlipNoDto slipNoDto){
        return slipNoMapper.getSlipNo(slipNoDto);
    }
}
