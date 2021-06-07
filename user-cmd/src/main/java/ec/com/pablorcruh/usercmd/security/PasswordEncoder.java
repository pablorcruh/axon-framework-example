package ec.com.pablorcruh.usercmd.security;

public interface PasswordEncoder {

    String hashPassword(String password);
}
