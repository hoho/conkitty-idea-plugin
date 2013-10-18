package com.hoho.conkitty;

import com.intellij.lang.Language;


public class ConkittyLanguage extends Language  {
    public static final ConkittyLanguage INSTANCE = new ConkittyLanguage();

    private ConkittyLanguage() {
        super("Conkitty");
    }
}
