
package com.sds.testapp.model.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.testapp.domain.Board;
import com.sds.testapp.exception.BoardException;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private MybatisBoardDAO mybatisBoardDAO;
	
	@Override
	public List selectBySearch(String title) {
		return mybatisBoardDAO.selectBySearch(title);
	}
	
	@Override
	public int getTotalCount() {
		return mybatisBoardDAO.getTotalCount();
	}
	
	public List selectAll(Map map) {
		return mybatisBoardDAO.selectAll(map);
	}

	//한건 가져오기
	public Board select(int board_idx) {
		return mybatisBoardDAO.select(board_idx);
	}

	//글 등록하기
	public void insert(Board board) throws BoardException{
		int result = mybatisBoardDAO.insert(board);
		
		if(result < 1) {
			throw new BoardException("글등록 실패");
		}
		
	}

	//1건 수정하기
	public void update(Board board) throws BoardException{
		int result = mybatisBoardDAO.update(board);
		
		if(result <1) {
			throw new BoardException("글수정 실패");
		}
		
	}

	//1건 삭제하기
	public void delete(Board board) throws BoardException {
		int result = mybatisBoardDAO.delete(board);
		
		if(result<1) {
			throw new BoardException("삭제 실패");
		}
		
	}

}
