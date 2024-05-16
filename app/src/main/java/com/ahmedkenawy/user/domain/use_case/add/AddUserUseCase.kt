package com.ahmedkenawy.user.domain.use_case.add

import com.ahmedkenawy.user.domain.repository.UserRepository
import com.ahmedkenawy.user.domain.model.User
import javax.inject.Inject

/**
 * Use case for adding a user.
 *
 * @param repository The UserRepository instance used for performing user-related operations.
 */
class AddUserUseCase @Inject constructor(private val repository: UserRepository) {

    /**
     * Invokes the use case to insert a user into the repository.
     *
     * @param user The User object to be inserted.
     */
    suspend operator fun invoke(user: User) {
        repository.insertUser(user)
    }
}
