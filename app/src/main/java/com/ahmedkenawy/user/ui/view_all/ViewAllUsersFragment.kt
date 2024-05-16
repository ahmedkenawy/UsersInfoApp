package com.ahmedkenawy.user.ui.view_all

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ahmedkenawy.footballleague.R
import com.ahmedkenawy.footballleague.databinding.FragmentViewAllUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Fragment for viewing all users.
 */
@AndroidEntryPoint
class ViewAllUsersFragment : Fragment() {

    private lateinit var binding: FragmentViewAllUsersBinding
    private lateinit var userAdapter: UserAdapter
    private val viewModel by viewModels<ViewAllUsersViewModel>()

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
        binding = FragmentViewAllUsersBinding.inflate(layoutInflater)

        lifecycleScope.launch {
            viewModel.users.collect { users ->
                userAdapter = UserAdapter(users)
                binding.adapter = userAdapter
            }
        }
        binding.btnAddUser.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_viewAllUsersFragment_to_addUserFragment)
        }

        return binding.root
    }
}
