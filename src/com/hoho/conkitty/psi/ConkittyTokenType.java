package com.hoho.conkitty.psi;

import com.intellij.psi.tree.IElementType;
import com.hoho.conkitty.ConkittyLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ConkittyTokenType extends IElementType {
    public ConkittyTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ConkittyLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "ConkittyTokenType." + super.toString();
    }
}
