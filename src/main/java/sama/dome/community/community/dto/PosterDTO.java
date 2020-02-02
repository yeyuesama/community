package sama.dome.community.community.dto;

import sama.dome.community.community.model.userinfo;

public class PosterDTO {
    private Integer id;
    private String title;
    private String discritpion;
    private String tags;
    private Long gmtcreat;
    private Long gmtmodifed;
    private Integer creatorId;
    private Integer commentcount;
    private Integer viewcount;
    private Integer likecount;
    private userinfo user;

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

    public Long getGmtcreat() {
        return gmtcreat;
    }

    public void setGmtcreat(Long gmtcreat) {
        this.gmtcreat = gmtcreat;
    }

    public Long getGmtmodifed() {
        return gmtmodifed;
    }

    public void setGmtmodifed(Long gmtmodifed) {
        this.gmtmodifed = gmtmodifed;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }






    public userinfo getUser() {
        return user;
    }

    public void setUser(userinfo user) {
        this.user = user;
    }
}
