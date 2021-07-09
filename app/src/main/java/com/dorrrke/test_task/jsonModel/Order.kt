package com.dorrrke.test_task.jsonModel

import java.io.Serializable

class Order : Serializable {
    var terminalFrom : TerminalDb? = null
    var terminalTo : TerminalDb? = null
}