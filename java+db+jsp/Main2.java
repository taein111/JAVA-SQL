package manager2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		
		//c
		MemberVo vo1 = new MemberVo(1, "taein1", "1111", "taein123");
		vo1.setDate(new Date());
		MemberVo vo2 = new MemberVo(2, "taein2", "1111", "taein124");
		vo2.setDate(new Date());
		MemberVo vo3 = new MemberVo(3, "taein3", "1111", "taein125");
		vo3.setDate(new Date());
		
		dao.insertMember(vo1);
		dao.insertMember(vo2);
		dao.insertMember(vo3);
		System.out.println("dao에 저장 완료!");
		
		//R 전체, 개별선택
		//전체조회
		List<MemberVo> li = dao.selectMemberAll();
		for(MemberVo temp : li) {
			System.out.println(temp);
		}
		System.out.println("전체 조회 완료");
		
		
		//개별조회
		MemberVo vo = null;
		vo = dao.selectMember(1);
		System.out.println("1번회원 정보 :"+ vo);
		
		vo = dao.selectMember(4);
		System.out.println("4번회원 정보 :"+ vo);
		
		//U 
		vo = dao.selectMember(1);
		System.out.println("1번회원 정보 조회"+vo);
		vo = dao.selectMember(2);
		System.out.println("2번회원 정보 조회"+vo);
		
		if(vo != null) {
			vo.setMemberpw("2222");
			vo.setNickname("tttaein");
			dao.updateMember(vo);
		}
			vo= dao.selectMember(2);
			System.out.println("2번회원 수정 완료!:"+ vo);
			
		//D
			dao.deleteMember(3);
			li = dao.selectMemberAll();
			System.out.println("3번회원 삭제 후 회원 전체조회");
			for(MemberVo temp : li) {
				System.out.println(temp);	
			}
		
			
			dao.deleteMemberAll();
			li = dao.selectMemberAll();
			System.out.println("회원전체 삭제 후 회원 전체조회");
			for(MemberVo temp : li) {
				System.out.println(temp);	
			}
	}

}
