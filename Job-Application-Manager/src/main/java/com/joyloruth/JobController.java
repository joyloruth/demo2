package com.joyloruth;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class JobController {
	
	
		@Autowired
		private JobService jobService; 
		
		@RequestMapping("/list")
		public String viewHomePage(Model model) {
			List<Job> listJobs = jobService.listAll();
			model.addAttribute("listJobs", listJobs);
			
			return "job_list";
		}
		
		@RequestMapping("/new")
		public String showNewJobPage(Model model) {
			Job job = new Job();
			model.addAttribute("job", job);
			
			/*ArrayList<String> statusList = new ArrayList<String>();
			statusList.add("Applying");
			statusList.add("Applied");
			statusList.add("Interviewing");
			statusList.add("Reviewing Offer");
			statusList.add("Accepted Offer");
			statusList.add("Awaiting Feedback");
			statusList.add("No Reponse");
			statusList.add("Applying");
			statusList.add("Testing");
			statusList.add("Rejected");
			
			model.addAttribute("statusList", job.getStatus());*/
			
			return "new_job";
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveJob(@ModelAttribute("job") Job job) {
			jobService.save(job);
			
			return "redirect:/";
		}
		
		@RequestMapping("/edit/{id}")
		public ModelAndView showEditJobPage(@PathVariable(name = "id") int id) {
			ModelAndView mav = new ModelAndView("edit_job");
			Job job = jobService.get(id);
			mav.addObject("job", job);
			
			return mav;
		}
		
		@RequestMapping("/delete/{id}")
		public String deleteJob(@PathVariable(name = "id") int id) {
			jobService.delete(id);
			return "redirect:/";		
		}
		
}
