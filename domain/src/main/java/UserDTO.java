import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chris on 2016/03/02.
 */
public class UserDTO {

    private String username ;
    private Set<UserDTO> followers;
    private List <String> messages;

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

    public Set<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserDTO> followers) {
        this.followers = followers;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }


    public void addFollower (UserDTO userDTO){
        if(getFollowers()==null)
            setFollowers(new HashSet<>());
            getFollowers().add(userDTO);
    }
}
