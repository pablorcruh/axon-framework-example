package ec.com.pablorcruh.userquery.dto;

import com.example.usercore.dto.BaseResponse;
import com.example.usercore.models.User;


import java.util.ArrayList;
import java.util.List;


public class UserLookupResponse extends BaseResponse {

    private List<User> users;

    public UserLookupResponse(String message){
        super(message);
    }

    public UserLookupResponse(String message, User user){
        super(message);
        this.users = new ArrayList<>();
        this.users.add(user);
    }


    public UserLookupResponse(User user){
        super(null);
        this.users = new ArrayList<>();
        this.users.add(user);
    }

    public UserLookupResponse(List<User> users) {
        super(null);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
