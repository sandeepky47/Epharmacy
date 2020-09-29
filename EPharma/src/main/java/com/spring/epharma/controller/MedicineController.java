package com.spring.epharma.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.epharma.model.Medicine;
import com.spring.epharma.service.MedicineServiceImp;

@Controller
public class MedicineController {
	
	@Autowired(required = true)
	private MedicineServiceImp medicineimp;

	
	

	
	@GetMapping("/")
	public String getHomePage(final Model model, final HttpServletRequest request) {
		model.addAttribute("medicine", new Medicine());
		return "home";
	}
	
	@GetMapping("/getaddpage")
	public String getAdditionPage(final Model model) {

		model.addAttribute("medicine", new Medicine());
		return "addMedicine";
	}

	@GetMapping("/getexpired")
	public String getExpiredPage(final Model model) {
		final Date currentDate = new Date();
		final List<Medicine> medicinelist = medicineimp.getExpiredMedicine(currentDate);
		model.addAttribute("medicinelist", medicinelist);
		return "getAllExpired";
	}

	

	@ModelAttribute(name = "companies")
	public List<String> getAllCompanies(final Model model) {
		final List<String> companylist = new ArrayList<>();
		companylist.add("Sun Pharmaceutical");
		companylist.add("Cipla");
		companylist.add("Abbott India");
		companylist.add("Aurobindo Pharma");
		companylist.add("Lupin Ltd");
		return companylist;
	}

	@PostMapping("/adding")
	public String addtourpostmethod(@Valid @ModelAttribute("medicine") final Medicine medicine,
			final BindingResult result, final Model model) {
		String page;
		if (result.hasErrors()) {
			page = "addMedicine";
		} else if (medicine.getExpireDate().before(medicine.getManufactureDate())) {
			model.addAttribute("dateerror", "Expire Date must be greater than Manufacture Date");
			page = "addMedicine";
		} else {
			medicineimp.addMedicine(medicine);
			page = "home";

		}
		return page;
	}

	@GetMapping("/getall")
	public String getAllPage(final Model model) {
		final List<Medicine> medicinelist = medicineimp.getAllMedicine();
		model.addAttribute("medicinelist", medicinelist);
		return "getAll";
	}

	@GetMapping("/deleterecord")
	public String deletegetmethod(HttpServletRequest request, Model model) {
		int mediId = Integer.parseInt(request.getParameter("id"));
		medicineimp.deleteMedicine(mediId);

		final List<Medicine> medicinelist = medicineimp.getAllMedicine();
		model.addAttribute("medicinelist", medicinelist);
		return "getAll";

	}
	
	@GetMapping("/editrecord")
	public ModelAndView edittourgetmethod(@RequestParam("id") int mediId)
			 {
		//int mediId = Integer.parseInt(request.getParameter("id"));
		Medicine mediObj = medicineimp.getMedicineById(mediId);
		ModelAndView mv=new ModelAndView("editMedicine","medicine",mediObj);
		return mv;
	}
	

	@PostMapping("/editing")
	public String editMedicineMethod( @Valid @ModelAttribute("medicine")  Medicine mediObj,BindingResult result,Model model) {
		   
		     String page;
		     if (result.hasErrors()) {
		    	 page = "editMedicine";
		     }
		     else if (mediObj.getExpireDate().before(mediObj.getManufactureDate())) {
					model.addAttribute("dateerror", "Expire Date must be greater than Manufacture Date");
					model.addAttribute("medicine", mediObj);
					page = "editMedicine";
				}
				else {
		        medicineimp.editMedicine(mediObj);	
		       List<Medicine> medicinelist = medicineimp.getAllMedicine();
			  model.addAttribute("medicinelist", medicinelist);
			    page="getAll";
				}
				return page;
	}
	
	@PostMapping("/getbyid")
	public String getOneDetails(HttpServletRequest request, HttpServletResponse response,Model model) 
	{
		
		int mediId = Integer.parseInt(request.getParameter("medicineid"));
		Medicine mediObj = medicineimp.getMedicineById(mediId);
		model.addAttribute("medicine", mediObj);
		return "getOneRecord";
		
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView excetionHandler() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("message", "Invalid medicine id");
		return mv;

	}
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView excetionFormatHandler() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("formaterror", "Please enter id");
		return mv;

	}

}
