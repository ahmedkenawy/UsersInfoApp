package com.ahmedkenawy.user.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmedkenawy.user.data.local.dao.UserDao
import com.ahmedkenawy.user.domain.model.User


/**
 * Abstract class representing the User database.
 * Extends RoomDatabase to provide the database configuration and serve as the main access point to the persisted data.
 *
 * @Database annotation specifies the entities and version number of the database.
 */
@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    /**
     * Provides access to the UserDao for performing CRUD operations on the users table.
     *
     * @return An instance of UserDao.
     */
    abstract fun userDao(): UserDao
}
