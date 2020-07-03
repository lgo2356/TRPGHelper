package com.hun.trpghelper.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.icu.util.EthiopicCalendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.hun.trpghelper.R
import kotlinx.android.synthetic.main.layout_dialog_dice_add.*

class DiceAddDialogFragment : DialogFragment() {

    private var diceAddListener: OnDiceAddListener? = null

    interface OnDiceAddListener {
        fun onDiceAdd(name: String, figure: Int)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater: LayoutInflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.layout_dialog_dice_add, null)
        val editName: EditText = view.findViewById(R.id.edit_name)
        val editFigure: EditText = view.findViewById(R.id.edit_figure)

        builder
            .setView(view)
            .setTitle("주사위 추가")
            .setPositiveButton("OK") { _, _ ->
                val diceName: String = editName.text.toString()
                val diceFigure: Int = editFigure.text.toString().toInt()
                diceAddListener?.onDiceAdd(diceName, diceFigure)
            }
            .setNegativeButton("Cancel") { _, _ ->
                this.dismiss()
            }

        return builder.create()
    }

    fun setOnDiceAddListener(listener: OnDiceAddListener) {
        this.diceAddListener = listener
    }

    override fun onDetach() {
        super.onDetach()
        diceAddListener = null
    }
}
