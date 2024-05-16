package com.ahmedkenawy.user.ui.view_all


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmedkenawy.footballleague.databinding.ItemUserBinding
import com.ahmedkenawy.user.domain.model.User

/**
 * Adapter for displaying a list of users in a RecyclerView.
 *
 * @param userList The list of users to be displayed.
 */
class UserAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new UserViewHolder that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.binding.user = currentUser
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount() = userList.size

    /**
     * ViewHolder for displaying each user item in the RecyclerView.
     *
     * @param binding The ItemUserBinding associated with the user item layout.
     */
    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)
}
