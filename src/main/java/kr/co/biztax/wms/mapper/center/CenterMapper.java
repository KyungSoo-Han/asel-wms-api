package kr.co.biztax.wms.mapper.center;

import kr.co.biztax.wms.dto.center.CenterDetailDto;
import kr.co.biztax.wms.dto.center.CenterDto;
import kr.co.biztax.wms.dto.center.CreateCenterDto;
import kr.co.biztax.wms.dto.common.ResultDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CenterMapper {

    List<CenterDto> searchCenter(String gbn, String biz_cd, String center_cd );
    List<CenterDetailDto> searchDetailCenter(String gbn, String biz_cd, String center_cd );

    void createCenter(List<CreateCenterDto> createCenterDto);
    void deleteCenter(List<CenterDto> CenterDto);
}
