package com.ahmedkenawy.user.data.repository

import com.ahmedkenawy.user.data.local.database.UserDatabase
import com.ahmedkenawy.user.domain.repository.UserRepository
import com.ahmedkenawy.user.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Implementation of the UserRepository interface.
 * Provides a concrete implementation for interacting with the User data source.
 *
 * @param userDatabase The UserDatabase instance used for database operations.
 */
@Singleton
class UserRepositoryImpl @Inject constructor(private val userDatabase: UserDatabase) : UserRepository {

    /**
     * Inserts a user into the database.
     *
     * @param user The User object to be inserted.
     */
    override suspend fun insertUser(user: User) {
        userDatabase.userDao().insertUser(user)
    }

    /**
     * Retrieves all users from the database.
     *
     * @return A Flow that emits a list of User objects.
     */
    override fun getAllUsers(): Flow<List<User>> = userDatabase.userDao().getAllUsers()
}
