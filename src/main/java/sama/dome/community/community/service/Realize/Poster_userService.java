package sama.dome.community.community.service.Realize;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sama.dome.community.community.dto.PosterDTO;
import sama.dome.community.community.mapper.PosterMapper;
import sama.dome.community.community.mapper.UserMapper;
import sama.dome.community.community.model.Poster;
import sama.dome.community.community.model.userinfo;
import sama.dome.community.community.service.IPoster_userService;

import java.util.ArrayList;
import java.util.List;

@Service
public class Poster_userService implements IPoster_userService {
    @Autowired
    PosterMapper posterMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<PosterDTO> Post_user() {

        List<PosterDTO> posters = posterMapper.selectAll();

//        List<PosterDTO> posterDTOS = new ArrayList<>();
        for(PosterDTO poster : posters){
            userinfo user = userMapper.getuserByid(poster.getCreatorId());
//            PosterDTO posterDTO = new PosterDTO();
//            //根据属性名字进行复制赋值
//            BeanUtils.copyProperties(poster,posterDTO);
//            posterDTO.setUser(user);
            poster.setUser(user);
//            posterDTOS.add(posterDTO);
        }
        return posters;
    }
}
