package com.Java8.newfeature.Java8.beans;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString 
@Getter @Setter  @ToString @AllArgsConstructor @NoArgsConstructor
//@Data
//@Validated
public class Customer {	
	
	@Min(value = 2,message = "Number lesser than 2...")
	@Max(value = 2001,message = "Number out of range...")
	private Integer id;
	
	@NotBlank(message = "Cannot be null or blank...")
	@Pattern(regexp = "[a-zA-Z0-9]+$", message = "Not Alphanumeric...")
	private String name;
	
	@Email(message = "email is not valid...") 
	@NotBlank
	private String email;	
	
	@NotNull
	private List<String> phoneNumbers;

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, phoneNumbers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phoneNumbers, other.phoneNumbers);
	}

//	public List<String> getPhoneNumbers() {
//		return phoneNumbers;
//	}
//
//	public void setPhoneNumbers(List<String> phoneNumbers) {
//		this.phoneNumbers = phoneNumbers;
//	}
	
	
	
	
}
