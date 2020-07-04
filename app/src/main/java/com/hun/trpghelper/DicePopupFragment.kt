package com.hun.trpghelper

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import java.util.*

class DicePopupFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater: LayoutInflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.layout_dialog_dice_roll, null)
        val textResultOfRoll: TextView = view.findViewById(R.id.text_result_of_roll)
        val diceFigure: Int? = arguments?.getInt("figure")

        if (diceFigure != null) {
            val result: Int = rollTheDice(diceFigure)
            textResultOfRoll.text = result.toString()
        }

        builder
            .setView(view)
            .setPositiveButton("OK") { _, _ ->
                this.dismiss()
            }
            .setNegativeButton("Cancel") { _, _ ->
                this.dismiss()
            }

        return builder.create()
    }

    private fun rollTheDice(figure: Int): Int {
        val result = -1
        val random = Random()

        return random.nextInt(figure - 1) + 1
    }
}
