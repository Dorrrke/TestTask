package com.dorrrke.test_task.adapters

import com.dorrrke.test_task.jsonModel.TerminalDb

interface TerminalClickListener {
    fun onTerminalClicked(terminalDb: TerminalDb)
}