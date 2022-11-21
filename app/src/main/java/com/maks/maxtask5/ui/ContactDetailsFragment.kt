package com.maks.maxtask5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maks.maxtask5.R
import com.maks.maxtask5.data.entity.Contact
import com.maks.maxtask5.databinding.FragmentContactDetailsBinding

class ContactDetailsFragment : Fragment() {

    private var _binding: FragmentContactDetailsBinding? = null
    private val binding get() = _binding!!
    private var index: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            index = it.getInt(INDEX)
        }
        clickOnSaveBtn()
        setData()
    }

    private fun setData() = with(binding) {
        editName.setText((requireActivity() as MainActivity).contacts[index!!].firstName)
        editLastName.setText((requireActivity() as MainActivity).contacts[index!!].surName)
        editPhone.setText((requireActivity() as MainActivity).contacts[index!!].phoneNumber)
    }

    private fun clickOnSaveBtn() = with(binding) {
        btnSave.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, ContactsListFragment())
                .commit()

            (requireActivity() as MainActivity).contacts[index!!] =
                Contact(
                    editName.text.toString(),
                    editLastName.text.toString(),
                    editPhone.text.toString()
                )
        }
    }

    companion object {
        private const val INDEX = "index"

        fun newInstance(index: Int) =
            ContactDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(INDEX, index)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}