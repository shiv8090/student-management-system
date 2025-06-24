package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.ashokit.entity.Student;
import in.ashokit.service.Studentservice;

@Controller
public class Studentcontroller {

	
	 private  Studentservice service;
	 @Autowired
	public Studentcontroller(Studentservice service)
	{
		this.service=service;
	}
	
	// to show the empty form
	@GetMapping("/")
	public ModelAndView index()
	
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	// to save the form data
	@PostMapping("/savedstudent")
	public ModelAndView handlesubmitbtn(Student s)
	{
		ModelAndView mav=new ModelAndView();
		boolean savedstudent=service.savestudent(s);
		if(savedstudent)
		{
			mav.addObject("msg","data is saved ");
			
		}
		else
		{
			mav.addObject("emsg","data is not saved ");
		}
		mav.setViewName("index");
		return mav;
	}
	
	// to show all data 
	@GetMapping("/getallstudent")
	public ModelAndView showallstudent()
	{
		ModelAndView mav=new ModelAndView();
		List<Student>slist=service.getallstudent();
		mav.addObject("slist", slist);
		mav.setViewName("data");
		return mav;
	}
	@GetMapping("/delete")
	public ModelAndView deleteRecord(@RequestParam("sid") Integer sid) {
		service.delete(sid);
		List<Student> stuList = service.getallstudent();
		ModelAndView mav = new ModelAndView();
		mav.addObject("stuList", stuList);
		mav.addObject("msg", "Deleted Successfully");
		mav.setViewName("data");
		return mav;
	}
	
	
}
