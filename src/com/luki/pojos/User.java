package com.luki.pojos;

// class POJO untuk User nya

public class User {
	// enumerator untuk status user
	public static enum Status{
		ACTIVE("A"), 
		PENDING("P"), 
		BLOCKED("B"), 
		NEVER_CREATED("NC");
		
		private final String value;

        private Status(final String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public boolean isGenerationAllowed() {
            return this == PENDING || this == NEVER_CREATED;  // selain status pending dan never_created, akan jadi FALSE
        }
	}
	
	public static enum Gender{
		MALE("M"),
		FEMALE("F"),
		UNSPECIFIED("U");
		
		private final String value;
		
		private Gender(final String value){
			this.value = value;
		}
		
		public String getValue(){
			return value;
		}
		
		// unspecified gender is not allowed at this time lol
		public boolean isGenderAllowed(){
			return this == MALE || this ==FEMALE;
		}
	}
	
	private String nama;
	private String alamat;
	private Gender gender;
	private Status status;
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(final Gender gender) {
		this.gender = gender;
	}	
	public Status getStatus(){
		return status;
	}
	public void setStatus(final Status statusEnum){
		this.status = statusEnum;
	}
}
