package com.roovalant.gapgrap.schedule;

import com.roovalant.gapgrap.service.GitCommitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
class GitCommitScheduledTasks {

    private final GitCommitService gitCommitService;

//    @Scheduled(fixedRate = 1000 * 10)
//    public void getGitCommitData() {
//        gitCommitService.getGitCommits();
//    }
}
