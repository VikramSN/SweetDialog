package com.vsn.sweetdialog.callbacks

import android.content.DialogInterface

interface DialogMultiListAction {

    fun itemAction(dialog: DialogInterface?, position: Int, checked: Boolean)
}