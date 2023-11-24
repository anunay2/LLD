package Model;

import java.util.List;

public class User {
    int userId;
    List<User> followers;
    List<User> followees;

    public List<Integer> getPostsByUser() {
        return postsByUser;
    }

    public void setPostsByUser(List<Integer> postsByUser) {
        this.postsByUser = postsByUser;
    }

    List<Integer> postsByUser;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowees() {
        return followees;
    }

    public void setFollowees(List<User> followees) {
        this.followees = followees;
    }
}
