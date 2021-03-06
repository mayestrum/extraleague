package ch.squix.extraleague.rest.games;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import ch.squix.extraleague.rest.games.mode.GameModeEnum;

@Data
public class GameDto {

	private Long id;
	private String table;
	private List<String> players = new ArrayList<>();
	
	private Date startDate;
	private Date endDate;
	
	private Double gameProgress;
	
	private Boolean isGameFinished;
	
	private Long estimatedRemainingMillis;
	
	private Integer numberOfCompletedGames;
	private Integer indexOfLastUpdatedMatch;
	private Date firstGoalDate;
	
	private GameModeEnum gameMode;
	private Integer maxMatches;
	private Integer maxGoals;

	

	
}
