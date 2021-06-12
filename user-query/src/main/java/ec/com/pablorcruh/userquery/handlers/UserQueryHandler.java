package ec.com.pablorcruh.userquery.handlers;

import ec.com.pablorcruh.userquery.dto.UserLookupResponse;
import ec.com.pablorcruh.userquery.queries.FindAllUserQuery;
import ec.com.pablorcruh.userquery.queries.FindUserByIdQuery;
import ec.com.pablorcruh.userquery.queries.SearchUsersQuery;

public interface UserQueryHandler {

    UserLookupResponse getUserById(FindUserByIdQuery query);
    UserLookupResponse searchUsers(SearchUsersQuery query);
    UserLookupResponse getAllUsers(FindAllUserQuery query);
}
