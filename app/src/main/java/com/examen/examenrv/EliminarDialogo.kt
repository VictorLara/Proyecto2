package com.examen.examenrv

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class EliminarDialogo : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?):Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Alert Dialog")
        builder.setMessage("¿Desea eliminar el elemento?")
        builder.setPositiveButton("Sí", object: DialogInterface.OnClickListener {
            override fun onClick(dialog:DialogInterface, which:Int) {
                Singleton.deleteSelected()
                val intent= Intent(activity, MainActivity::class.java)
                startActivity(intent)
                //activity?.finish()
            }
        })
        builder.setNegativeButton("Cancelar", object: DialogInterface.OnClickListener {
            override fun onClick(dialog:DialogInterface, which:Int) {
                dismiss()
            }
        })
        return builder.create()
    }
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        //here fragment_my_dialog is the UI of Custom Dialog
//        return inflater.inflate(R.layout.fragment_dialog, container, false)
//    }

//    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val editText = view.findViewById<EditText>(R.id.inMobile)
//        if (arguments != null && !TextUtils.isEmpty(arguments?.getString("mobile")))
//            editText.setText(arguments?.getString("mobile"))
//        val btnDone = view.findViewById<Button>(R.id.btnDone)
//        btnDone.setOnClickListener(object: View.OnClickListener {
//            override fun onClick(view:View) {
//                val dialogListener = activity as DialogListener
//                dialogListener.onFinishEditDialog(editText.text.toString())
//                dismiss()
//            }
//        })
//    }
    override fun onResume() {
        super.onResume()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var  setFullScreen = false
        if (arguments != null) {
            setFullScreen = requireNotNull(arguments?.getBoolean("fullScreen"))
        }
        if (setFullScreen)
            setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
    }
}