package examjdbc01;

import java.util.List;

//사용자가 요청한것이 무엇인가에따라 그것에 관련된 처리를하기위한것 service(처리, 조건, 계산)
public class MemberService {
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//등록하기
	public boolean regist(MemberVo vo) {
		if(memberDao.selectMember(vo.getNum()) == null) {
			memberDao.insertMember(vo);
			return true;
			
		}
		return false;
		
	}
	
	//조회하기
	public MemberVo read(int num) {
		return memberDao.selectMember(num);
		
	}
	//전체조회
	public List<MemberVo> listAll(){
		return memberDao.selectMemberAll();
	}
	
	//수정
	public void edit(MemberVo vo) {
		MemberVo searchMember = memberDao.selectMember(vo.getNum());
		if(searchMember.getMemberpw().equals(vo.getMemberpw())) {
			memberDao.updateMember(vo);
		}
	}
	
	//탈퇴
	public void remove(int num) {
		memberDao.deleteMember(num);
	}
}
