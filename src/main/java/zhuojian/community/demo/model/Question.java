package zhuojian.community.demo.model;


public class Question {

  private long id;
  private String title;
  private String description;
  private long gmtCreate;
  private long gmtModified;
  private long creatorId;
  private long commentCount;
  private long viewCount;
  private long likeCount;
  private String tag;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(long gmtCreate) {
    this.gmtCreate = gmtCreate;
  }


  public long getGmtModified() {
    return gmtModified;
  }

  public void setGmtModified(long gmtModified) {
    this.gmtModified = gmtModified;
  }


  public long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(long creatorId) {
    this.creatorId = creatorId;
  }


  public long getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(long commentCount) {
    this.commentCount = commentCount;
  }


  public long getViewCount() {
    return viewCount;
  }

  public void setViewCount(long viewCount) {
    this.viewCount = viewCount;
  }


  public long getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(long likeCount) { this.likeCount = likeCount; }


  public String getTag() { return tag; }

  public void setTag(String tag) {
    this.tag = tag;
  }

}
