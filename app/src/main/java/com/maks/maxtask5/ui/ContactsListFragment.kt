package com.maks.maxtask5.ui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.maks.maxtask5.R
import com.maks.maxtask5.databinding.FragmentContactsListBinding

class ContactsListFragment : Fragment() {

    private var _binding: FragmentContactsListBinding? = null
    private val binding get() = _binding!!

    private val names = mutableListOf<TextView>()
    private val sureNames = mutableListOf<TextView>()
    private val numbers = mutableListOf<TextView>()
    private val tvContacts = mutableListOf<ConstraintLayout>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addViews()
        fillContacts()
        setOnClickListeners()
    }
    private fun fillContacts() {
        var i = 0
        for (contact in (requireActivity() as MainActivity).contacts) {
            names[i].text = contact.firstName
            sureNames[i].text = contact.surName
            numbers[i].text = contact.phoneNumber
            i++
        }
    }
    private fun addViews() = with(binding) {
        names.clear()
        names.add(firstUserName)
        names.add(secondUserName)
        names.add(thirdUserName)
        names.add(fourthUserName)

        sureNames.clear()
        sureNames.add(firstUserSurName)
        sureNames.add(secondUserSurName)
        sureNames.add(thirdUserSurName)
        sureNames.add(fourthUserSurName)

        numbers.clear()
        numbers.add(firstUserNumber)
        numbers.add(secondUserNumber)
        numbers.add(thirdUserNumber)
        numbers.add(fourthUserNumber)

        tvContacts.clear()
        tvContacts.add(firstUser)
        tvContacts.add(secondUser)
        tvContacts.add(thirdUser)
        tvContacts.add(fourthUser)
       }

    private fun setOnClickListeners() {
        tvContacts[0].setOnClickListener { setOnClickListener(0) }
        tvContacts[1].setOnClickListener { setOnClickListener(1) }
        tvContacts[2].setOnClickListener { setOnClickListener(2) }
        tvContacts[3].setOnClickListener { setOnClickListener(3) }
    }

    private fun setOnClickListener(i: Int) {
        if(isTablet(requireContext())){
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container_details, ContactDetailsFragment.newInstance(i))
                .addToBackStack("")
                .commit()
        }else{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, ContactDetailsFragment.newInstance(i))
                .addToBackStack(null)
                .commit()
        }
    }

    private fun isTablet(context: Context): Boolean {
        return ((context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }

    companion object {
        fun newInstance() = ContactsListFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


