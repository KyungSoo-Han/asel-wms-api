package kr.co.biztax.wms.service.common;

import kr.co.biztax.wms.dto.common.SelectDto;
import kr.co.biztax.wms.mapper.common.SelectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectService {
    private final SelectMapper selectMapper;
    public List<SelectDto> searchSelect(String gbn, String sub_gbn, String param1, String param2, String param3, String param4, String param5){
        return selectMapper.searchSelect(gbn, sub_gbn, param1, param2, param3, param4, param5);
    }
}
