package s.p.r.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class adminmodel {
@Id
@GeneratedValue
private int bid;
private String name;
private String password;
private String Role;
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}

public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
