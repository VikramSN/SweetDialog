package com.vsn.sweetdialog.callbacks

import android.content.DialogInterface

interface DialogListAction {

    fun itemAction(dialog: DialogInterface, position: Int)
}