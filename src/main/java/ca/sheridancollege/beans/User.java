package ca.sheridancollege.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	private String encryptedpassword;
	private Byte enabled;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();
	
	public User(String username, String encryptedpassword) {
		
		this.username = username;
		this.encryptedpassword = encryptedpassword;
		enabled = 1;
	}
}
