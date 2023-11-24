package FeedService;

import DB.InMemoryDB;
import Model.Post;
import Model.User;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class FeedService {

    public List<Post> getNewsFeedPaginated(Integer userId, Integer pageNumber){
        List<Post> postList = getNewsFeed(userId);
        // handle array index out of bounds here
        return postList.subList(pageNumber, (pageNumber+1));

    }


    public List<Post> getNewsFeed(int userId) {
        if( !InMemoryDB.userMap.containsKey(userId)){
            InMemoryDB.LOGGER.log(Level.SEVERE, "No user with " + userId + "present");
        }
        List<User> followeeList = InMemoryDB.userMap.get(userId).getFollowees();
        List<Post> postListByFollowee = new ArrayList<Post>();
        for ( User user: followeeList  ){
            List<Integer> postIdByUser = user.getPostsByUser();
            for(int postId : postIdByUser) {
                if ( InMemoryDB.postMap.containsKey(postId)){
                    postListByFollowee.add( InMemoryDB.postMap.get(postId));
                }
                else{
                    InMemoryDB.LOGGER.log(Level.WARNING, " post with " + postId + "is deleted");
                    postListByFollowee.remove(postId);
                }
            }
        }
        return postListByFollowee;
    }

}
