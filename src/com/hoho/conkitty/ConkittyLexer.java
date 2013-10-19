package com.hoho.conkitty;

import com.hoho.conkitty.psi.ConkittyTypes;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.lexer.LookAheadLexer;


public final class ConkittyLexer extends LookAheadLexer {
    public ConkittyLexer()
    {
        super(new FlexAdapter(new _ConkittyLexer()));
    }
}
