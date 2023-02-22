package kr.co.biztax.wms.service.center;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.center.CenterDetailDto;
import kr.co.biztax.wms.dto.center.CenterDto;
import kr.co.biztax.wms.dto.center.CreateCenterDto;
import kr.co.biztax.wms.dto.common.ResultDto;

import java.util.List;

public interface CenterService {

    public List<CenterDto> searchCenter(String gbn, String biz_cd, String center_cd);

    public List<CenterDetailDto> searchDetailCenter(String gbn, String biz_cd, String center_cd);

    void createCenter(List<CreateCenterDto> createCenterDto) throws CustomException ;

    void deleteCenter(List<CenterDto> centerDto) throws CustomException;
}
