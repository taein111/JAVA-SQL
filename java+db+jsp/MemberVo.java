package manager2;

import java.util.Date;

public class MemberVo {
	private int num;
	private String memberId;
	private String memberpw;
	private String nickname;
	private Date date;
	
	public MemberVo() {}

	public MemberVo(int num, String memberId, String memberpw, String nickname) {
		super();
		this.num = num;
		this.memberId = memberId;
		this.memberpw = memberpw;
		this.nickname = nickname;
		
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberpw() {
		return memberpw;
	}

	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MemberVo [num=" + num + ", memberId=" + memberId + ", memberpw=" + memberpw + ", nickname=" + nickname
				+ ", date=" + date + "]";
	}

	
	
}
