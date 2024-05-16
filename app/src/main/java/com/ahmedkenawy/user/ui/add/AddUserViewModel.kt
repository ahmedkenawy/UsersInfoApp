package com.ahmedkenawy.user.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedkenawy.user.domain.use_case.UserUseCase
import com.ahmedkenawy.user.domain.model.User
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * ViewModel for adding a new user.
 *
 * @param usersUseCase The UserUseCase instance used for managing user-related operations.
 */
@HiltViewModel
class AddUserViewModel @Inject constructor(private val usersUseCase: UserUseCase) :
    ViewModel() {

    /**
     * Inserts a new user into the repository.
     *
     * @param user The User object to be inserted.
     */
    private fun insertUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            usersUseCase.addUserUseCase.invoke(user)
        }
    }

    /**
     * Validates if a TextInputEditText is not empty and sets error if it is.
     *
     * @param textInputEditText The TextInputEditText to be validated.
     * @param textInputLayout The TextInputLayout associated with the TextInputEditText.
     * @return True if the TextInputEditText is not empty, false otherwise.
     */
    private fun isAValidView(
        textInputEditText: TextInputEditText,
        textInputLayout: TextInputLayout
    ): Boolean {
        val isEmpty = textInputEditText.text.isNullOrBlank()
        textInputLayout.error = if (isEmpty) "This Field Is Required" else ""
        return !isEmpty
    }

    /**
     * Inserts user data into the repository if all TextInputEditText fields are valid.
     *
     * @param dataPairs Array of Pair objects containing TextInputEditText and TextInputLayout pairs.
     * @param user The User object to be inserted.
     */
    fun insertDataIfIsValid(
        vararg dataPairs: Pair<TextInputEditText, TextInputLayout>,
        user: User, onSuccess: () -> Unit
    ) {
        if (dataPairs.all { isAValidView(it.first, it.second) }){
            runBlocking { insertUser(user) }
            onSuccess()
        }
    }
}
