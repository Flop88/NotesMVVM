package ru.mvlikhachev.notesmvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.mvlikhachev.notesmvvm.database.room.AppRoomDatabase
import ru.mvlikhachev.notesmvvm.database.room.AppRoomRepository
import ru.mvlikhachev.notesmvvm.utilits.REPOSITORY
import ru.mvlikhachev.notesmvvm.utilits.TYPE_FIREBASE
import ru.mvlikhachev.notesmvvm.utilits.TYPE_ROOM
import ru.mvlikhachev.notesmvvm.utilits.showToast

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(type: String, onSuccess:() -> Unit) {

        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                showToast(TYPE_FIREBASE)
            }
        }

    }
}