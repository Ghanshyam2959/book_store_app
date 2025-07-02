package s.p.r.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import s.p.r.model.adminmodel;
import s.p.r.repo.adminrepo;

public class UserDetailService implements UserDetailsService{
	
@Autowired
private adminrepo adminrepos;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	adminmodel add=adminrepos.findByName(username);
	if(add==null)
	{
	throw new UsernameNotFoundException("user not found");
	}
	else
	{
	return new CutomUser(add);
}
}
}
