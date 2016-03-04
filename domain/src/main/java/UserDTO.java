import java.util.LinkedList;
import java.util.List;

/**
 * Created by chris on 2016/03/02.
 */
public class UserDTO {

    private String username ;
    private List<UserDTO> followers;
    private List <MessageDTO> messages;

    public UserDTO(String username) {
        this.username = username;
    }

    public UserDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        return username.equals(userDTO.username);

    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserDTO> getFollowers() {
        if(followers == null)
            followers  = new AGMessengerList<UserDTO>();
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }


    public void addFollower (UserDTO userDTO){
        if(getFollowers()==null)
            setFollowers(new AGMessengerList<UserDTO>());
            getFollowers().add(userDTO);
    }

    public void addMessage (MessageDTO message){
        if(getMessages() == null)
            setMessages(new LinkedList<MessageDTO>());
        getMessages().add(message);
    }

    public void doDeepCopyOfFollers(UserDTO userDTO){
        if(userDTO.getFollowers()!=null) {
            for(UserDTO follower : userDTO.getFollowers()){
                if(!this.getFollowers().contains(follower))
                    this.addFollower(follower);
            }
        }
    }
}
