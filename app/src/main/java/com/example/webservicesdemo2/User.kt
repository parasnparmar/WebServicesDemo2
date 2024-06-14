package com.example.webservicesdemo2

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(
    var id : Int,
    var email: String,
    var first_name: String,
    var last_name: String,
    var avatar: String
)