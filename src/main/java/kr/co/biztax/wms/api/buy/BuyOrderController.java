package kr.co.biztax.wms.api.buy;

import kr.co.biztax.wms.config.CustomException;
import kr.co.biztax.wms.dto.buy.BuyOrderDto;
import kr.co.biztax.wms.dto.buy.DeleteBuyOrderDto;
import kr.co.biztax.wms.dto.buy.SearchBuyOrderDto;
import kr.co.biztax.wms.dto.common.ResponseDto;
import kr.co.biztax.wms.service.buy.BuyOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/buy")
@RestController
@RequiredArgsConstructor
public class BuyOrderController {

    private final BuyOrderService buyOrderService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> saveBuyOrder(@RequestBody List<BuyOrderDto> request) throws CustomException {

        List<BuyOrderDto>  rtnData = buyOrderService.saveBuyOrder(request);

        ResponseDto<Object> responseDto = ResponseDto.builder().data(rtnData).message("").build();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{biz_cd}/{slip_no}")
    public ResponseEntity<ResponseDto> findBuyOrder(@PathVariable String biz_cd, @PathVariable String slip_no) throws CustomException {

        List<BuyOrderDto>  rtnData = buyOrderService.findBuyOrder(biz_cd, slip_no);

        ResponseDto<Object> responseDto = ResponseDto.builder().data(rtnData).message("").build();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @PostMapping("/list")
    public ResponseEntity<ResponseDto> findBuyOrderList(@RequestBody SearchBuyOrderDto searchBuyOrderDto) throws CustomException {

        List<BuyOrderDto>  rtnData = buyOrderService.findBuyOrderList(searchBuyOrderDto);

        ResponseDto<Object> responseDto = ResponseDto.builder().data(rtnData).message("").build();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{biz_cd}/{slip_no}")
    public ResponseEntity<ResponseDto> deleteBuyOrder(@PathVariable String biz_cd, @PathVariable String slip_no) throws CustomException {

        buyOrderService.deleteBuyOrder(biz_cd, slip_no);

        ResponseDto<Object> responseDto = ResponseDto.builder().data("OK").message("").build();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteitem")
    public ResponseEntity<ResponseDto> deleteBuyOrderItem(@RequestBody List<DeleteBuyOrderDto> request) throws CustomException {

        buyOrderService.deleteBuyOrderItem(request);

        ResponseDto<Object> responseDto = ResponseDto.builder().data("OK").message("").build();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
