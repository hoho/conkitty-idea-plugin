package com.hoho.conkitty;

import com.hoho.conkitty.psi.ConkittyTypes;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;

import java.io.IOException;

public class ConkittyLexer extends LookAheadLexer {
    public ConkittyLexer() {
        super(new FlexAdapter(new _ConkittyLexer() {
            @Override
            protected void readJavaScript(int state) throws IOException {
                final int start = getTokenStart();
                int braces = yycharat(0) == '(' ? 2 : 1;

                if (yycharat(0) != ')') {
                    while (true) {
                        final IElementType type = advance();

                        if (type == null) {
                            break;
                        }

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
                } else {
                    yypushback(1);
                }

                setStart(start);
                yybegin(state);
            }
        }));
    }

    protected static void setState(Lexer baseLexer, int state) {
        ((FlexAdapter)baseLexer).getFlex().yybegin(state);
    }
}
