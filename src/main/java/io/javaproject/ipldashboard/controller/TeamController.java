package io.javaproject.ipldashboard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javaproject.ipldashboard.model.Team;
import io.javaproject.ipldashboard.repository.MatchRepository;
import io.javaproject.ipldashboard.repository.TeamRepository;


@RestController
@CrossOrigin
public class TeamController {
    
    private TeamRepository teamRepo;

     private MatchRepository matchRepo;


    public TeamController(TeamRepository teamRepo, MatchRepository matchRepo) {
        this.teamRepo = teamRepo;
        this.matchRepo = matchRepo;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){

        Team team = this.teamRepo.findByTeamName(teamName);
        team.setMatches(this.matchRepo.findLatestMatchesByTeam(teamName, 4));

        return team;
    }
}
