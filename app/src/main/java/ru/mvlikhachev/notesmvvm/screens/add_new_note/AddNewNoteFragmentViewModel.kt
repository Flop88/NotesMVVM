package ru.mvlikhachev.notesmvvm.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mvlikhachev.notesmvvm.model.AppNote
import ru.mvlikhachev.notesmvvm.utilits.REPOSITORY

class AddNewNoteFragmentViewModel (application: Application) : AndroidViewModel(application) {

    fun insert(note: AppNote, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) { // Must Dispatchers.IO
            REPOSITORY.insert(note){
                onSuccess()
            }
        }
}