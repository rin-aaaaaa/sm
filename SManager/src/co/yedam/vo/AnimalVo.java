package co.yedam.vo;

public class AnimalVo extends MasterVo{
//	private String masterId; // 사용자 아이디
	private String masterNickname; // 사용자 닉네임
 
	private int animalId; // 반려동물 아이디
	private String animalName; // 수정할 반려동물 이름
	private String animalType; // 반려동물 종류
	private String animalSpecies; // 반려동물 품종
	private String animalBirthDate; // 반려동물 생일
	private String animalImportant; // 반려동물 특이사항

	
//	public String getMasterId() {
//		return masterId;
//	}
//	public void setMasterId(String masterId) {
//		this.masterId = masterId;
//	}
	public String getMasterNickname() {
		return masterNickname;
	}
	public void setMasterNickname(String masterNickname) {
		this.masterNickname = masterNickname;
	}
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public String getAnimalSpecies() {
		return animalSpecies;
	}
	public void setAnimalSpecies(String animalSpecies) {
		this.animalSpecies = animalSpecies;
	}
	public String getAnimalBirthDate() {
		return animalBirthDate;
	}
	public void setAnimalBirthDate(String animalBirthDate) {
		this.animalBirthDate = animalBirthDate;
	}
	public String getAnimalImportant() {
		return animalImportant;
	}
	public void setAnimalImportant(String animalImportant) {
		this.animalImportant = animalImportant;
	}
	
	
	public String animalShow() {
		return String.format("%-10s %-10s %-10s %-10s %-15s %-10s",masterNickname, animalName, animalType, animalSpecies, 
				animalBirthDate, animalImportant);
	}
		

		

	@Override
	public String toString() {
		return "AnimalVo [masterNickname=" + this.getMasterNickname() + ", animalId=" + animalId + ", animalName=" + animalName
				+ ", animalType=" + animalType + ", animalSpecies=" + animalSpecies + ", animalBirthDate="
				+ animalBirthDate + ", animalImportant=" + animalImportant + "]";
	}
}
	