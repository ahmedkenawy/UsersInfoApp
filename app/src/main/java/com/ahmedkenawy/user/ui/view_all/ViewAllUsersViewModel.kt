package com.ahmedkenawy.user.ui.view_all

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedkenawy.user.domain.use_case.UserUseCase
import com.ahmedkenawy.user.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for viewing all users.
 *
 * @param usersUseCase The UserUseCase instance used for managing user-related operations.
 */
@HiltViewModel
class ViewAllUsersViewModel @Inject constructor(private val usersUseCase: UserUseCase) :
    ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    /**
     * Fetches all users and updates the StateFlow with the latest user data.
     */
    init {
        fetchUsers()
    }

    /**
     * Fetches all users from the repository and updates the StateFlow with the latest user data.
     * Handles errors if any occur during the fetch operation.
     */
    private fun fetchUsers() {
        viewModelScope.launch {
            usersUseCase.viewAllUsersUseCase.invoke()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    Log.d("ViewAllUsersViewModel", "Error fetching users: ${e.message}")
                }
                .collect {
                    _users.value = it
                }
        }
    }
}
