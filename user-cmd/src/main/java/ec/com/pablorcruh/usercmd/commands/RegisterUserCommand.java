package ec.com.pablorcruh.usercmd.commands;

import com.example.usercore.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class RegisterUserCommand {

    @TargetAggregateIdentifier
    private String id;

    @Valid
    @NotNull(message = "no user details were supplied")
    private User user;

}
