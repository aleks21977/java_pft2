package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;
import sun.security.ec.point.ProjectivePoint;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("90350e9363e73528fb4569fc497b5b39d79a5211");
        RepoCommits commits = github.repos()
                .get(new Coordinates.Simple("aleks21977", "java_pft2")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
