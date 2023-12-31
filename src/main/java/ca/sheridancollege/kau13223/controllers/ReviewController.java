package ca.sheridancollege.kau13223.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.kau13223.beans.Review;
import ca.sheridancollege.kau13223.database.DatabaseAccess;

@Controller
public class ReviewController {
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model)
	{
		da.getReviewList().clear();
		model.addAttribute("reviewList", da.getReviewList());
		model.addAttribute("review", new Review());
		
		return "index";
	}
	
	@PostMapping("/insertReview")
	public String insertReview(Model model, @ModelAttribute Review review) {
		
		da.insertReview(review);
		
		model.addAttribute("reviewList", da.getReviewList());
		model.addAttribute("review", new Review());
	
	return "index";
	}


}
