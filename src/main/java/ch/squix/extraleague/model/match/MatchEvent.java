package ch.squix.extraleague.model.match;

import java.util.Date;

import lombok.Data;

import com.googlecode.objectify.annotation.Embed;

@Data
@Embed
public class MatchEvent {
	
	private String player;
	private String event;
	private Date time;

}
