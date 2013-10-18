package com.hoho.conkitty.psi;

import com.intellij.psi.tree.IElementType;
import com.hoho.conkitty.ConkittyLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ConkittyElementType extends IElementType {
    public ConkittyElementType(@NotNull @NonNls String debugName) {
        super(debugName, ConkittyLanguage.INSTANCE);
    }
}
