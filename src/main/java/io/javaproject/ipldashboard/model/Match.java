package io.javaproject.ipldashboard.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Match {

    @Id
  private long id;
  private String name;
  private String description;
  private String team1;
  private String team2;
  private String tossWinner;
  private String decision;
  private String matchWinner;
  private String result;
  private LocalDate date;
  private String venueName;

  @Column(name = "team1_captain")
  private String team1Captain;

  @Column(name = "team2_captain")
  private String team2Captain;

  private String umpire1;
  private String umpire2;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTeam1() {
    return team1;
  }

  public void setTeam1(String team1) {
    this.team1 = team1;
  }

  public String getTeam2() {
    return team2;
  }

  public void setTeam2(String team2) {
    this.team2 = team2;
  }

  public String getTossWinner() {
    return tossWinner;
  }

  public void setTossWinner(String tossWinner) {
    this.tossWinner = tossWinner;
  }

  public String getDecision() {
    return decision;
  }

  public void setDecision(String decision) {
    this.decision = decision;
  }

  public String getMatchWinner() {
    return matchWinner;
  }

  public void setMatchWinner(String matchWinner) {
    this.matchWinner = matchWinner;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getVenueName() {
    return venueName;
  }

  public void setVenueName(String venueName) {
    this.venueName = venueName;
  }

  public String getTeam1Captain() {
    return team1Captain;
  }

  public void setTeam1Captain(String team1Captain) {
    this.team1Captain = team1Captain;
  }

  public String getTeam2Captain() {
    return team2Captain;
  }

  public void setTeam2Captain(String team2Captain) {
    this.team2Captain = team2Captain;
  }

  public String getUmpire1() {
    return umpire1;
  }

  public void setUmpire1(String umpire1) {
    this.umpire1 = umpire1;
  }

  public String getUmpire2() {
    return umpire2;
  }

  public void setUmpire2(String umpire2) {
    this.umpire2 = umpire2;
  }
}
