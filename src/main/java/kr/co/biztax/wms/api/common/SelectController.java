package kr.co.biztax.wms.api.common;

import kr.co.biztax.wms.dto.common.SelectDto;
import kr.co.biztax.wms.service.common.SelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/select")
@RequiredArgsConstructor
@RestController
public class SelectController {
    private final SelectService selectService;

    @GetMapping("/{gbn}/{sub_gbn}")
    public List<SelectDto> searchSelect(@PathVariable String gbn, @PathVariable(required = false) String sub_gbn,
                                        @RequestParam(required = false, defaultValue = "") String param1,
                                        @RequestParam(required = false, defaultValue = "") String param2,
                                        @RequestParam(required = false, defaultValue = "") String param3,
                                        @RequestParam(required = false, defaultValue = "") String param4,
                                        @RequestParam(required = false, defaultValue = "") String param5){
        return selectService.searchSelect(gbn,sub_gbn, param1, param2, param3, param4, param5);
    }
}
