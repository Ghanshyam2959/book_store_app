package s.p.r.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import s.p.r.model.adminmodel;
import s.p.r.model.bookmodel;
import s.p.r.repo.adminrepo;
import s.p.r.repo.jparepos; 


@Service
public class bookservice {

    @Autowired
    private jparepos rp;
    
    @Autowired
    private adminrepo amd;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
  //adminsavedata
  	public adminmodel saveinfo(adminmodel aminfo)
  	{
  		String password=passwordEncoder.encode(aminfo.getPassword());
  		aminfo.setPassword(password);
  		aminfo.setRole("Role_User");
  		return amd.save(aminfo);
  	}
    
    
    // Save data  
    public bookmodel savedata(bookmodel user) {
        return rp.save(user);
    }

    // Fetch data 
    public List<bookmodel> fetchall() {
        return rp.findAll();
    }
    // delete data 
    public void deletedata(int bid)
    {
    	rp.deleteById(bid);
    }

	public bookmodel get(int bid) {
		// TODO Auto-generated method stub
        return rp.findById(bid).get();
	}
   
}
