package ru.mvlikhachev.notesmvvm.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.mvlikhachev.notesmvvm.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes = REPOSITORY.allNotes


}