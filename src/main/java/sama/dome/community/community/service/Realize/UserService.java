package sama.dome.community.community.service.Realize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sama.dome.community.community.mapper.UserMapper;
import sama.dome.community.community.model.userinfo;
import sama.dome.community.community.service.IuserService;

import java.util.List;
@Service
public class UserService implements IuserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<userinfo> getalluser() {
        return userMapper.list();
    }

    @Override
    public userinfo getuser(String name, String passwd) {
        return userMapper.getuser(name,passwd);
    }

    @Override
    public userinfo getuserByaccount(String account) {
        return userMapper.getuserByaccount(account);
    }

    @Override
    public Boolean adduser(userinfo userinfo) {
        Boolean bo;
        if (userMapper.adduser(userinfo)>0){
            return true;
        }else{
            return false;
        }
    }

}
