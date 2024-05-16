package com.ahmedkenawy.user.di

import com.ahmedkenawy.user.data.local.database.UserDatabase
import com.ahmedkenawy.user.data.repository.UserRepositoryImpl
import com.ahmedkenawy.user.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module that provides the UserRepository instance.
 *
 * The @Module annotation tells Dagger that this is a Dagger module.
 * The @InstallIn annotation specifies the component in which the module will be installed.
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    /**
     * Provides a singleton instance of UserRepository.
     *
     * @param userDatabase The UserDatabase instance used for database operations.
     * @return A UserRepository instance that interacts with the UserDatabase.
     */
    @Singleton
    @Provides
    fun provideUserRepository(
        userDatabase: UserDatabase
    ): UserRepository {
        return UserRepositoryImpl(userDatabase)
    }
}
