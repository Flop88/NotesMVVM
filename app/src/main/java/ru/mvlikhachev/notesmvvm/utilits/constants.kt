package ru.mvlikhachev.notesmvvm.utilits

import ru.mvlikhachev.notesmvvm.MainActivity
import ru.mvlikhachev.notesmvvm.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DatabaseRepository

const val TYPE_DATABASE = "type database"
const val TYPE_ROOM = "type room"