package ec.com.pablorcruh.usercmd.controllers;

import ec.com.pablorcruh.usercmd.commands.RegisterUserCommand;
import ec.com.pablorcruh.usercmd.dtos.RegisterUserResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/registerUser")
public class RegisterUserController {

    private final CommandGateway commandGateway;

    @Autowired
    public RegisterUserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGES')")
    public ResponseEntity<RegisterUserResponse> registerUser(@Valid  @RequestBody RegisterUserCommand command){
        var id = UUID.randomUUID().toString();
        command.setId(id);
        try{
            commandGateway.sendAndWait(command);
            return new ResponseEntity<>(new RegisterUserResponse(id, "User successfully registered"), HttpStatus.CREATED);
        }catch(Exception e){
            var safeErrorMessage = "Error while proccessing register user request for id: " + id;
            System.out.println(e.toString());
            return new ResponseEntity<>(new RegisterUserResponse(id, safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
