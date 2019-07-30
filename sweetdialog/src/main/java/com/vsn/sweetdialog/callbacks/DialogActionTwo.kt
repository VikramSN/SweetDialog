package com.vsn.sweetdialog.callbacks

import android.content.DialogInterface

interface DialogActionTwo {

    fun positiveAction(dialog: DialogInterface, position: Int)

    fun negativeAction(dialog: DialogInterface, position: Int)
}