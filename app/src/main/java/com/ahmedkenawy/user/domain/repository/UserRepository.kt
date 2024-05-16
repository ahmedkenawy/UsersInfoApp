package com.ahmedkenawy.user.domain.repository

import com.ahmedkenawy.user.domain.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for managing user data.
 * Provides abstract methods for performing operations on the User data.
 */
interface UserRepository {

    /**
     * Inserts a user into the repository.
     *
     * @param user The User object to be inserted.
     */
    suspend fun insertUser(user: User)

    /**
     * Retrieves all users from the repository.
     *
     * @return A Flow that emits a list of User objects.
     */
    fun getAllUsers(): Flow<List<User>>
}
