package com.hoho.conkitty;

import com.hoho.conkitty.psi.ConkittyTypes;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.lexer.LexerPosition;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import java.io.IOException;


public final class ConkittyLexer extends LookAheadLexer {
    public ConkittyLexer() {
        super(new FlexAdapter(new _ConkittyLexer() {
            @Override
            protected void readJavaScript(int state) throws IOException {
                final int start = getTokenStart();
                int braces = 1;
                while (true) {
                    final IElementType type = advance();
                    if (type == ConkittyTypes.JAVASCRIPT) {
                        switch (yycharat(0)) {
                            case '(':
                                braces++;
                                break;
                            case ')':
                                braces--;
                                break;
                        }

                        if (braces == 0) {
                            yypushback(1);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                setStart(start);
                yybegin(state);
            }
        }));
    }

    @Override
    protected void lookAhead(Lexer baseLexer) {
        final IElementType type = baseLexer.getTokenType();



        advanceAs(baseLexer, type);
    }

    private static void setState(Lexer baseLexer, int state) {
        ((FlexAdapter)baseLexer).getFlex().yybegin(state);
    }

}
