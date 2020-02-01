package sama.dome.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sama.dome.community.community.model.Poster;

import java.util.List;

@Repository
@Mapper
public interface PosterMapper {
    @Insert("insert into postlist(title,discritpion,gmt_creat,gmt_modifed,creatorId,tags) values(#{title},#{discritpion},#{gmt_creat},#{gmt_modifed},#{creatorId},#{tags})")
    int creatPost(Poster poster);

    List<Poster> selectAll();
}
