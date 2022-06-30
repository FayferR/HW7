package com.example.hw7

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw7.databinding.FragmentMainBinding

class MainFragment : Fragment(), OnItemLongClick {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var data = arrayListOf<Animal>()
        for (i in 0..10) {
            data.add(
                Animal(
                    name = "Cat",
                    image = "https://pngroyale.com/wp-content/uploads/2021/12/Download-adorable-cat-PNG.png"
                )
            )
        }
        val adapter = AnimalAdapter(data, this)
        binding.recyclerView.adapter = adapter
    }

    override fun onLongClick(animal: Animal) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.apply {
            setTitle("Удалить?")
            setPositiveButton("Да") { _, _ ->
                showToast("Вы удалили $animal")
            }
            setNegativeButton("Нет") { dialog, _ ->
                dialog.dismiss()
            }
        }
        alertDialog.create().show()
    }
}