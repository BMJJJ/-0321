package t6_ex;

public class NetpayVO {
	private int idx;
	private int suban;
	private String buseo;
	private String name;
	private String jikkub;
	private int age ;
	private int ipasail;
	private String gender;
	private String address;
	
	private int bonbong;//salary 테이블

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getSuban() {
		return suban;
	}

	public void setSuban(int suban) {
		this.suban = suban;
	}

	public String getBuseo() {
		return buseo;
	}

	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJikkub() {
		return jikkub;
	}

	public void setJikkub(String jikkub) {
		this.jikkub = jikkub;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIpasail() {
		return ipasail;
	}

	public void setIpasail(int ipasail) {
		this.ipasail = ipasail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBonbong() {
		return bonbong;
	}

	public void setBonbong(int bonbong) {
		this.bonbong = bonbong;
	}

	@Override
	public String toString() {
		return "NetpayVO [idx=" + idx + ", suban=" + suban + ", buseo=" + buseo + ", name=" + name + ", jikkub=" + jikkub
				+ ", age=" + age + ", ipasail=" + ipasail + ", gender=" + gender + ", address=" + address + ", bonbong="
				+ bonbong + "]";
	}

}
