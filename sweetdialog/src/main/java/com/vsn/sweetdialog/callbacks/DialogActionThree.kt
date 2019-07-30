package com.vsn.sweetdialog.callbacks

import android.content.DialogInterface

interface DialogActionThree {

    fun positiveAction(dialog: DialogInterface, position: Int)

    fun negativeAction(dialog: DialogInterface, position: Int)

    fun neutralAction(dialog: DialogInterface, position: Int)

}