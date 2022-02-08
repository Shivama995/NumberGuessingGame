package com.game.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.game.demo.model.GameModel;
import com.game.demo.model.GameNames;
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
	@RequestMapping("/")
	public String home()
	{
		
		return "play.jsp";
	}
	@RequestMapping("/play")
	public String play(GameNames names)
	{
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

		
	@RequestMapping("/try")
		public ModelAndView guess1(GameModel GameModel)
		{
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
		ModelAndView mv=new ModelAndView("Win.jsp");
		//gamenames.setName(name);
		//gamenames.setScore(score);
	    //nrepo.save(gamenames);
	    String s="saved!";
	    mv.addObject("s",s);
	    return mv;
	}
}
