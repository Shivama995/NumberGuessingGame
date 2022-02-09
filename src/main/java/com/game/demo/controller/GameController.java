package com.game.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.game.demo.model.GameModel;
import com.game.demo.model.GameNames;
import com.game.demo.model.NameScore;
import com.game.demo.repo.GameModelRepo;
import com.game.demo.repo.GameNameRepo;



@Controller
public class GameController {
	@Autowired
	GameNameRepo nrepo;
	@Autowired
	GameModelRepo mrepo;
	
	int score;
	String name;
	int ran = (int)(100*Math.random());
	
	ArrayList<NameScore> ns = new ArrayList<>();
	
	@RequestMapping("/")
	public String home()
	{
		return "play.jsp";
	}
	@RequestMapping("/play")
	public String play(GameNames names)
	{
		score = 100;
		name = names.getName();
		nrepo.save(names);
		return "game.jsp";
	}


	public String check(int inp)
	{
        if(inp<ran)
        {
            return("Try a little bigger" +" "+ ran);
        }
        else
        {
            return("You went too high. Come down a bit");
        }	   
	}
	
	@RequestMapping("/Win")
	public String returnback()
	{
		return "Win.jsp";
				
	}

		
	@RequestMapping("/try")
		public ModelAndView guess1(GameModel GameModel)
		{
		score -= 5;
		System.out.println(score);
		if(GameModel.getGuess()==(ran)) {
		
			ModelAndView mv = new ModelAndView("Win.jsp");
			return mv;
		}
		else {
		String a = check(GameModel.getGuess());
		ModelAndView mv = new ModelAndView("game.jsp");
		System.out.println(a);
	    mv.addObject("line",a);
	    return mv;
		}
		}
	@RequestMapping("/save")
	public  ModelAndView save(GameNames gamenames) {
		NameScore e = new NameScore(name,score);
		ns.add(0,e);
		ModelAndView mv=new ModelAndView("Win.jsp");
		//gamenames.setName(name);
		//gamenames.setScore(score);
	    //nrepo.save(gamenames);
	    String s="saved!";
	    mv.addObject("s",s);
	    return mv;
	}
	
	@RequestMapping("/display")
	public  ModelAndView display() {
		ModelAndView mv=new ModelAndView("display.jsp");
	    mv.addObject("list",ns);
	    return mv;
	    }
}
