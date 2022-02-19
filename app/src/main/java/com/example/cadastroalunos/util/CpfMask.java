package com.example.cadastroalunos.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class CpfMask {

    private static final String maskCpf = "###.###.###-##";

    public static String unMask(String s) {
        return s.replaceAll("[^0-9]*", null);
    }

    //está "assistindo" o que você está digitando.
    public static TextWatcher insert(final EditText editText) {
        return new TextWatcher() {

            boolean isUpdating;
            String old = "";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String str = CpfMask.unMask(charSequence.toString());
                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }

                for (char m : maskCpf.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() &&
                            str.length() != i)) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (Exception ex) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                editText.setText(mascara);
                editText.setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }
}
