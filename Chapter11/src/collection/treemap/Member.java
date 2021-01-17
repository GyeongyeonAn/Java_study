package collection.treemap;

import java.util.Comparator;

public class Member implements Comparator<Member>{

	private int memberID;
	private String memberName;
	
	public Member() {}

	public Member(int memberID, String memberName) {
		this.memberID = memberID;
		this.memberName = memberName;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String toString() {
		return memberName + "ȸ������ ���̵�� " + memberID + "�Դϴ�.";
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Member) {
			Member member = (Member)obj;
			return this.memberID == member.memberID;
		}
		else {
			return false;
		}
		
	}

	@Override
	public int hashCode() {
		return memberID;
	}


	/*
	@Override
	public int compareTo(Member member) {
		
		return (this.memberID - member.memberID);
	}
	*/
	/*
	@Override
	public int compareTo(Member member) {
		
		return this.memberName.compareTo(member.getMemberName());
	}
	*/
	
	@Override
	public int compare(Member member1, Member member2) {
		
		return (member1.memberID - member2.memberID);
	}
	
}