package com.sds.testapp.common;

import org.springframework.stereotype.Component;

import lombok.Data;

//페이징 처리 공식을 반복 수행 하지 않기 위한 전담객체
@Data
@Component
public class Pager2 {
	
	private int totalRecord;
	private int pageSize=10;
	private int totalPage;
	private int blockSize=10;
	private int currentPage=1;
	private int firstPage;
	private int lastPage;
	private int startIndex;
	private int num;
	
	
	public void init(int totalRecord, int currentPage) {
		
		this.totalRecord= totalRecord;
		this.totalPage= (int)Math.ceil((float)totalRecord/pageSize);
		this.currentPage= currentPage;
		this.firstPage = this.currentPage - (this.currentPage-1)%blockSize;
		this.lastPage= this.firstPage +(this.blockSize-1);
		
		if(this.totalPage < this.lastPage) {
				this.lastPage = this.totalPage;
		}
		this.startIndex = (this.currentPage-1) *this.pageSize;
		this.num= this.totalRecord - this.startIndex;
	}
	
	
}
