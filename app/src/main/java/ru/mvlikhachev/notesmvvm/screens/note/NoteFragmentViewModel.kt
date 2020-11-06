package ru.mvlikhachev.notesmvvm.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mvlikhachev.notesmvvm.model.AppNote
import ru.mvlikhachev.notesmvvm.utilits.REPOSITORY

class NoteFragmentViewModel(application: Application): AndroidViewModel(application) {

    fun delete(note: AppNote, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {// MUST BE Dispatchers.IO
            REPOSITORY.delete(note) {
                onSuccess()
            }
        }

}