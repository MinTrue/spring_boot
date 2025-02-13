
package com.sds.testapp.model.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.testapp.domain.Notice;
import com.sds.testapp.exception.NoticeException;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public int getTotalCount() {
		return noticeDAO.getTotalCount();
	}
	
	@Override
	public List selectAll(Map map) {
		return noticeDAO.selectAll(map);
	}

	//글 상세보기
	public Notice select(int notice_idx) {
		
		noticeDAO.updateHit(notice_idx); //글 내용 가져오기 전에 조회 증가
		
		Notice notice = noticeDAO.select(notice_idx);
		
		return notice;
	}

	@Override
	public void insert(Notice notice) throws NoticeException{
		int result = noticeDAO.insert(notice);

		if(result < 1) {
			throw new NoticeException("글등록 실패"); //일부러 에러 발생 try로 잡지 말자
		}
	}

	@Override
	public void update(Notice notice) throws NoticeException {
		int result = noticeDAO.update(notice);
		if(result <1){
			throw new NoticeException("수정실패");
		}
	}

	@Override
	public void delete(Notice notice) throws NoticeException {
		int result = noticeDAO.delete(notice);
		if(result <1) {
			throw new NoticeException("삭제 실패");
		}
	}
	
	
	
}
