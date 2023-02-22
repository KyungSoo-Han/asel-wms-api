package kr.co.biztax.wms.mapper.common;

import kr.co.biztax.wms.dto.common.SlipNoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SlipNoMapper {
    String getSlipNo(SlipNoDto slipNoDto);
}
