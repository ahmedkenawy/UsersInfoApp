package com.ahmedkenawy.user.domain.use_case

import com.ahmedkenawy.user.domain.use_case.add.AddUserUseCase
import com.ahmedkenawy.user.domain.use_case.view_all.ViewAllUsersUseCase

/**
 * Data class representing a collection of user-related use cases.
 *
 * @param addUserUseCase The use case for adding a user.
 * @param viewAllUsersUseCase The use case for viewing all users.
 */
data class UserUseCase(
    val addUserUseCase: AddUserUseCase,
    val viewAllUsersUseCase: ViewAllUsersUseCase
)
