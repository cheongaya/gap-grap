package com.roovalant.gapgrap.service.impl;

import com.roovalant.gapgrap.service.GitCommitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GitCommitServiceImpl implements GitCommitService {
    @Override
    public void getGitCommits() {

    }

    @Override
    public String getGitCommitHistory(String userName) {
        return null;
    }
}
