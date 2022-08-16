package com.roovalant.gapgrap.service;

public interface GitCommitService {

    /**
     * Get all the Git Commit.
     */
    void getGitCommits();

    String getGitCommitHistory(String userName);
}
