package ec.com.pablorcruh.usercmd.commands;

import com.example.usercore.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class RegisterUserCommand {

    @TargetAggregateIdentifier
    private String id;

    private User user;

}