package com.roovalant.gapgrap.web;

import com.roovalant.gapgrap.config.OpenApiConfig;
import com.roovalant.gapgrap.service.AptService;
import com.roovalant.gapgrap.service.dto.AptDTO;
import com.roovalant.gapgrap.service.util.PaginationUtil;
import com.roovalant.gapgrap.web.vm.PaginationVM;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.roovalant.gapgrap.config.HeaderConstants.GAPGRAP_AUTHORIZATION;

//@HasRole({ APT })
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/apt")
public class AptController {

    private final AptService aptService;

    @GetMapping("/list")
    @Operation(summary = "아파트 목록 조회 요청",
            description = "## Specs\n - Secured to: { }",
            security = @SecurityRequirement(name = OpenApiConfig.AUTHORIZATION_NAME))
    public ResponseEntity<PaginationVM<AptDTO>> getAllApts(
            @Parameter(hidden = true) PaginationVM pagination,
            @Parameter(hidden = true) @RequestParam Map<String,String> filters,
            @Parameter(hidden = true) @RequestHeader(value = GAPGRAP_AUTHORIZATION, required = false) String authorization) {

        ResponseEntity<List<AptDTO>> responseEntity = aptService.getAllApts(pagination,filters,authorization);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(responseEntity.getHeaders(), String.format("/api/apts"));
        return ResponseEntity
                .status(responseEntity.getStatusCode())
                .headers(headers)
                .body(new PaginationVM<>(responseEntity.getHeaders(), responseEntity.getBody()));
    }
}
