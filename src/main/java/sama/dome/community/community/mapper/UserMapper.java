package sama.dome.community.community.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sama.dome.community.community.model.userinfo;

import java.util.List;

//数据持久化层 定义接口 只进行基本的增删改查操作不进行其他多余的判断
@Repository
@Mapper
public interface UserMapper {
    //查询user数据库中userinfo表里的所有数据
    @Select("select * from userinfo")
    List<userinfo> list();
    //根据id查询用户
    @Select("select * from userinfo where userid=#{id}")
    userinfo getuserByid(Integer id);
    //根据用户提供的还在账号及密码验证用户是否存在
    @Select("select * from userinfo where (username=#{name} and password=#{passwd})")
    userinfo getuser(String name,String passwd);
    //注册验证用户账号是否有重复
    @Select("select * from userinfo where username=#{account}")
    userinfo getuserByaccount(String account);
    //添加用户
    @Insert("insert into userinfo(username,password,nickname,avatar_url) values(#{username},#{password},#{nickname},#{avatar_url})")
    int adduser(userinfo userinfo);
}
