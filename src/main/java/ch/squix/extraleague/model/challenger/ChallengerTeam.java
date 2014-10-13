package ch.squix.extraleague.model.challenger;

import java.util.Date;

import lombok.Data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Cache
@Data
public class ChallengerTeam {
	
	@Id
	private Long id;
	
	@Index
	private Date createdDate;
	
	private String [] players;
	
	@Index
	private String table;
	

}
