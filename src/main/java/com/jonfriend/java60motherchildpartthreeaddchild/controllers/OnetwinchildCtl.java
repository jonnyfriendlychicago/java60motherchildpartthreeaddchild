package com.jonfriend.java60motherchildpartthreeaddchild.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jonfriend.java60motherchildpartthreeaddchild.models.OnetwinchildMdl;
import com.jonfriend.java60motherchildpartthreeaddchild.models.TwinoneMdl;
//import com.jonfriend.java60motherchildpartthreeaddchild.models.UserMdl;
import com.jonfriend.java60motherchildpartthreeaddchild.services.OnetwinchildSrv;
import com.jonfriend.java60motherchildpartthreeaddchild.services.TwinoneSrv;
import com.jonfriend.java60motherchildpartthreeaddchild.services.UserSrv;

@Controller
//public class OnetwinchildCtl {
public class OnetwinchildCtl {

	@Autowired
	private OnetwinchildSrv onetwinchildSrv;
	
	@Autowired
	private UserSrv userSrv;
	
	@Autowired
	private TwinoneSrv twinoneSrv;
	
	// display create-new page
	@GetMapping("/onetwinchild/{id}")
	public String newOnetwinchild(
			@PathVariable ("id") Long twinoneId
			, @ModelAttribute("onetwinchild") OnetwinchildMdl onetwinchildMdl
			, Model model
			, HttpSession session
			) {
		 
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		// getting the parent record from the pathvariable
		TwinoneMdl intVar = twinoneSrv.findById(twinoneId);
		// sending that parent record to the page
		model.addAttribute("twinone", intVar);
		// placeholder for getting/sending list of already created onetwinchild
		
		return "onetwinchild/create.jsp";
	}
	 

// end of ctl
}
