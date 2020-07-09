package com.hun.trpghelper.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.hun.trpghelper.R
import java.util.*

class DiceRollPopupFragment : DialogFragment() {

    private var diceFigure: Int? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater: LayoutInflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.layout_dialog_dice_roll, null)
        val textResultOfRoll: TextView = view.findViewById(R.id.text_result_of_roll)

        diceFigure = arguments?.getInt("figure")
        diceFigure?.let {
            val result: Int = rollTheDice(it)
            textResultOfRoll.text = result.toString()
        }

        builder
            .setView(view)
//            .setPositiveButton("Retry") { _, _ ->
//                if (diceFigure != null) {
//                    val result: Int = rollTheDice(diceFigure)
//                    textResultOfRoll.text = result.toString()
//                }
//            }
//            .setPositiveButton("Retry") { _, _ ->
//
//            }
            .setNegativeButton("Close") { _, _ ->
                this.dismiss()
            }

        return builder.create()
    }

//    override fun onStart() {
//        super.onStart()
//        val dialog: AlertDialog = dialog as AlertDialog
//
//        dialog.getButton(AlertDialog.BUTTON_POSITIVE)?.setOnClickListener {
//            diceFigure?.let {
//                val result: Int = rollTheDice(it)
//                textResultOfRoll.text = result.toString()
//            }
//        }
//    }

    private fun rollTheDice(figure: Int): Int {
        val random = Random()

        return random.nextInt(figure - 1) + 1
    }
}
