package UserData

import android.content.Context

internal class UserSharedPrefences(context:Context) {
    companion object {
        private const val NamePref = "Identy"
        private const val token = ""
    }
    private val prefen = context.getSharedPreferences(NamePref,Context.MODE_PRIVATE)

    fun getuser() : Model{
        val data = Model()
        data.data = prefen.getString(token,"")

        return data
    }
    fun setUser(value: Model){
        val ins = prefen.edit()
        ins.putString(token,value.data)

        ins.apply()
    }
}