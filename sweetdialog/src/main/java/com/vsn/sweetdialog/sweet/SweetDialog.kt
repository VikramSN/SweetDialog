package com.vsn.sweetdialog.sweet

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.vsn.sweetdialog.R
import com.vsn.sweetdialog.callbacks.*


class SweetDialog {

    companion object {

        fun alertOne(
            context: Context,
            title: String,
            message: String,
            icon: Int,
            cancelable: Boolean,
            buttonText: String,
            action: DialogAction
        ) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setIcon(icon)
            builder.setMessage(message)
            builder.setCancelable(cancelable)
            builder.setNeutralButton(buttonText) { dialog, position ->
                action.singleAction(dialog, position)
            }
            val dialog = builder.create()
            dialog.show()
        }

        fun alertTwo(
            context: Context,
            title: String,
            message: String,
            icon: Int,
            cancelable: Boolean,
            positiveButtonText: String,
            negativeButtonText: String,
            action: DialogActionTwo
        ) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setMessage(message)
            builder.setIcon(icon)
            builder.setCancelable(cancelable)
            builder.setPositiveButton(positiveButtonText) { dialog, position ->
                action.positiveAction(dialog, position)
            }
            builder.setNegativeButton(negativeButtonText) { dialog, position ->
                action.negativeAction(dialog, position)
            }
            val dialog = builder.create()
            dialog.show()
        }

        fun alertThree(
            context: Context,
            title: String,
            message: String,
            icon: Int,
            cancelable: Boolean,
            positiveButtonText: String,
            negativeButtonText: String,
            neutralButtonText: String,
            action: DialogActionThree
        ) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setMessage(message)
            builder.setIcon(icon)
            builder.setCancelable(cancelable)
            builder.setPositiveButton(positiveButtonText) { dialog, position ->
                action.positiveAction(dialog, position)
            }

            builder.setNegativeButton(negativeButtonText) { dialog, position ->
                action.negativeAction(dialog, position)
            }

            builder.setNeutralButton(neutralButtonText) { dialog, position ->
                action.neutralAction(dialog, position)
            }
            val dialog = builder.create()
            dialog.show()
        }

        fun alertList(
            context: Context,
            title: String,
            dataList: Array<String>,
            icon: Int,
            cancelable: Boolean,
            action: DialogListAction
        ) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setIcon(icon)
            builder.setCancelable(cancelable)
            builder.setItems(dataList) { dialog, position ->
                action.itemAction(dialog, position)
            }
            val dialog = builder.create()
            dialog.show()
        }

        fun alertSingleChoice(
            context: Context,
            title: String,
            dataList: Array<String>,
            icon: Int,
            cancelable: Boolean,
            positiveButtonText: String,
            negativeButtonText: String,
            buttonAction: DialogActionTwo,
            listItemAction: DialogListAction
        ) {

            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setIcon(icon)
            builder.setCancelable(cancelable)
            builder.setSingleChoiceItems(dataList, 0) { dialog, position ->
                listItemAction.itemAction(dialog, position)
            }

            builder.setPositiveButton(positiveButtonText) { dialog, position ->
                buttonAction.positiveAction(dialog, position)
            }

            builder.setNegativeButton(negativeButtonText) { dialog, position ->
                buttonAction.negativeAction(dialog, position)
            }
            val dial = builder.create()
            dial.show()


        }

        fun alertMultiChoice(
            context: Context,
            title: String,
            dataList: Array<String>,
            booelanDataList: BooleanArray,
            icon: Int,
            cancelable: Boolean,
            positiveButtonText: String,
            negativeButtonText: String,
            buttonAction: DialogActionTwo,
            listItemAction: DialogMultiListAction
        ) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setIcon(icon)
            builder.setCancelable(cancelable)
            builder.setMultiChoiceItems(dataList, booelanDataList) { dialog, position, isChecked ->
                listItemAction.itemAction(dialog, position, isChecked)

            }

            builder.setPositiveButton(positiveButtonText) { dialog, position ->
                buttonAction.positiveAction(dialog, position)
            }

            builder.setNegativeButton(negativeButtonText) { dialog, position ->
                buttonAction.negativeAction(dialog, position)
            }

            val dial = builder.create()
            dial.show()


        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun alertCustom(context: Context, cancelable: Boolean, ui: CustomDialog) {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_alert)
            val v = dialog.window!!.decorView
            v.setBackgroundResource(android.R.color.transparent)
            dialog.setCancelable(cancelable)
            val titleUi = dialog.findViewById<TextView>(R.id.title)
            val messageUi = dialog.findViewById<TextView>(R.id.message)
            val positiveUi = dialog.findViewById<TextView>(R.id.positive)
            val negativeUi = dialog.findViewById<TextView>(R.id.negative)
            val layoutUi = dialog.findViewById<LinearLayout>(R.id.rootAlert)
            ui.layout(layoutUi)
            ui.message(messageUi)
            ui.title(titleUi)
            ui.positive(positiveUi)
            ui.negative(negativeUi)

            val window = dialog.window
            window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

            dialog.show()
        }

    }

}

