package kr.co.biztax.wms.mapper.common;

import kr.co.biztax.wms.dto.common.SelectDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelectMapper {
    List<SelectDto> searchSelect(String gbn , String sub_gbn, String param1, String param2, String param3, String param4, String param5);
}
