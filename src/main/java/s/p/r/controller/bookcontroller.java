package s.p.r.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import s.p.r.model.adminmodel;
import s.p.r.model.bookmodel;
import s.p.r.service.bookservice;

@Controller
public class bookcontroller {

    @Autowired
    public bookservice bs;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    // for admin 
    @GetMapping("/admin")
    public String reg()
    {
    	return "Register";
    }
    
    // login 
    @GetMapping("/login")
    public String log()
    {
    	return "login";
    }
    //dashbord
    @GetMapping("/show")
    public String model(Model mod) {
        try {
            List<bookmodel> listall = bs.fetchall();  // Fetch all book records
            mod.addAttribute("listdata", listall);
            System.out.println("data:"+listall);// Add to model for view rendering
        } catch (Exception e) {
            
            System.err.println("Error fetching book data: " + e.getMessage());
            e.printStackTrace();

            mod.addAttribute("error", "Unable to fetch book data at the moment.");
            
            return "error"; 
        }
        return "dashboard"; 
    }
    
        @PostMapping("/datasave")
        public String saveadmindata(@ModelAttribute adminmodel user) {
            System.out.println("Before saving: " + user);
            bs.saveinfo(user);
            System.out.println("After saving - user details: " + user);
            return "redirect:/Register";		
        }
        
        //update 
        @PostMapping("/updatedata")
        public String updata(@ModelAttribute bookmodel bm) {
           bs.savedata(bm);
            return "redirect:/show";
        }
        
        @RequestMapping("/abo")
        public String abt() {
            return "about";
        }

        @RequestMapping("/cont")
        public String contact() {
            return "contact";
        }
        
    
   

    @PostMapping("/booksave")
    public String savedata(@ModelAttribute bookmodel user) {
        bs.savedata(user);
        return "index";
    }

   
  
    
    
   
    
    
@RequestMapping("/delete/{bid}")
public String Delinfo(@PathVariable(name="bid") int bid)
{
	bs.deletedata(bid);
	return "redirect:/show";		
}
@RequestMapping("/edit/{bid}")
public String editinfo(@PathVariable(name="bid") int bid , Model model)
{
	bookmodel bm = bs.get(bid);
	
	model.addAttribute("emp", bm);
	return "editinfo";		
}
}
