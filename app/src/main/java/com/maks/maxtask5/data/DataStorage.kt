package com.maks.maxtask5.data

import com.maks.maxtask5.data.entity.Contact

class DataStorage {
    fun getContacts(): MutableList<Contact> {
        return mutableListOf(
            Contact("Vasya", "Ivanov", "+79998887766"),
            Contact("Igor", "Egorov", "+79998287366"),
            Contact("Peter", "Sidorov", "+79555552031"),
            Contact("Ivan", "Vasiliev", "+79299863438"),
        )
    }
}