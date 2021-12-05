package com.jl.shenzhuo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * @Date: 2021/12/4
 * @Time: 21:03
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer PKId;
    private Integer CreateUserId;
    private Integer ModifiedUserId;
    private String CreateDateTime;
    private String UserName;
    private String Password;
    private String Telephone;
    private String Address;
    private String flag;//标志  0没有激活  1表示激活 2 无效删除
    private Integer role;//角色 0管理员 1普通用户
    private Integer RolesPkId;
    private Integer Types;
    private String LastLoginTime;
    private String Name;
    private String Sex;
    private String TrueName;
    private String Email;
    private File PhotoUrl;
    private Integer unionId;
    private Integer openId;
    private String nickName;
    private File avatarUrl;
    private Integer gender;
    private String province;
    private String city;
    private String country;
    private Integer wxopenid;
    private boolean isfx;
    private boolean iscl;

    public  User(){
    }

    public User(Integer PKId, Integer createUserId, Integer modifiedUserId, String createDateTime, String userName, String password, String telephone, String address, String flag, Integer role, Integer rolesPkId, Integer types, String lastLoginTime, String name, String sex, String trueName, String email, File photoUrl, Integer unionId, Integer openId, String nickName, File avatarUrl, Integer gender, String province, String city, String country, Integer wxopenid, boolean isfx, boolean iscl) {
        this.PKId = PKId;
        CreateUserId = createUserId;
        ModifiedUserId = modifiedUserId;
        CreateDateTime = createDateTime;
        UserName = userName;
        Password = password;
        Telephone = telephone;
        Address = address;
        this.flag = flag;
        this.role = role;
        RolesPkId = rolesPkId;
        Types = types;
        LastLoginTime = lastLoginTime;
        Name = name;
        Sex = sex;
        TrueName = trueName;
        Email = email;
        PhotoUrl = photoUrl;
        this.unionId = unionId;
        this.openId = openId;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.province = province;
        this.city = city;
        this.country = country;
        this.wxopenid = wxopenid;
        this.isfx = isfx;
        this.iscl = iscl;
    }
}
