package com.qwert12321.contact.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qwert12321.contact.dao.ContactDAO;
import com.qwert12321.contact.model.Contact;

@Controller
public class MainController {
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		List<Contact> listContact=contactDAO.list();
		model.addObject("listContact",listContact);
		model.setViewName("index");
		return model;
	}
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact",newContact);
		model.setViewName("contact_form");
		return model;
	}
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		
		
			if (contact.getC_id()!=null) {
				contactDAO.update(contact);
			} else {
				
				contactDAO.save(contact);
			}
		
		
		
		 
		
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/edit",method= RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		Integer c_id=Integer.parseInt(request.getParameter("c_id"));
		Contact contact= contactDAO.get(c_id);
		ModelAndView model = new ModelAndView("contact_edit_form");
		model.addObject("contact",contact);
		return model;
	}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam Integer c_id) {
		contactDAO.delete(c_id);
		return new ModelAndView("redirect:/");
	}
}
