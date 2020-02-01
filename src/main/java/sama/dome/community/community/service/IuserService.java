package sama.dome.community.community.service;

import sama.dome.community.community.model.userinfo;

import java.util.List;

public interface IuserService {
    List<userinfo> getalluser();
    userinfo getuser (String name,String passwd);
    userinfo getuserByaccount(String account);
    Boolean adduser(userinfo userinfo);
}
