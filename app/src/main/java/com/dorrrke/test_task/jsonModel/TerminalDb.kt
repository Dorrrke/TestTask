package com.dorrrke.test_task.jsonModel

import Maps
import Worktable
import Worktables
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TerminalDb() : Serializable{
    lateinit var name: String
    lateinit var address: String
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    lateinit var maps: String
    lateinit var worktables: ArrayList<Worktable>
}