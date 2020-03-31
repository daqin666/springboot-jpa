package com.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bean.UserInfo;
import com.bean.UserMoney;

public interface UserRepository extends JpaRepository<UserInfo, Integer>{
	
	//增
	@Modifying
	@Query(value="insert into user(name, age, sex) values(:#{#info.name}, :#{#info.age}, :#{#info.sex})", 
		nativeQuery=true)
	void addOne(@Param("info") UserInfo userInfo);
	
	//删
	@Modifying
	@Query(value="delete from user where id = :id", nativeQuery=true)
	void deleteById(@Param("id") Integer id);
	
	//改
	@Modifying
	@Query(value="update user u set u.name = ?2 where u.id = ?1", nativeQuery=true)
	void updateNameById(Integer id, String name);
	
	@Modifying
	@Query(value="update user u set u.name = :#{#info.name}, u.age = :#{#info.age}, u.sex = :#{#info.sex} "
			+ "where u.id = :#{#info.id}", nativeQuery=true)
	void updateById(@Param("info") UserInfo userInfo);
	
	//查
	@Query(value="select * from user u where u.sex = :sex", nativeQuery=true)
	List<UserInfo> findBySex(@Param("sex") String sex);

	@Query(value="select * from user where sex = ?1", nativeQuery=true)
	List<UserInfo> findBySex2(String sex);
	
	@Query(value="select * from user where name like %?1", nativeQuery=true)
	List<UserInfo> findByName(String name);
	
	@Query(value="select * from user where name like %?1%", nativeQuery=true)
	List<UserInfo> findByName2(String name);
	
	@Query(value="select * from user where name like %:name%", nativeQuery=true)
	List<UserInfo> findByName3(@Param("name") String name);
	
	@Query(value="select * from user", countQuery="select count(1) from user", nativeQuery=true)
	List<UserInfo> findAllPaging(Pageable pageable);
	
	@Query(value="select u.name, a.money from user u inner join assets a on u.id = a.user_id", nativeQuery=true)
	List<Object> findCustomBeanFromJoinQuery();
	
	
	//增
//	@Override
//	@Modifying
//	default <S extends UserInfo> List<S> saveAll(Iterable<S> entities) {
//		return null;
//	}
//	
//	@Override
//	@Modifying
//	default <S extends UserInfo> S save(S entity) {
//		return null;
//	}
}
