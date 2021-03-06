package ch.squix.extraleague.rest.ranking;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import ch.squix.extraleague.model.match.Match;
import ch.squix.extraleague.model.match.player.PlayerUser;
import ch.squix.extraleague.model.ranking.EternalRanking;
import ch.squix.extraleague.model.ranking.PlayerRanking;
import ch.squix.extraleague.model.ranking.Ranking;
import ch.squix.extraleague.model.ranking.RankingService;
import ch.squix.extraleague.rest.playeruser.PlayerUserDto;

import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.common.base.Strings;

public class PersonalStatsResource extends ServerResource {
	
	private static final Logger log = Logger.getLogger(PersonalStatsResource.class.getName());

	
	@Get(value = "json")
	public PersonalStatsDto execute() throws UnsupportedEncodingException {
		UserService userService = UserServiceFactory.getUserService();
		User currentUser = userService.getCurrentUser();

		if (userService.isUserLoggedIn()) {
				
			String userId = currentUser.getUserId();
			PlayerUser player = ofy().load().type(PlayerUser.class).filter("appUserId", userId).first().now();

			if (player != null) {
				Ranking ranking = ofy().load().type(Ranking.class).order("-createdDate").first().now();
				if (ranking != null) {
					PlayerRanking playerRanking = ranking.getPlayerRanking(player.getPlayer());
					if (playerRanking != null) {
						return PersonalStatsDtoMapper.mapToDto(playerRanking);
					}
				}
			}
		}
		return null;

	}




}
