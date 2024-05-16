package com.ahmedkenawy.user.domain.use_case.view_all

import com.ahmedkenawy.user.domain.repository.UserRepository
import com.ahmedkenawy.user.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for viewing all users.
 *
 * @param repository The UserRepository instance used for performing user-related operations.
 */
class ViewAllUsersUseCase @Inject constructor(private val repository: UserRepository) {

    /**
     * Invokes the use case to retrieve all users from the repository.
     *
     * @return A Flow that emits a list of User objects.
     */
    operator fun invoke(): Flow<List<User>> {
        return repository.getAllUsers()
    }
}
