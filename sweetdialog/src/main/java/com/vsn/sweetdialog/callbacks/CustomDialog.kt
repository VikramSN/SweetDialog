package com.vsn.sweetdialog.callbacks

import android.widget.LinearLayout
import android.widget.TextView

public interface CustomDialog {

    fun positive(positiveUi: TextView)

    fun negative(negativeUi: TextView)

    fun layout(layoutUi: LinearLayout)

    fun message(messageUi: TextView)

    fun title(titleUi: TextView)

}
