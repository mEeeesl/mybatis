package ch03.domain;
					//relationship(DB) = A has a B (JAVA)
					// 3장에서는 USERS와 Address사이의 관계를 맺어 줄 것임.
					// 4장부터는 A has a Many를 다룰 것임.
public class Address {
	private String address; 
	
	@Override
	public String toString() {
		return address;
	}
}
