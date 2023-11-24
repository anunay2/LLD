package PostService;


import DB.InMemoryDB;
import Model.Post;
import Model.User;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PostService {



    public void post(int userId, int postId){
        if(InMemoryDB.userMap.containsKey(userId)){
            Post post = new Post();

            post.setPostedBy(InMemoryDB.userMap.get(userId));
            post.setPostId(postId);
            InMemoryDB.postMap.put(postId, post);
        }
        else{
            InMemoryDB.LOGGER.log(Level.SEVERE, "Please create the user Id with : {}", userId);
        }

    }

    public void deletePost(int postId){
        if( InMemoryDB.postMap.containsKey(postId)){
            InMemoryDB.postMap.remove(postId);
        }
        else{
            InMemoryDB.LOGGER.log(Level.WARNING, "No Post with" + postId + " exists");
        }
    }

}
