package com.Java8.newfeature.Java8.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Employees implements Comparable<Employees>{
	private long id;
	private String name;
	private String grade;
	private long salary;
	@Override
	public int compareTo(Employees o) {
		// TODO Auto-generated method stub
		return (int) (this.getId() - o.id);
	}
}
