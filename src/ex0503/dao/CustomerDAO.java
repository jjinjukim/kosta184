package ex0503.dao;

import java.util.List;

import ex0503.dto.CustomerDTO;

public interface CustomerDAO {
   /**
    * id중복체크
    * @return :"중복입니다." or"사용가능합니다."
    */
   String idCheck(String id);
	
	
	/**
	 * Customer등록
	 * */
	int insert(CustomerDTO customerDTO);
	
	/**
	 * 전체검색
	 * */
	List<CustomerDTO>selectAll();
	
	/**
	 * Customer수정
	 * */
	int update(CustomerDTO customerDTO);
	
	/**
	 * Customer삭제
	 * */
	int delete(String id);
	
}
