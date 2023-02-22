package kr.co.biztax.wms.service.center;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.center.CenterDetailDto;
import kr.co.biztax.wms.dto.center.CenterDto;
import kr.co.biztax.wms.dto.center.CreateCenterDto;
import kr.co.biztax.wms.dto.common.ResultDto;
import kr.co.biztax.wms.mapper.center.CenterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CenterServiceImpl implements CenterService {
    private final CenterMapper centerMapper;

    @Override
    public List<CenterDto> searchCenter(String gbn, String biz_cd, String center_cd){

        return centerMapper.searchCenter(gbn, biz_cd, center_cd );
    }

    @Override
    public List<CenterDetailDto> searchDetailCenter(String gbn, String biz_cd, String center_cd) {

        return centerMapper.searchDetailCenter(gbn, biz_cd, center_cd );
    }

    @Override
    public void createCenter(List<CreateCenterDto> createCenterDto) throws CustomException {
        centerMapper.createCenter(createCenterDto);
    }

    @Override
    public void deleteCenter(List<CenterDto> centerDto) throws CustomException {
        centerMapper.deleteCenter(centerDto);
    }
}
