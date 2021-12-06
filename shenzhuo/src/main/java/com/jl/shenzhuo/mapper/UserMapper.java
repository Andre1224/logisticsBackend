package com.jl.shenzhuo.mapper;

import com.jl.shenzhuo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * @Date: 2021/12/5
 * @Time: 23:47
 **/
public interface UserMapper {

    /**
     * 新增账号
     * @param user
     * @return
     */
    @Insert("INSERT INTO users(eamil,password,salt) VALUES (#{eamil},#{password},)")
    int insertUser(User user);

    /**
     * 根据确认码查询用户
     * @param confirmCode
     * @return
     */
    @Select("SELECT email,FROM user WHERE confirmCode = #{confirmCode}")
    User selectUserByConfirmCode(@Param("confirmCode") String confirmCode);

    /**
     * 根据确认码查询用户并修改状态值为1(可用)
     * @param confirmCode
     * @return
     */
    @Update("UPDATE user SET isValid = 1 WHERE confirmCode = #{confirmCode}")
    int updateUserByConfirmCode(@Param("confirmCode") String confirmCode);

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    @Select("SELECT email,password,salt FROM user WHERE email = #{email} AND isValid = 1")
    List<User> selectUserByEmail(@Param("email") String email);
}
