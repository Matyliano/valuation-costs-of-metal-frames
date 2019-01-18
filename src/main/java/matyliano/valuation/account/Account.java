package matyliano.valuation.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.time.Instant;


@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@Data
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;


	@Enumerated(EnumType.STRING)
	private Role role;

	private Instant created;

    protected Account() {

	}
	
	public Account( String email, String password, Role role) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.created = Instant.now();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole( Role role ) {
		this.role = role;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated( Instant created ) {
		this.created = created;
	}
}
