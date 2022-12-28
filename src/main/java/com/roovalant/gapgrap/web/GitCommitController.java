package com.roovalant.gapgrap.web;

import com.roovalant.gapgrap.service.GitCommitService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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

//        return gitCommitService.getGitCommitHistory(userName);
        return ResponseEntity.ok("");
    }
}
