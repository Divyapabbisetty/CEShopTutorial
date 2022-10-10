package com.divya.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "clientname")
	private String clientName;

	@Column(name = "onbench")
	private boolean onBench;

	public Employee() {

	}

	

	public Employee(String firstName, String lastName, String clientName, boolean onBench) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.clientName = clientName;
		this.onBench = onBench;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getClientName() {
		return clientName;
	}



	public void setClientName(String clientName) {
		this.clientName = clientName;
	}



	public boolean isOnBench() {
		return onBench;
	}



	public void setOnBench(boolean onBench) {
		this.onBench = onBench;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", clientName="
				+ clientName + ", onBench=" + onBench + "]";
	}


}
