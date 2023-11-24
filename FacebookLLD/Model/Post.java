package Model;

import java.sql.Timestamp;

public class Post {
    int postId;

    public Post() {
    }

    String content;
    User postedBy;
    Timestamp timeOfPost;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public Timestamp getTimestamp() {
        return timeOfPost;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timeOfPost = timestamp;
    }

}
