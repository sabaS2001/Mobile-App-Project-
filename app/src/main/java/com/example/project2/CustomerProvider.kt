package com.example.project2

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class CustomerProvider : ContentProvider () {

    companion object{
        val PROVIDER_NAME = "package com.example.project2/CustomerProvider"
        val URL = "content://$PROVIDER_NAME/customer"
        val CONTENT_URI = Uri.parse(URL)

        val cid = "customer_id"
        val name = "order_name"
        val price = "order_price"
        val quantity = "quantity"
    }

    lateinit var db: SQLiteDatabase

    override fun onCreate(): Boolean {
        val helper = OrderDB(getContext())
        db = helper.writableDatabase
        return if(db==null) false else true
    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_value: Array<out String>?,
        order: String?
    ): Cursor? {
        return db.query("customer", cols, condition, condition_value, null, null, order)
    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.customer"
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("customer", null,cv)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }

    override fun delete(uri: Uri, condition: String?, condition_value: Array<out String>?): Int {
        var count :Int = db.delete("customer", condition, condition_value)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }

    override fun update(uri: Uri, cv: ContentValues?, condition: String?, condition_value: Array<out String>?): Int {
        var count : Int = db.update("customer", cv, condition, condition_value)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }


}