package com.roovalant.gapgrap.web;

import com.roovalant.gapgrap.domain.enumeration.ResourceType;
import com.roovalant.gapgrap.service.AptService;
import com.roovalant.gapgrap.service.dto.AptDTO;
import com.roovalant.gapgrap.service.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/apts")
public class AptController {

    private final AptService aptService;
    private final UserService userService;

    // 활용 공공 데이터 : https://www.data.go.kr/data/15063991/fileData.do#tab-layer-openapi
//    @GetMapping("/list")
//    @Operation(summary = "아파트 목록 조회 요청",
//            description = "## Specs\n - Secured to: { }",
//            security = @SecurityRequirement(name = OpenApiConfig.AUTHORIZATION_NAME))
//    public ResponseEntity<PaginationVM<AptDTO>> getAllApts(
//            @Parameter(hidden = true) PaginationVM pagination,
//            @Parameter(hidden = true) @RequestParam Map<String,String> filters,
//            @Parameter(hidden = true) @RequestHeader(value = GAPGRAP_AUTHORIZATION, required = false) String authorization) {
//
//        ResponseEntity<List<AptDTO>> responseEntity = aptService.getAllApts(pagination,filters,authorization);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(responseEntity.getHeaders(), String.format("/api/apts"));
//        return ResponseEntity
//                .status(responseEntity.getStatusCode())
//                .headers(headers)
//                .body(new PaginationVM<>(responseEntity.getHeaders(), responseEntity.getBody()));
//    }

    @ApiOperation(value = "아파트 목록 조회", notes = "페이징 처리")
    public ResponseEntity<List<AptDTO>> getAllMusics(
            @ParameterObject Pageable pageable,
            @RequestParam(required = false) ResourceType type
    ) {
        log.debug("REST request to get a page of Reports: {}", type);
        Page<AptDTO> page = type == null ? aptService.findAll(pageable) : aptService.findAllByType(pageable,type);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
