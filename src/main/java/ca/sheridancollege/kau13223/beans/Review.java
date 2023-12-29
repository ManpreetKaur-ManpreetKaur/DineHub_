package ca.sheridancollege.kau13223.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Review {
	   
	
	private Long id;
	private String restaurantName;
	private String reviews;
	private LocalDate date;
	private LocalTime time;
	
	

}
