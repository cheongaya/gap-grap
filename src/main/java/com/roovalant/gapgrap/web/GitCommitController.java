package com.roovalant.gapgrap.web;

import com.roovalant.gapgrap.config.OpenApiConfig;
import com.roovalant.gapgrap.service.AptService;
import com.roovalant.gapgrap.service.GitCommitService;
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

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

import static com.roovalant.gapgrap.config.HeaderConstants.GAPGRAP_AUTHORIZATION;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/git-commit")
public class GitCommitController {

    private final GitCommitService gitCommitService;

    @GetMapping("/history/{user-name}")
    @Operation(summary = "깃 커밋 히스토리 조회 요청",
            description = "## Specs\n - Secured to: { }")
    public ResponseEntity<?> getGitCommitHistory(
            @PathParam("user-name") @RequestParam String userName) {

        return gitCommitService.getGitCommitHistory(userName);
    }
}
