package com.gsamdev.clase1.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gsamdev.clase1.databinding.ItemUserBinding
import com.gsamdev.clase1.models.UserModel

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemUserBinding.bind(view)
    fun render(userModel: UserModel) {
        binding.txtNameUser.text = userModel.name
        binding.txtPhone.text = userModel.phone
    }

}