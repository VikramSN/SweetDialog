package com.vsn.sweetdialog.callbacks

import android.content.DialogInterface

interface DialogAction {

    fun singleAction(dialog: DialogInterface, position: Int)
}