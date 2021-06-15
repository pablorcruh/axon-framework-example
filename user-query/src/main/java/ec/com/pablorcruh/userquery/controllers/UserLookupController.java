package ec.com.pablorcruh.userquery.controllers;


import ec.com.pablorcruh.userquery.dto.UserLookupResponse;
import ec.com.pablorcruh.userquery.queries.FindAllUserQuery;
import ec.com.pablorcruh.userquery.queries.FindUserByIdQuery;
import ec.com.pablorcruh.userquery.queries.SearchUsersQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/userLookup")
public class UserLookupController {

    private final QueryGateway queryGateway;

    @Autowired
    public UserLookupController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/")
    @PreAuthorize("hasAuthority('READ_PRIVILEGES')")
    public ResponseEntity<UserLookupResponse> getAllUsers(){
        try{
            var query = new FindAllUserQuery();
            var response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookupResponse.class)).join();

            if(response == null || response.getUsers() == null){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch(Exception e){
            var safeErrorMessage = "Failed to get all users";
            System.out.println(e.toString());
            return new ResponseEntity<>(new UserLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/byId/{id}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGES')")
    public ResponseEntity<UserLookupResponse> getUserById(@PathVariable(value = "id") String id){
        try{
            var query = new FindUserByIdQuery(id);
            var response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookupResponse.class)).join();
            if(response == null || response.getUsers() == null){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch(Exception e){
            var safeErrorMessage = "Failed to get users";
            System.out.println(e.toString());
            return new ResponseEntity<>(new UserLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(path = "/byFilter/{filter}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGES')")
    public ResponseEntity<UserLookupResponse> searchUserByFilter(@PathVariable(value = "filter") String filter){
        try{
            var query = new SearchUsersQuery(filter);
            var response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookupResponse.class)).join();
            if(response == null || response.getUsers() == null){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch(Exception e){
            var safeErrorMessage = "Failed to search users";
            System.out.println(e.toString());
            return new ResponseEntity<>(new UserLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
