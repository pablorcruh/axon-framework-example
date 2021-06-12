package ec.com.pablorcruh.userquery.handlers;

import ec.com.pablorcruh.userquery.dto.UserLookupResponse;
import ec.com.pablorcruh.userquery.queries.FindAllUserQuery;
import ec.com.pablorcruh.userquery.queries.FindUserByIdQuery;
import ec.com.pablorcruh.userquery.queries.SearchUsersQuery;
import ec.com.pablorcruh.userquery.repository.UserRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserQueryHandlerImpl implements UserQueryHandler{

    private final UserRepository userRepository;

    @Autowired
    public UserQueryHandlerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryHandler
    @Override
    public UserLookupResponse getUserById(FindUserByIdQuery query) {
        var user = userRepository.findById(query.getId());
        return user.isPresent()? new UserLookupResponse(user.get()) : null;
    }

    @QueryHandler
    @Override
    public UserLookupResponse searchUsers(SearchUsersQuery query) {
        var users = new ArrayList<>(userRepository.findByFilterRegex(query.getFilter()));
        return new UserLookupResponse(users);
    }

    @QueryHandler
    @Override
    public UserLookupResponse getAllUsers(FindAllUserQuery query) {
        var users = new ArrayList<>(userRepository.findAll());
        return new UserLookupResponse(users);
    }
}
