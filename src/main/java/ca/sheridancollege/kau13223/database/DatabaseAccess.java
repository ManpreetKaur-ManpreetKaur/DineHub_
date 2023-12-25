package ca.sheridancollege.kau13223.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.kau13223.beans.Review;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertReview(Review review) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query="INSERT INTO review( id,restaurantName,reviews, date, time) VALUES ( :id, :restaurantName, :reviews, :date, :time)";
		
		namedParameters.addValue("id", review.getId());
		namedParameters.addValue("restaurantName", review.getRestaurantName());
		namedParameters.addValue("reviews", review.getReviews());
		namedParameters.addValue("date", review.getDate());
		namedParameters.addValue("time", review.getTime());
		
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
		System.out.println("Review "  +review.getId() + "inserted into database.");
		}

	public List<Review> getReviewList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM review";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Review>(Review.class));
		}
}
