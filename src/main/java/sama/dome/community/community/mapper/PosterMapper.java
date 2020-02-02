package sama.dome.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sama.dome.community.community.dto.PosterDTO;
import sama.dome.community.community.model.Poster;

import java.util.List;

@Repository
@Mapper
public interface PosterMapper {
    @Insert("insert into postlist(title,discritpion,gmtcreat,gmtmodifed,creatorId,tags) values(#{title},#{discritpion},#{gmtcreat},#{gmtmodifed},#{creatorId},#{tags})")
    int creatPost(Poster poster);

    List<PosterDTO> selectAll();

 }
