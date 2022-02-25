package no.hvl.dat102.hobby;

import java.util.Objects;

public class Hobby {
	private String hobby;
	
	public Hobby(String hobby) {
		this.hobby = hobby;
	}
	
	public String ToString() {
		return "<" + hobby + ">";
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hobby);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hobby other = (Hobby) obj;
		return hobby.equals(other.getHobby());
	}
}
