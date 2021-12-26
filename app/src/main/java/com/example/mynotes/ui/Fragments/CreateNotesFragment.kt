package com.example.mynotes.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mynotes.Model.Notes
import com.example.mynotes.R
import com.example.mynotes.ViewModel.NotesViewModel
import com.example.mynotes.databinding.FragmentCreateNotesBinding
import java.lang.String.format
import java.util.*

class CreateNotesFragment : Fragment() {
    lateinit var binding:FragmentCreateNotesBinding
    var priority: String = "1"
    val viewModel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCreateNotesBinding.inflate(layoutInflater,container,false)

        binding.pPink.setImageResource(R.drawable.ic_baseline_done_24)

        binding.pPink.setOnClickListener {
            priority = "1"
            binding.pPink.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pBlue.setImageResource(0)
            binding.pPurple.setImageResource(0)
        }
        binding.pBlue.setOnClickListener {
            priority = "2"
            binding.pBlue.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pPurple.setImageResource(0)
            binding.pPink.setImageResource(0)
        }
        binding.pPurple.setOnClickListener {
            priority = "3"
            binding.pPurple.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pPink.setImageResource(0)
            binding.pBlue.setImageResource(0)
        }

        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {
        val title = binding.edtTitle.text.toString()
        val subTitle = binding.edtSubTitle.text.toString()
        val notes= binding.edtNotes.text.toString()

        val d = Date()
        val notesDate: CharSequence = DateFormat.format("d MMMM yyyy",d.time)

        val data = Notes(null,
            title = title,
            subTitle = subTitle,
            notes = notes,
            date = notesDate.toString(),
            priority
        )
        viewModel.addNotes(data)

        Toast.makeText(requireContext(), "Notes Created Successfully", Toast.LENGTH_SHORT).show()

    }

}