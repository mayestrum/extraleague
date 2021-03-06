package ch.squix.extraleague.rest.challenger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ChallengerTeamDto {
	
	private Long id;
	
	private Date createdDate;
	
	private List<String> challengers = new ArrayList<>();

	private String table;

}
