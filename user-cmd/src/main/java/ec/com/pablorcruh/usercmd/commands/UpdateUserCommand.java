package ec.com.pablorcruh.usercmd.commands;

import com.example.usercore.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;

@Data
@Builder
public class UpdateUserCommand {

    @AggregateIdentifier
    private String id;

    private User user;
}
