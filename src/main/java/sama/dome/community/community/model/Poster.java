package sama.dome.community.community.model;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("postlist")
public class Poster {
    private Integer id;
    private String title;
    private String discritpion;
    private String tags;
    private Long gmt_creat;
    private Long gmt_modifed;
    private Integer creatorId;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscritpion() {
        return discritpion;
    }

    public void setDiscritpion(String discritpion) {
        this.discritpion = discritpion;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getGmt_creat() {
        return gmt_creat;
    }

    public void setGmt_creat(Long gmt_creat) {
        this.gmt_creat = gmt_creat;
    }

    public Long getGmt_modifed() {
        return gmt_modifed;
    }

    public void setGmt_modifed(Long gmt_modifed) {
        this.gmt_modifed = gmt_modifed;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }
}
