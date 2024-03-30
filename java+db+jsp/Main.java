package manager2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<Integer, MemberVo> db = new HashMap<>();
		
		
		//c
		MemberVo vo1 = new MemberVo(1, "taein1", "1111", "taein123");
		MemberVo vo2 = new MemberVo(2, "taein2", "1111", "taein124");
		MemberVo vo3 = new MemberVo(3, "taein3", "1111", "taein125");
		db.put(1, vo1);
		db.put(2, vo2);
		db.put(3, vo3);
		System.out.println("저장 완료!");
		
		//R 전체, 개별선택
		List<MemberVo> li = new ArrayList<>(db.values());
		for(MemberVo temp : li) {
			System.out.println(temp);
		}
		System.out.println("전체 조회 완료");
		
		MemberVo vo = null;
		vo = db.get(1);
		System.out.println("1번회원 정보 :"+ vo);
		
		
		vo = db.get(4);
		System.out.println("4번회원 정보 :"+ vo);
		
		//U 
		vo = db.get(1);
		System.out.println("1번회원 정보 조회"+vo);
		vo = db.get(2);
		System.out.println("2번회원 정보 조회"+vo);
		
		if(vo != null) {
			vo.setMemberpw("2222");
			vo.setNickname("tttaein");
			db.put(vo.getNum(), vo);
		}
			vo= db.get(2);
			System.out.println("2번회원 수정 완료!:"+ vo);
			
		//D
			db.remove(3);
			li = new ArrayList<>(db.values());
			System.out.println("회원 삭제 후 회원 전체조회");
			for(MemberVo temp : li) {
				System.out.println(temp);	
			}
		
			db.clear();
			li = new ArrayList<>(db.values());
			System.out.println("회원 삭제 후 회원 전체조회");
			for(MemberVo temp : li) {
				System.out.println(temp);	
			}
	}

}
