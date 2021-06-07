package ec.com.pablorcruh.usercmd.commands;

import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;

@Data
public class RemoveUserCommand {

    @AggregateIdentifier
    private String id;
}
