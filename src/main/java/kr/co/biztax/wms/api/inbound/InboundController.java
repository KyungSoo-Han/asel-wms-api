package kr.co.biztax.wms.api.inbound;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.inbound.InboundDto;
import kr.co.biztax.wms.dto.inbound.DeleteInboundDto;
import kr.co.biztax.wms.dto.inbound.SearchInboundDto;
import kr.co.biztax.wms.dto.common.ResponseDto;
import kr.co.biztax.wms.service.inbound.InboundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/inbound")
@RestController
@RequiredArgsConstructor
public class InboundController {

    private final InboundService buyOrderService;

    @PostMapping("/save")
    public ResponseDto<List<InboundDto>> saveInbound(@RequestBody List<InboundDto> request) throws CustomException {

        List<InboundDto>  rtnData = buyOrderService.createInbound(request);

        return ResponseDto.SuccessResponse(rtnData,HttpStatus.OK);
    }

    @GetMapping("/{biz_cd}/{slip_no}")
    public ResponseDto<List<InboundDto>> findInbound(@PathVariable String biz_cd, @PathVariable String slip_no) throws CustomException {

        List<InboundDto>  rtnData = buyOrderService.findInbound(biz_cd, slip_no);

        return ResponseDto.SuccessResponse(rtnData,HttpStatus.OK);
    }


    @PostMapping("/list")
    public ResponseDto<List<InboundDto>> findInboundList(@RequestBody SearchInboundDto searchInboundDto) throws CustomException {

        List<InboundDto>  rtnData = buyOrderService.findInboundList(searchInboundDto);

        return ResponseDto.SuccessResponse(rtnData,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{biz_cd}/{slip_no}")
    public ResponseDto<String> deleteInbound(@PathVariable String biz_cd, @PathVariable String slip_no) throws CustomException {

        buyOrderService.deleteInbound(biz_cd, slip_no);

        return ResponseDto.SuccessResponse("OK",HttpStatus.OK);
    }

    @DeleteMapping("/deleteitem")
    public ResponseDto<String> deleteInboundItem(@RequestBody List<DeleteInboundDto> request) throws CustomException {

        buyOrderService.deleteInboundItem(request);

        return ResponseDto.SuccessResponse("OK",HttpStatus.OK);
    }
}
