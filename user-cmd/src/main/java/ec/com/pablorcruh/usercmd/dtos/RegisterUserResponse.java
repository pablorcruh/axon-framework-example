package ec.com.pablorcruh.usercmd.dtos;

import com.example.usercore.dto.BaseResponse;

public class RegisterUserResponse extends BaseResponse {

    private String id;

    public RegisterUserResponse(String id, String message) {
        super(message);
        this.id = id;
    }
}
