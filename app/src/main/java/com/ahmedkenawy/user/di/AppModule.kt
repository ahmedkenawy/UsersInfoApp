package com.ahmedkenawy.user.di

import com.ahmedkenawy.user.domain.repository.UserRepository
import com.ahmedkenawy.user.domain.use_case.UserUseCase
import com.ahmedkenawy.user.domain.use_case.add.AddUserUseCase
import com.ahmedkenawy.user.domain.use_case.view_all.ViewAllUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module that provides dependencies for the application.
 *
 * The @Module annotation tells Dagger that this is a Dagger module.
 * The @InstallIn annotation specifies the component in which the module will be installed.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Provides a singleton instance of UserUseCase.
     *
     * @param repository The UserRepository instance used for performing user-related operations.
     * @return A UserUseCase instance that contains use cases for adding and viewing users.
     */
    @Provides
    @Singleton
    fun provideUserUseCase(repository: UserRepository): UserUseCase {
        return UserUseCase(
            addUserUseCase = AddUserUseCase(repository),
            viewAllUsersUseCase = ViewAllUsersUseCase(repository)
        )
    }
}
