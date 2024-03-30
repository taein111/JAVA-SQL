package manager2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// dao 클래스 생성해서 crud 메서드 만들기 
public class MemberDao {
	//db 역할하는
	private Map<Integer, MemberVo> db = new HashMap<>();
	
	//c
	public void insertMember(MemberVo vo) {
		vo.setDate(new Date());
		db.put(vo.getNum(), vo);
	}
	
	//r
	public MemberVo selectMember(int num) {
		return db.get(num);
	}
	
	public List<MemberVo> selectMemberAll(){
		return new ArrayList<MemberVo>(db.values());	
	}
	
	//u
	public void updateMember(MemberVo vo) {
		db.put(vo.getNum(), vo);
		
	}
	
	//d
	public void deleteMember(int num) {
		db.remove(num);
	}
	
	public void deleteMemberAll() {
		db.clear();
	}
}
