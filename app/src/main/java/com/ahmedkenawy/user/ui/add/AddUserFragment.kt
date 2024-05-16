package com.ahmedkenawy.user.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ahmedkenawy.footballleague.databinding.FragmentAddUserBinding
import com.ahmedkenawy.user.domain.model.User
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment for adding a new user.
 * Utilizes AndroidEntryPoint annotation for Dagger Hilt integration.
 */
@AndroidEntryPoint
class AddUserFragment : Fragment() {

    private lateinit var binding: FragmentAddUserBinding
    private val viewModel by viewModels<AddUserViewModel>()

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return Return the View for the fragment's UI, or null.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddUserBinding.inflate(layoutInflater)
        setUpViews()
        return binding.root
    }

    /**
     * Sets up the views and listeners in the fragment.
     */
    private fun setUpViews() {
        binding.btnAddUser.setOnClickListener {
            insertUser()
//            findNavController().navigateUp()
        }
    }

    /**
     * Inserts a new user into the database.
     */
    private fun insertUser() {
        val user = getUserInfo()
        val name = Pair(binding.tvName, binding.etName)
        val age = Pair(binding.tvAge, binding.etAge)
        val jobTitle = Pair(binding.tvJobTitle, binding.etJobTitle)
        val gender = Pair(binding.tvGender, binding.etGender)

        viewModel.insertDataIfIsValid(name, age, jobTitle, gender, user = user){
            findNavController().navigateUp()
        }
    }

    /**
     * Retrieves user information from the input fields.
     *
     * @return User object with the information entered by the user.
     */
    private fun getUserInfo(): User {
        return User(
            name = binding.tvName.text.toString(),
            age = binding.tvAge.text.toString(),
            jobTitle = binding.tvJobTitle.text.toString(),
            gender = binding.tvGender.text.toString()
        )
    }
}
