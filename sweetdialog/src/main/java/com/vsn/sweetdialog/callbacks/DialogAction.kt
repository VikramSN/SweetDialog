package com.vsn.sweetdialog.callbacks

import android.content.DialogInterface

public interface DialogAction {

    fun singleAction(dialog: DialogInterface, position: Int)
}
