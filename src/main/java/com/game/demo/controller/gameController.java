package com.game.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.game.demo.model.gameModel;
import com.game.demo.repo.gameRepo;
@Controller
public class gameController {
	@Autowired
	gameRepo repo;
	
	
	int ran = (int)(100*Math.random());
	@RequestMapping("/")
	public String home()
	{
		return "game.jsp";
	}


	public String check(int inp)
	{
        if(inp == ran)
        {
            return("You Win");
        }
        else if(inp<ran)
        {
            return("Try a little bigger");
        }
        else
        {
            return("You went too high. Come down a bit");
        }	   
	}

		
	@RequestMapping("/try")
		public ModelAndView guess1(gameModel gameModel)
		{
		String a = check(gameModel.getGuess());
		ModelAndView mv = new ModelAndView("game.jsp");
		System.out.println(a);
	    mv.addObject("line",a);
	    return mv;
		}
}
