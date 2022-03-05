package com.example.cadastroalunos.util;

import android.view.View;
import android.widget.TextView;

import com.example.cadastroalunos.R;
import com.google.android.material.snackbar.Snackbar;

public class Util {


    /**
     * @SnackBar customizado
     * @param view : onde será exibido
     * @param msg : Mensagem
     * @param tipo : tipo do icone 8-erro, 1-sucesso, 2-atenção
     */

    public static void customSnackBar(View view, String msg, int tipo) {
        Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
        View viewSnack = snackbar.getView();
        TextView tv = (TextView) viewSnack.findViewById(R.id.snackbar_text);

        if (tipo == 0)
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(R.mipmap.ic_cancel, 0, 0, 0);
        if (tipo == 1)
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(R.mipmap.ic_confirm, 0, 0, 0);

        snackbar.show();
    }

}
