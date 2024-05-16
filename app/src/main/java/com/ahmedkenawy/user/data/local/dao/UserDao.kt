package com.ahmedkenawy.user.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmedkenawy.user.domain.model.User
import kotlinx.coroutines.flow.Flow


/**
 * Data Access Object (DAO) interface for the User entity.
 * Provides methods for interacting with the users table in the database.
 */
@Dao
interface UserDao {

    /**
     * Retrieves all users from the users table.
     *
     * @return A Flow that emits a list of User objects.
     */
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>

    /**
     * Inserts a user into the users table. If the user already exists, it will be replaced.
     *
     * @param user The User object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
}
