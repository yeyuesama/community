package sama.dome.community.community.service.Realize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sama.dome.community.community.mapper.PosterMapper;
import sama.dome.community.community.model.Poster;
import sama.dome.community.community.service.IPostService;

import java.util.List;

@Service
public class PostService implements IPostService{
    @Autowired
    PosterMapper posterMapper;

    @Override
    public Boolean addPost(Poster poster) {
        Boolean re;
        if (posterMapper.creatPost(poster) > 0) {
            re = true;
        } else {
            re = false;
        }
        return re;
    }

    public List<Poster> selectAll() {
        return posterMapper.selectAll();
    }
}
