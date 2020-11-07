package ru.mvlikhachev.notesmvvm.utilits

import ru.mvlikhachev.notesmvvm.MainActivity
import ru.mvlikhachev.notesmvvm.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DatabaseRepository

const val TYPE_DATABASE = "type database"
const val TYPE_ROOM = "type room"

const val TYPE_FIREBASE = "type firebase"
lateinit var EMAIL: String
lateinit var PASSWORD: String

const val ID_FIREBASE = "idFirebase"
const val NAME = "name"
const val TEXT = "text"