package com.example.hw7

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.addFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null)
        .commit()
}

fun ImageView.loadData(url: String){
    Glide.with(this).load(url).into(this)
}