package com.example.webservicesdemo2

import android.os.AsyncTask
import android.os.Handler
import android.os.Message

class WebThread(private val handler: Handler) : AsyncTask<Any, Any, ArrayList<User>>(){
    override fun doInBackground(vararg params: Any?): ArrayList<User>? {
        return WebUtil.parseJSONToFetchUserData()

    }

    override fun onPostExecute(result: ArrayList<User>?) {
        super.onPostExecute(result)
        
        val message = Message()
        message.obj = result
        handler.sendMessage(message)
    }
}