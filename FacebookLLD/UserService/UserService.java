package UserService;

import DB.InMemoryDB;
import Model.User;

import java.util.List;
import java.util.logging.Level;

public class UserService {

    public void follow(int followerId, int followeeId){
        if(InMemoryDB.userMap.containsKey(followerId) && InMemoryDB.userMap.containsKey(followeeId)){
            User newfollower = InMemoryDB.userMap.get(followerId);
            User followeeUser = InMemoryDB.userMap.get(followeeId);

            List<User> followerList = followeeUser.getFollowers();
            followerList.add(newfollower);
            followeeUser.setFollowers(followerList);

            List<User> followeeList = newfollower.getFollowees();
            followeeList.add(followeeUser);
            newfollower.setFollowees(followeeList);
            //u1 -> u2
            // updated the follower List
            InMemoryDB.userMap.put(followeeUser.getUserId(), followeeUser);


        }
        else {
            if( !InMemoryDB.userMap.containsKey(followerId)){
                InMemoryDB.LOGGER.log(Level.SEVERE, "{}: user id does not exist.Please create a user first",followerId);
            }
            if( !InMemoryDB.userMap.containsKey(followeeId)){
                InMemoryDB.LOGGER.log(Level.SEVERE, "{}: user id does not exist.Please create a user first",followerId);
            }
        }
    }

    public void unfollow(int followerId, int followeeId){
        if(InMemoryDB.userMap.containsKey(followerId) && InMemoryDB.userMap.containsKey(followeeId)){
            User followerToBeRemoved = InMemoryDB.userMap.get(followerId);
            User followeeUser = InMemoryDB.userMap.get(followeeId);

            List<User> followerList = followeeUser.getFollowers();

            boolean userFollowesFlag = false;
            for( int i = 0; i < followerList.size(); i++ ) {
                if ( followerList.get(i).getUserId()== followerId) {
                    followerList.remove(i);
                    userFollowesFlag = true;
                    break;
                }
            }
            if( !userFollowesFlag ) {
                InMemoryDB.LOGGER.log(Level.WARNING, "User Id :" + followerId  + "does not follows User Id " + followeeId );
            }
            followeeUser.setFollowers(followerList);

            // updated the followe
            InMemoryDB.userMap.put(followeeUser.getUserId(), followeeUser);


        }
        else {
            if( !InMemoryDB.userMap.containsKey(followerId)){
                InMemoryDB.LOGGER.log(Level.SEVERE, "{}: user id does not exist.Please create a user first",followerId);
            }
            if( !InMemoryDB.userMap.containsKey(followeeId)){
                InMemoryDB.LOGGER.log(Level.SEVERE, "{}: user id does not exist.Please create a user first",followerId);
            }
        }

    }

}
