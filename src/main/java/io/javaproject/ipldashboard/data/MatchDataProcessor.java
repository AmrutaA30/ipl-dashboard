package io.javaproject.ipldashboard.data;

import io.javaproject.ipldashboard.model.Match;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(
    MatchDataProcessor.class
  );

  @Override
  public Match process(final MatchInput matchInput) throws Exception {
    Match match = new Match();
    try {
      match.setId(Long.valueOf(matchInput.getId()));
      match.setName(matchInput.getName());
      match.setDescription(matchInput.getDescription());

      match.setTossWinner(matchInput.getToss_won());

      //set team1 and team2 based on the innings order.
      //Note:  The below code is not required for this kaggle file. It's only required for the one in the video!
      String firstInningsTeam, secondInningsTeam;

      if ("bat".equals(matchInput.getToss_won())) {
        firstInningsTeam = matchInput.getToss_won();
        secondInningsTeam =
          matchInput.getToss_won().equals(matchInput.getHome_team())
            ? matchInput.getAway_team()
            : matchInput.getHome_team();
      } else {
        secondInningsTeam = matchInput.getToss_won();
        firstInningsTeam =
          matchInput.getToss_won().equals(matchInput.getHome_team())
            ? matchInput.getAway_team()
            : matchInput.getHome_team();
      }
      match.setTeam1(firstInningsTeam);
      match.setTeam2(secondInningsTeam);

      match.setDecision(matchInput.getDecision());
      match.setMatchWinner(matchInput.getWinner());
      match.setResult(matchInput.getResult());
      match.setVenueName(matchInput.getVenue_name());

    //   match.setDate(parseDateTime(matchInput.getStart_date()));
      match.setDate(LocalDate.parse(parseString(matchInput.getStart_date())));
      match.setTeam1Captain(matchInput.getHome_captain());
      match.setTeam2Captain(matchInput.getAway_captain());
      match.setUmpire1(matchInput.getUmpire1());
      match.setUmpire2(matchInput.getUmpire2());
    } catch (Exception e) {
      log.error("Exception while setting Match data.", e.getMessage());
    }
    return match;
  }

  private static LocalDate parseDateTime(String datetimeString) {
    try {
        Instant instant = Instant.parse(datetimeString);
        return instant.atZone(ZoneOffset.UTC).toLocalDate();
        
    } catch (Exception e) {
        System.err.println("Unable to parse the datetime: " + e.getMessage());
        return null;
    }
  }

   private static String parseString(String datetimeString) {
    try {
        String arr[] = datetimeString.split("T");
        return arr[0];
        
    } catch (Exception e) {
        System.err.println("Unable to parse the datetime: " + e.getMessage());
        return null;
    }
  }
}
