package com.dorrrke.test_task.model

class terminal(
    val name: String,
    val address: String,
    val latitude: String,
    val longitude: String,
    val receiveCargo: Boolean,
    val giveoutCargo: Boolean,
    val default: Boolean,
    val worktables: List<Worktable>,
    val maps_url: String
)