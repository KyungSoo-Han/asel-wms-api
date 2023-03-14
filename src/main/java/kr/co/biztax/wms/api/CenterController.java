package kr.co.biztax.wms.api;

import kr.co.biztax.wms.dto.center.CenterDetailDto;
import kr.co.biztax.wms.dto.center.CenterDto;
import kr.co.biztax.wms.dto.center.CreateCenterDto;
import kr.co.biztax.wms.dto.common.ResponseDto;
import kr.co.biztax.wms.dto.common.ResultDto;
import kr.co.biztax.wms.service.center.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RequestMapping("/api/center")
@RestController
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;

    @GetMapping
    public ResponseDto<List<CenterDto>> searchCenter(@RequestParam String gbn,
                                                    @RequestParam String biz_cd,
                                                    @RequestParam(required = false, defaultValue = "")String center_cd){

        List<CenterDto> centerDtos = centerService.searchCenter(gbn, biz_cd, center_cd);
        return ResponseDto.SuccessResponse(centerDtos,HttpStatus.OK);
    }
    @GetMapping("/detail")
    public ResponseDto<List<CenterDetailDto>> searchDetailCenter(@RequestParam String gbn,
                                                    @RequestParam String biz_cd,
                                                    @RequestParam(required = false, defaultValue = "")String center_cd){

        List<CenterDetailDto> centerDtos = centerService.searchDetailCenter(gbn, biz_cd, center_cd);
        return ResponseDto.SuccessResponse(centerDtos,HttpStatus.OK);
    }

    @GetMapping("/{gbn}/{biz_cd}/{center_cd}")
    public Map<String, Object> procSearchCenter(@PathVariable String gbn, @PathVariable String biz_cd, @PathVariable String center_cd){

        System.out.println("gbn = " + gbn);
        System.out.println("biz_cd = " + biz_cd);
        System.out.println("center_cd = " + center_cd);

        Map<String,Object> rtnObj = new HashMap<>();
        rtnObj.put("data", centerService.searchCenter(gbn, biz_cd, center_cd));
        return rtnObj;
    }

    @GetMapping("/query")
    public Map<String, Object> procQuerySearchCenter(@RequestParam String gbn,
                                                     @RequestParam String biz_cd,
                                                     @RequestParam(required = false, defaultValue = "") String center_cd){

        System.out.println("gbn = " + gbn);
        System.out.println("biz_cd = " + biz_cd);
        System.out.println("center_cd = " + center_cd);

        Map<String,Object> rtnObj = new HashMap<>();
        rtnObj.put("data", centerService.searchCenter(gbn, biz_cd, center_cd));
        return rtnObj;
    }

    @PostMapping
    public ResponseDto<String>  createCenter(@RequestBody List<CreateCenterDto> request) throws Exception {
        System.out.println("request = " + request);
        centerService.createCenter(request);

        return ResponseDto.SuccessResponse("OK",HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseDto<String> deleteCenter(@RequestBody List<CenterDto> request) throws Exception {
        System.out.println("request = " + request);
        centerService.deleteCenter(request);

        return ResponseDto.SuccessResponse("OK",HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String Hellow(){

        return "Hello";
    }

}
